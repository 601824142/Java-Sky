package com.wan.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @项目名称：wan_cloud_eureka_cluster
 * @类名称：WebSecurityConfig eureka开启验证后无法连接注册中心
 * @类描述：spring Cloud 2.0 以上的security默认启用了csrf检验，要在eurekaServer端配置security的csrf检验为false
 * @创建人：万星明
 * @创建时间：2019/4/20
 */

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter
{

    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        http.csrf().disable();
        super.configure(http);
    }

}
