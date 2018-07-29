package com.wwjswly.dubbo.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.wwjswly.dubbo.consumer.controller")
public class DubboConsumerApplication {
    private static final Logger logger = LoggerFactory.getLogger(DubboConsumerApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(DubboConsumerApplication.class, args);
    }
}
