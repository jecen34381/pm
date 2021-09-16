package com.example.pm.logger;

import org.slf4j.Logger;

public class loggerUtil {

    private String loggerId;
    private Logger logger;

    public loggerUtil(String loggerId, Logger logger){
        this.loggerId = loggerId;
        this.logger = logger;
    }
    /**
     * 封装logger
     * @param logger
     * @param message
     */
    public void info(Logger logger, String message){
        logger.info(loggerId + "       " + message );
    }
}
