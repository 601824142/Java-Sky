package com.wan.controller;

import com.wan.common.ResponseInfo;
import com.wan.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @项目名称：Wan_Cloud_Study
 * @类名称：UserRibbonController
 * @类描述：用户负载均衡
 * @创建人：万星明
 * @创建时间：2019/12/17
 */

@RestController
@RequestMapping("/user")
public class UserRibbonController
{

    @Autowired
    private RestTemplate restTemplate;

    @Value("${service-url.user-service}")
    private String userServiceUrl;

    @PostMapping("/addUser")
    public ResponseInfo addUser(@RequestBody User user)
    {
        return restTemplate.postForObject(userServiceUrl + "/user/addUser", user, ResponseInfo.class);
    }

}
