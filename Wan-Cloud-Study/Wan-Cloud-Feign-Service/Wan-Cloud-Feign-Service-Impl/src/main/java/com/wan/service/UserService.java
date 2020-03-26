package com.wan.service;

import com.wan.common.ResponseInfo;
import com.wan.pojo.User;
import com.wan.service.impl.UserFallbackServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;

import java.util.List;

/**
 * @项目名称：wan-cloud-study
 * @类名称：UserService
 * @类描述：用户服务
 * @创建人：万星明
 * @创建时间：2020/1/15
 */

@FeignClient(value = "wan-cloud-user-service",fallback = UserFallbackServiceImpl.class,path ="/user")
public interface UserService
{

    /**
     * 1、添加用户
     * @param user 用户
     * @return 响应
     */
    @PostMapping(value = "/addUser")
    ResponseInfo addUser(@RequestBody User user);

    /**
     * 2、查询用户
     * @param userId 用户ID
     * @return 响应
     */
    @GetMapping(value = "/getUser/{userId}")
    ResponseInfo getUser(@PathVariable("userId") Integer userId);

    /**
     * 3、批量查询用户
     * @param userIdList 用户ID列表
     * @return 响应
     */
    @PostMapping(value = "/getUserByUserIdList")
    ResponseInfo getUserByUserIds(@RequestBody List<Integer> userIdList);

    /**
     * 4、根据昵称查询用户列表
     * @param username 昵称
     * @return 响应
     */
    @GetMapping(value = "/getUserByName")
    ResponseInfo getUserByName(@RequestParam String username);

    /**
     * 5、修改用户
     * @param user 用户
     * @return 响应
     */
    @PostMapping(value = "/updateUser")
    ResponseInfo updateUser(@RequestBody User user);

    /**
     * 6、删除用户
     * @param userId 用户ID
     * @return 响应
     */
    @GetMapping(value = "/deleteUser/{userId}")
    ResponseInfo deleteUser(@PathVariable Integer userId);


}
