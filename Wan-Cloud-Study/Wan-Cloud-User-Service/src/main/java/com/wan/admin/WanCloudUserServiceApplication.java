package com.wan.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.wan.dao")
@SpringBootApplication(scanBasePackages = "com.wan")
public class WanCloudUserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run( WanCloudUserServiceApplication.class,args );
    }

}
