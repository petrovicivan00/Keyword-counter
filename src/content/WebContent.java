package content;

import core.Res;
import log.Log;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.stream.Collectors;

public class WebContent implements Content {

    @Override
    public String getContent(String path) {
        HttpURLConnection http = null;
        String page = null;

        try {
            URL url = new URL(path);
            http = (HttpURLConnection) url.openConnection();
            http.connect();
            Log.i(Res.INFO_SCAN_WEB + " " + path);
            InputStream is = http.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);

            page = br.lines().collect(Collectors.joining("\n"));

            br.close();
            isr.close();
            is.close();
        } catch (Exception e) {
            Log.e(String.format(Res.FORMAT_ERROR, Res.ERROR_SCAN_WEB, path));
        } finally {
            if (http != null) {
                http.disconnect();
            }
        }

        return page != null ? page : "";
    }
}
