package logging_exercise;

import sun.reflect.annotation.ExceptionProxy;

import java.io.*;
import java.nio.channels.AsynchronousFileChannel;


/**
 * Created by Nestor on 4/23/15.
 */
public class AsyncLogger implements ILogWriter {

    LogLevel currentLevel;
    AsynchronousFileChannel asyncFile;
    String path;

    public AsyncLogger(String path, LogLevel cLevel) {
        currentLevel = cLevel;
        this.path = path;

    }

    @Override
    public synchronized void log(String message, LogLevel cLevel) {
        if(cLevel.compareTo(currentLevel) <= 0) {

            Thread th = new Thread(new AsyncWriter(message));
            th.start();
        }

    }

    private class AsyncWriter implements Runnable {

        String currentMessage;

        public AsyncWriter(String message)
        {
            currentMessage = message;
        }

        @Override
        public void run()
        {
            File file = new File(path);
            BufferedWriter writer = null;
            try {
                 writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file,true)));
                writer.write(currentMessage);
                writer.newLine();
                writer.flush();

            }catch (IOException ex){

            }
            finally {
                try {
                    writer.close();
                }catch(IOException exc) {
                    //do nothing
                }
            }
        }
    }
}
