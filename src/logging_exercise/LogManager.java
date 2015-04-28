package logging_exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nestor on 4/23/15.
 */
public class LogManager {

    List<LogWriter> loggers = new ArrayList<>();

    public LogManager() {
    }

    public void addLogger(LogWriter logger) {
        loggers.add(logger);
    }

    public void removeLogger(LogWriter logger) {
        if (loggers.contains(logger)) {
            loggers.remove(logger);
        }
    }

    public void logMessage(String message, LogLevel cLevel) {
        for (LogWriter logger : loggers) {
            logger.log(message, cLevel);
        }
    }


}
