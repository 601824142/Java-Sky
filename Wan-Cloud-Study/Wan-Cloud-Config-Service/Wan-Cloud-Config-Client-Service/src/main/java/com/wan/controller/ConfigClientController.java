package com.wan.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @项目名称：wan-cloud-study
 * @类名称：ConfigClientController
 * @类描述：配置文件接口
 * @创建人：万星明
 * @创建时间：2020/1/17
 */

/**
 * RefreshScope注解刷新配置
 */

@RestController
@RefreshScope
public class ConfigClientController
{

    @Value("${wan.config.version}")
    private String version;

    @GetMapping("/getVersion")
    public String getVersion()
    {
        return version;
    }


}
