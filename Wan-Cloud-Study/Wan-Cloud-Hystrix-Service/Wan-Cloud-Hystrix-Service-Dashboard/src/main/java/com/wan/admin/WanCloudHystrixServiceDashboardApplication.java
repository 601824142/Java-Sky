package com.wan.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;


@EnableHystrixDashboard
@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = "com.wan")
public class WanCloudHystrixServiceDashboardApplication {

    public static void main(String[] args) {
        SpringApplication.run( WanCloudHystrixServiceDashboardApplication.class,args );
    }

}
