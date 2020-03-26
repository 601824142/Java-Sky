package com.wan.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.wan")
public class JavaBasicApplication {

    public static void main(String[] args) {
        SpringApplication.run( JavaBasicApplication.class,args );
    }

}
