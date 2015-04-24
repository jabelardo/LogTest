package logging_exercise;

import junit.framework.TestCase;

import java.nio.file.Files;
import java.io.File;
import java.util.List;

/**
 * Created by Nestor on 4/23/15.
 */
public class FileLogWritterTest extends TestCase {

    public void testLogAppropiateLevel() throws Exception {

        String path = "test.txt";
        ILogWriter logger =  LoggerFactory.GetLogger("file", LogLevel.DEBUG, path);

        logger.log("this is a debug message", LogLevel.DEBUG);
        logger.log("error message", LogLevel.ERROR);
        logger.log("this is an info message", LogLevel.INFO);

        File file = new File(path);
        file.deleteOnExit();
        List<String> content = Files.readAllLines(file.toPath());

        assertTrue("Log message was not written to file", content.contains("this is a debug message"));

        assertFalse("file should not contain error message", content.contains("error message"));

        assertTrue("file should include info message", content.contains("this is an info message"));

    }


}
