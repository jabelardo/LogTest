package logging_exercise;

import java.io.*;

/**
 * Created by Nestor on 4/22/15.
 */
public class FileLogWritter implements ILogWriter {

    private String path;
    private LogLevel currentLevel;

    public FileLogWritter(String path, LogLevel cLevel){
        this.path = path;
        currentLevel  = cLevel;
    }

    @Override
    public synchronized void log(String message, LogLevel cLevel) {

        if (cLevel.compareTo(currentLevel) <= 0){

            File file = new File(path);

            BufferedWriter writer = null;

            try {
                writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file,true)));
                writer.write(message);
                writer.newLine();
                writer.flush();


            } catch (IOException ex) {

            } finally {
                try {
                    writer.close();
                } catch (Exception ex) { //do nothing
                }
            }
        }

    }
}
