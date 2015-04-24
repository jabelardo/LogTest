package logging_exercise;

import java.util.ArrayList;

/**
 * Created by Nestor on 4/23/15.
 */
public class LogManager  {

    ArrayList<ILogWriter> loggers = null;

    public LogManager() {
        loggers = new ArrayList<ILogWriter>();



    }

    public void AddLogger(ILogWriter logger) {
        loggers.add(logger);
    }

    public void RemoveLogger (ILogWriter logger) {
        if(loggers.contains(logger)) {
            loggers.remove(logger);
        }
    }

    public void LogMessage(String message, LogLevel cLevel) {

        for(ILogWriter logger : loggers) {
            logger.log(message, cLevel);
        }
    }


}
