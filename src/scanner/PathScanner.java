package scanner;

import job.Job;
import result.Result;

public interface PathScanner {

    void scanJobPath(Job job);

    Result publishResult(Job job);

    void stop();
}
