package content;

import core.Res;
import log.Log;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileContent implements Content {

    @Override
    public String getContent(String path) {
        String file = null;

        try {
            file = Files.readString(Paths.get(path));
        } catch (IOException e) {
            Log.e(String.format(Res.FORMAT_ERROR, Res.ERROR_SCAN_FILE, path));
        }

        return file != null ? file : "";
    }
}
