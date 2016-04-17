package com.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WithInjectLoggerService {


    Logger logger = LoggerFactory.getLogger(this.getClass());

    public boolean injected() {

        if(logger != null) {
            logger.debug("Logger created.");
            logger.error("Logger created.");
            logger.warn("Logger created.");
            logger.info("Logger created.");
            return true;
        }
        return false;
    }
}
