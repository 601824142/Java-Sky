package com.wan.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(basePackages = "com.wan")
@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = "com.wan")
public class WanCloudFeignServiceImplApplication {

    public static void main(String[] args) {
        SpringApplication.run( WanCloudFeignServiceImplApplication.class,args );
    }

}
