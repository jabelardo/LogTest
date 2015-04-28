package logging_exercise;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * Created by jabelardo on 4/28/15.
 */
public abstract class FileUtil {
    public static void logMessage(String path, String message) {
        File file = new File(path);
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true)))) {
            writer.write(message);
            writer.newLine();
            writer.flush();
        } catch (IOException e) {
            throw new LogException(e);
        }
    }
}
