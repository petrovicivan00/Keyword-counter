package crawler;

import job.ScanType;

public interface PathCrawler {

    void addPath(String path, ScanType scanType);

    void stop();
}
