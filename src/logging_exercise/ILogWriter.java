package logging_exercise;

/**
 * Created by Nestor on 4/21/15.
 */
public interface ILogWriter {

    void log(String message, LogLevel cLevel);
}
