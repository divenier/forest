package com.rymcu.forest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author ronger
 */
@SpringBootApplication
public class ForestApplication {
    private static Logger logger = LoggerFactory.getLogger(ForestApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(ForestApplication.class, args);
        logger.info("启动完毕");
    }

}
