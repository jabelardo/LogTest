package logging_exercise;

/**
 * Created by Nestor on 4/21/15.
 */
public class ConsoleLogWriter extends LogWriter {

    public ConsoleLogWriter(LogLevel cLevel) {
        super(cLevel);
    }

    @Override
    protected void logMessage(String message) {
        System.out.println(message);
    }
}
