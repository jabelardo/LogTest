package logging_exercise;

/**
 * Created by Nestor on 4/22/15.
 */
public class FileLogWriter extends LogWriter {

    private String path;

    public FileLogWriter(String path, LogLevel cLevel) {
        super(cLevel);
        this.path = path;
    }

    @Override
    protected synchronized void logMessage(String message) {
        FileUtil.logMessage(path, message);
    }
}
