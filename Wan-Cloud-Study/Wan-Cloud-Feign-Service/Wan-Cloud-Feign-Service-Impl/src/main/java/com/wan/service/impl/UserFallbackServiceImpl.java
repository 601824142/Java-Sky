package com.wan.service.impl;

import com.wan.common.ResponseInfo;
import com.wan.pojo.User;
import com.wan.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @项目名称：wan-cloud-study
 * @类名称：UserFallbackService
 * @类描述：异常熔断服务
 * @创建人：万星明
 * @创建时间：2020/1/15
 */

@Component
public class UserFallbackServiceImpl implements UserService
{
    private static final Logger logger = LoggerFactory.getLogger(UserFallbackServiceImpl.class);


    /**
     * 1、添加用户
     * @param user 用户
     * @return 响应
     */
    @Override
    public ResponseInfo addUser(User user)
    {
        ResponseInfo responseInfo = new ResponseInfo<>();
        responseInfo.setCode("200500");
        responseInfo.setDesc("已熔断");
        return responseInfo;
    }


    /**
     * 2、查询用户
     * @param userId 用户ID
     * @return 响应
     */
    @Override
    public ResponseInfo getUser(Integer userId)
    {
        ResponseInfo responseInfo = new ResponseInfo<>();
        responseInfo.setCode("200500");
        responseInfo.setDesc("已熔断");
        return responseInfo;
    }


    /**
     * 3、批量查询用户
     * @param userIdList 用户ID列表
     * @return 响应
     */
    @Override
    public ResponseInfo getUserByUserIds(List<Integer> userIdList)
    {
        ResponseInfo responseInfo = new ResponseInfo<>();
        responseInfo.setCode("200500");
        responseInfo.setDesc("已熔断");
        return responseInfo;
    }


    /**
     * 4、根据昵称查询用户列表
     * @param username 昵称
     * @return 响应
     */
    @Override
    public ResponseInfo getUserByName(String username)
    {
        ResponseInfo responseInfo = new ResponseInfo<>();
        responseInfo.setCode("200500");
        responseInfo.setDesc("已熔断");
        return responseInfo;
    }


    /**
     * 5、修改用户
     * @param user 用户
     * @return 响应
     */
    @Override
    public ResponseInfo updateUser(User user)
    {
        ResponseInfo responseInfo = new ResponseInfo<>();
        responseInfo.setCode("200500");
        responseInfo.setDesc("已熔断");
        return responseInfo;
    }


    /**
     * 6、删除用户
     * @param userId 用户ID
     * @return 响应
     */
    @Override
    public ResponseInfo deleteUser(Integer userId)
    {
        ResponseInfo responseInfo = new ResponseInfo<>();
        responseInfo.setCode("200500");
        responseInfo.setDesc("已熔断");
        return responseInfo;
    }
}
