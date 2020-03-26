package com.wan.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @项目名称：Wan_Cloud_Study
 * @类名称：RibbonConfig
 * @类描述：负载均衡配置
 * @创建人：万星明
 * @创建时间：2019/12/17
 */

@Configuration
public class RibbonConfig
{

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate()
    {
        return new RestTemplate();
    }

}
