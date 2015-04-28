package logging_exercise;

/**
 * Created by Nestor on 4/21/15.
 */
public enum LogLevel {

    INFO(0), DEBUG(1), WARN(2), ERROR(3);

    private int value;

    LogLevel(int value) {
        this.value = value;
    }

}
