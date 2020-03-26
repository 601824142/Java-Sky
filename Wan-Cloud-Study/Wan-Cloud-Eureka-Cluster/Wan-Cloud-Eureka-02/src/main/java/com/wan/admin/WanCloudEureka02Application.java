package com.wan.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication(scanBasePackages = "com.wan")
public class WanCloudEureka02Application {

    public static void main(String[] args) {
        SpringApplication.run( WanCloudEureka02Application.class,args );
    }

}
