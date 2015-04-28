package logging_exercise;

import junit.framework.TestCase;

/**
 * Created by Nestor on 4/23/15.
 */
public class LoggerFactoryTest extends TestCase {

    public void testGetLogger() throws Exception {
        LogWriter logger = LoggerFactory.GetLogger("console",LogLevel.INFO,null);

        assertTrue("logger is ConsoleLogWriter", logger instanceof ConsoleLogWriter );

        logger = LoggerFactory.GetLogger("file", LogLevel.DEBUG,"test2.txt");

        assertTrue("logger is FileLogWriter", logger instanceof FileLogWriter);


    }
}