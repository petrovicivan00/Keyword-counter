package core;

import crawler.CrawlerDispatcher;
import job.*;
import log.Log;
import result.ResultRetriever;
import result.ResultRetrieverPool;

class Commander {

    private JobQueue jobQueue;
    private JobDispatcher jobDispatcher;
    private CrawlerDispatcher crawlerDispatcher;
    private ResultRetriever resultRetriever;

    Commander() {
        jobQueue = new ScanningJobQueue();
        resultRetriever = new ResultRetrieverPool();
        crawlerDispatcher = new CrawlerDispatcher(jobQueue);
        jobDispatcher = new JobDispatcher(jobQueue, resultRetriever);
    }

    void startThreads() {
        Log.i(Res.INFO_START_THREADS);

        jobDispatcher.start();
    }

    void stopThreads() {
        Log.i(Res.INFO_STOP_THREADS);

        resultRetriever.stop();
        crawlerDispatcher.stop();

        try {
            jobQueue.enqueue(new Job());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    void addDirectory(String path, int params) {
        Log.i(Res.INFO_ADD_DIRECTORY + " " + path);

        if (paramsOk(params, 1)) {
            crawlerDispatcher.addPath(path, ScanType.FILE);
        }
    }

    void addWeb(String domain, int params) {
        Log.i(Res.INFO_ADD_WEB + " " + domain);

        if (paramsOk(params, 1)) {
            crawlerDispatcher.addPath(domain, ScanType.WEB);
        }
    }

    void getResultSync(String query, int params) {
        Log.i(Res.INFO_GET_RESULT_SYNC + " for " + query);

        if (paramsOk(params, 1)) {
            resultRetriever.handleQuery(query, true);
        }
    }

    void getResultAsync(String query, int params) {
        Log.i(Res.INFO_GET_RESULT_ASYNC + " for " + query);

        if (paramsOk(params, 1)) {
            resultRetriever.handleQuery(query, false);
        }
    }

    void clearSummaryFile(int params) {
        Log.i(Res.INFO_CLEAR_SUMMARY_FILE);

        if (paramsOk(params, 0)) {
            resultRetriever.clearSummary(ScanType.FILE);
        }
    }

    void clearSummaryWeb(int params) {
        Log.i(Res.INFO_CLEAR_SUMMARY_WEB);

        if (paramsOk(params, 0)) {
            resultRetriever.clearSummary(ScanType.WEB);
        }
    }

    private boolean paramsOk(int provided, int required) {
        boolean paramsOk = provided == required;

        if (!paramsOk) {
            Log.e(Res.ERROR_PARSE_COMMAND);
        }

        return paramsOk;
    }
}
