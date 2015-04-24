package logging_exercise;

import java.nio.channels.AsynchronousFileChannel;

/**
 * Created by Nestor on 4/21/15.
 */
public class ConsoleLogWriter implements ILogWriter{

    LogLevel currentLevel;

    public ConsoleLogWriter(LogLevel cLevel) {
        this.currentLevel = cLevel;
    }

    @Override
    public void log(String message, LogLevel cLevel) {
        if( cLevel.compareTo(currentLevel) <= 0)
            System.out.println(message);
    }
}
