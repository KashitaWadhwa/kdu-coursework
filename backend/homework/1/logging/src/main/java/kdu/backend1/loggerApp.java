package kdu.backend1;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class loggerApp {
    Logger logger=LoggerFactory.getLogger(loggerApp.class);

    public void logger(String msge){
        logger.debug(msge);
    }
}