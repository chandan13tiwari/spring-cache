package com.example.caching.controller;

import org.slf4j.Logger;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import static org.slf4j.LoggerFactory.getLogger;

@RestController
public class CacheController {
    private static final Logger logger = getLogger(CacheController.class);

    @GetMapping(value = "/test")
    @Cacheable(value = "testCache", key = "#correlationId")
    public String getTest(@RequestHeader("AX-Correlation-ID") String correlationId) throws InterruptedException {
        logger.info("Inside Test endpoint...");

        // Business Logic Implementation
        logger.info("Please wait... We are still Processing your Data!!");
        Thread.sleep(9000);

        logger.info("Thanks for waiting... Data Processed!");

        return "Data Processed Successfully";
    }

}
