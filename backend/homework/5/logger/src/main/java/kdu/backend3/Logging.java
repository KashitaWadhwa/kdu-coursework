package kdu.backend3;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Logging {
    private static final Logger logger = LoggerFactory.getLogger(kdu.backend3.Logging.class);

    public static void logInfo(String msg)
    {
        logger.info(msg);
    }

    public void logWarn(String msg){
        logger.warn(msg);
    }
}