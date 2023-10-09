package log;

import core.Res;

public class Log {

    private static final Logger[] loggers = new Logger[]{
            new ConsoleLogger(),
            new FileLogger()
    };

    public static void e(String message) {
        log(Res.TITLE_ERROR, message, true, true);
    }

    public static void i(String message) {
        log(Res.TITLE_INFO, message, true, false);
    }

    public static void d(String message) {
        log(Res.TITLE_DEBUG, message, true, false);
    }

    public static void input(String message) {
        log(message, Res.FORMAT_INPUT, false, false);
    }

    private static void log(String tag, String message, boolean breakLine, boolean error) {
        for (Logger logger : loggers) {
            logger.log(String.format(Res.FORMAT_LOG, tag, message), breakLine, error);
        }
    }
}
