package com.wan.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 开启Hystrix的断路器功能
 */

@EnableCircuitBreaker
@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = "com.wan")
public class WanCloudHystrixServiceImplApplication {

    public static void main(String[] args) {
        SpringApplication.run( WanCloudHystrixServiceImplApplication.class,args );
    }

}
