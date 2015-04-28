package logging_exercise;

/**
 * Created by Nestor on 4/21/15.
 */
public abstract class LogWriter {

    private LogLevel currentLevel;

    protected LogWriter(LogLevel currentLevel) {
        this.currentLevel = currentLevel;
    }

    public void setCurrentLevel(LogLevel currentLevel) {
        this.currentLevel = currentLevel;
    }

    public final void log(String message, LogLevel cLevel) {
        if (cLevel.compareTo(currentLevel) <= 0) {
            logMessage(message);
        }
    }

    protected abstract void logMessage(String message);
}
