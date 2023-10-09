package result;

import job.ScanType;

public interface ResultRetriever {

    void addResult(Result result);

    void handleQuery(String query, boolean sync);

    void clearSummary(ScanType scanType);

    void stop();
}
