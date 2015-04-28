package logging_exercise;

/**
 * Created by Nestor on 4/23/15.
 */
public class AsyncLogger extends LogWriter {

    String path;

    public AsyncLogger(String path, LogLevel cLevel) {
        super(cLevel);
        this.path = path;
    }

    @Override
    protected synchronized void logMessage(String message) {
        Runnable task = () -> FileUtil.logMessage(path, message);
        new Thread(task).start();
    }
}
