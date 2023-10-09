package scanner;

import content.Content;
import content.WebContent;
import job.Job;
import result.ResultRetriever;

public class WebScannerPool extends AbstractScanner {

    public WebScannerPool(ResultRetriever resultRetriever) {
        super(resultRetriever);
    }

    @Override
    protected Content getContent() {
        return new WebContent();
    }

    @Override
    public void scanJobPath(Job job) {
        super.scanJobBuffer(job);
    }
}
