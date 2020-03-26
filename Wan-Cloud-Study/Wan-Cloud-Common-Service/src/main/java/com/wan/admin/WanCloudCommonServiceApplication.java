package com.wan.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.wan")
public class WanCloudCommonServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run( WanCloudCommonServiceApplication.class,args );
    }

}
