package logging_exercise;

/**
 * Created by Nestor on 4/22/15.
 */
public class LoggerFactory {
    public static ILogWriter GetLogger(String loggertype, LogLevel cLevel, String path){
        switch(loggertype) {
            case "console":
                return new ConsoleLogWriter(cLevel);
            case "file":
                return new FileLogWritter(path, cLevel);
            default:
                return new ConsoleLogWriter(cLevel);
            }
        }

    }

