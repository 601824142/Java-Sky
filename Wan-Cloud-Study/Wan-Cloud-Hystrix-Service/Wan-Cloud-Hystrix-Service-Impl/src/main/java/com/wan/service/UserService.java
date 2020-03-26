package com.wan.service;

import com.wan.common.ResponseInfo;
import com.wan.pojo.User;

import java.util.concurrent.Future;

/**
 * @项目名称：Wan-Cloud-Study
 * @类名称：UserService
 * @类描述：业务
 * @创建人：万星明
 * @创建时间：2019/12/19
 */
public interface UserService
{
    /**
     * 1、添加用户
     * @param user 用户
     * @return 响应
     */
    ResponseInfo addUser(User user);

    /**
     * 2、查询用户(设置分组、命令、线程池)
     * @param userId 用户ID
     * @return 用户
     */
    ResponseInfo getUser(Integer userId);

    /**
     * 3、查询用户(使用IgnoreException忽略异常降级)
     * @param userId 用户ID
     * @return 用户
     */
    ResponseInfo getUserIgnoreException(Integer userId);

    /**
     * 4、查询用户(请求缓存)
     * @param userId 用户ID
     * @return 用户
     */
    ResponseInfo getUserCache(Integer userId);

    /**
     * 5、查询用户(移除缓存)
     * @param userId 用户ID
     */
    ResponseInfo removeCache(Integer userId);

    /**
     * 6、查询用户(请求合并)
     * @param userId 用户ID
     * @return 响应
     */
    Future<User> getUserFuture(Integer userId);
}
