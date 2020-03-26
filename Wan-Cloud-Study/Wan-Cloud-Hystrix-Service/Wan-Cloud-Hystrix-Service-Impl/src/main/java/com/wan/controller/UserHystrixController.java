package com.wan.controller;

import com.wan.common.ResponseInfo;
import com.wan.pojo.User;
import com.wan.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;


/**
 * @项目名称：Wan-Cloud-Study
 * @类名称：UserHystrixController
 * @类描述：熔断接口
 * @创建人：万星明
 * @创建时间：2019/12/19
 */
@RestController
@RequestMapping("/user")
public class UserHystrixController
{

    private static final Logger logger = LoggerFactory.getLogger( UserHystrixController.class);


    @Autowired
    private UserService userService;

    /**
     * 1、添加用户
     * @param user 用户
     * @return 响应
     */
    @PostMapping("/addUser")
    public ResponseInfo addUser(@RequestBody User user)
    {
        return userService.addUser(user);
    }


    /**
     * 2、查询用户(设置分组、命令、线程池)
     * @param userId 用户ID
     * @return 用户
     */
    @GetMapping("/getUser/{userId}")
    public ResponseInfo getUser(@PathVariable Integer userId)
    {
        return userService.getUser(userId);
    }


    /**
     * 3、查询用户(使用IgnoreException忽略异常降级)
     * @param userId 用户ID
     * @return 用户
     */
    @GetMapping("/getUserIgnoreException/{userId}")
    public ResponseInfo getUserIgnoreException(@PathVariable Integer userId)
    {
        return userService.getUserIgnoreException(userId);
    }


    /**
     * 4、查询用户(请求缓存)
     * @param userId 用户ID
     * @return 用户
     */
    @GetMapping("/getUserCache/{userId}")
    public ResponseInfo getUserCache(@PathVariable Integer userId)
    {
        ResponseInfo userCache1 = userService.getUserCache( userId );
        ResponseInfo userCache2 = userService.getUserCache( userId );
        ResponseInfo userCache3 = userService.getUserCache( userId );
        logger.error("缓存:{},{},{}",userCache1,userCache2,userCache3);
        return userCache1;
    }


    /**
     * 5、查询用户(移除缓存)
     * @param userId 用户ID
     * @return 用户
     */
    @GetMapping("/getUserRemoveCache/{userId}")
    public ResponseInfo getUserRemoveCache(@PathVariable Integer userId)
    {
        ResponseInfo userCache1 = userService.getUserCache( userId );
        ResponseInfo removeCache = userService.removeCache( userId );
        ResponseInfo userCache2 = userService.getUserCache( userId );
        logger.error("缓存:{},{},{}",userCache1,removeCache,userCache2);
        return userCache1;
    }


    /**
     * 6、查询用户(请求合并)
     * @return 用户
     */
    @GetMapping("/getUserRequestMerge")
    public ResponseInfo<Integer> getUserRequestMerge() throws InterruptedException, ExecutionException
    {
        Future<User> future1 = userService.getUserFuture(18);
        Future<User> future2 = userService.getUserFuture(19);
        logger.error("请求合并1+2:{},{}",future1.get(),future2.get());
        Thread.sleep(200);
        Future<User> future3 = userService.getUserFuture(20);
        logger.error("请求合并3:{}",future3.get());

        ResponseInfo<Integer> responseInfo = new ResponseInfo<>();
        responseInfo.setData(1);
        return responseInfo;
    }







}
