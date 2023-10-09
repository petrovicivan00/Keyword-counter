package job;

import result.ResultRetriever;
import scanner.FileScannerPool;
import scanner.PathScanner;
import scanner.WebScannerPool;

import java.util.HashMap;
import java.util.Map;

public class JobDispatcher {

    private final JobQueue jobQueue;
    private final Map<ScanType, PathScanner> scanners;
    private final Thread thread;

    public JobDispatcher(JobQueue jobQueue, ResultRetriever resultRetriever) {
        this.jobQueue = jobQueue;

        scanners = new HashMap<>();
        scanners.put(ScanType.FILE, new FileScannerPool(resultRetriever));
        scanners.put(ScanType.WEB, new WebScannerPool(resultRetriever));

        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                dispatchJobs();
            }
        });
        thread.setDaemon(true);
    }

    private void dispatchJobs() {
        while (true) {
            try {
                Job job = jobQueue.dequeue();
                ScanType scanType = job.getScanType();

                if (scanType == ScanType.STOP) {
                    for (PathScanner scanner : scanners.values()) {
                        scanner.stop();
                    }

                    break;
                }

                scanners.get(scanType).scanJobPath(job);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public void start() {
        thread.start();
    }
}
