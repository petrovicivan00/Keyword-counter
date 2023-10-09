package crawler;

import content.WebContent;
import core.Property;
import core.Res;
import job.JobQueue;
import job.ScanType;
import log.Log;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class WebCrawler extends AbstractCrawler {

    private final Set<String> scannedPaths;
    private final long URL_REFRESH_TIMEOUT;

    WebCrawler(JobQueue jobQueue) {
        super(jobQueue);

        scannedPaths = Collections.newSetFromMap(new ConcurrentHashMap<>());
        URL_REFRESH_TIMEOUT = Long.parseLong(Property.URL_REFRESH_TIME.get());

        startRefreshThread();
    }

    @Override
    protected void crawl(String path) {
        boolean invalidPath = false;

        List<Stack<String>> hops = new LinkedList<>();
        Stack<String> base = new Stack<>();
        base.push(path);
        hops.add(base);

        WebContent content = new WebContent();

        for (int i = 0; i < getHopCount(); i++) {
            Stack<String> hop = new Stack<>();

            for (String parentUrl : hops.get(i)) {
                String page = content.getContent(parentUrl);

                if (page.isEmpty()) {
                    invalidPath = true;
                    break;
                }

                Pattern p = Pattern.compile(Res.FORMAT_URL);
                Matcher m = p.matcher(page);

                while (m.find()) {
                    String url = m.group().replace(" ", "%20");
                    hop.push(url);
                    addJob(url, ScanType.WEB);
                }
            }

            if (invalidPath) {
                break;
            }

            hops.add(hop);
        }

        if (!invalidPath) {
            addJob(path, ScanType.WEB);
        }
    }

    @Override
    protected void addJob(String path, ScanType scanType) {
        if (!scannedPaths.contains(path)) {
            scannedPaths.add(path);
            super.addJob(path, scanType);
        }
    }

    private void startRefreshThread() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(URL_REFRESH_TIMEOUT);
                    scannedPaths.clear();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });
        thread.setDaemon(true);
        thread.start();
    }

    private int getHopCount() {
        int hopCount = 0;

        try {
            hopCount = Integer.parseInt(Property.HOP_COUNT.get());
        } catch (NumberFormatException e) {
            Log.e(Res.ERROR_HOP_COUNT);
        }

        return hopCount;
    }
}
