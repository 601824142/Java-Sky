package com.wan.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = "com.wan")
public class WanCloudRibbonServiceImplApplication {

    public static void main(String[] args) {
        SpringApplication.run( WanCloudRibbonServiceImplApplication.class,args );
    }

}
