package logging_exercise;

/**
 * Created by Nestor on 4/22/15.
 */
public class LoggerFactory {
    public static LogWriter GetLogger(String loggertype, LogLevel cLevel, String path) {
        switch (loggertype.toLowerCase()) {
            case "file":
                return new FileLogWriter(path, cLevel);
            case "async":
                return new AsyncLogger(path, cLevel);
            case "console":
            default:
                return new ConsoleLogWriter(cLevel);
        }
    }

}

