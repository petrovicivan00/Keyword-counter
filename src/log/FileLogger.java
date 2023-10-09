package log;

import core.Res;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

class FileLogger implements Logger {

    @Override
    public void log(String message, boolean breakLine, boolean error) {
        PrintWriter writer = null;

        try {
            writer = new PrintWriter(new FileWriter(Res.PATH_LOG, true));
            writer.print(message);

            if (breakLine) {
                writer.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }
}
