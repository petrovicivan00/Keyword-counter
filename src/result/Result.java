package result;

import job.Job;
import job.ScanType;

import java.util.HashMap;
import java.util.Map;

public class Result {

    private final Job job;
    private final Map<String, Integer> counts;

    public Result(Job job) {
        this.job = job;

        counts = new HashMap<>();
    }

    public void combine(Map<String, Integer> counts) {
        this.counts.putAll(counts);
    }

    public boolean isDone() {
        return counts != null;
    }

    public String getPath() {
        return job.getPath();
    }

    public ScanType getScanType() {
        return job.getScanType();
    }

    public Map<String, Integer> getCounts() {
        return counts;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Result result) {
            return result.job.equals(job);
        }

        return false;
    }

    @Override
    public int hashCode() {
        return job.hashCode();
    }
}
