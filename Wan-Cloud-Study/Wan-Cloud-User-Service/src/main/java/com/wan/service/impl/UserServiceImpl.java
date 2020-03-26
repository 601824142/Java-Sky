package com.wan.service.impl;

import com.wan.common.ResponseInfo;
import com.wan.dao.UserMapper;
import com.wan.pojo.User;
import com.wan.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @项目名称：Wan_Cloud_Study
 * @类名称：UserServiceImpl
 * @类描述：
 * @创建人：万星明
 * @创建时间：2019/12/14
 */

@Service
public class UserServiceImpl implements UserService
{
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserMapper userMapper;

    @Override
    public ResponseInfo addUser(User user)
    {
        Integer result = userMapper.insertUser(user);
        logger.error("添加用户:"+user);
        ResponseInfo<Integer> responseInfo = new ResponseInfo<>();
        responseInfo.setData(result);
        return responseInfo;
    }

    @Override
    public ResponseInfo getUser(Integer userId)
    {
        User user = userMapper.getUser(userId);
        logger.error("查询用户:"+user);
        ResponseInfo<User> responseInfo = new ResponseInfo<>();
        responseInfo.setData(user);
        return responseInfo;
    }

    @Override
    public ResponseInfo getUserByIds(List<Integer> userIdList)
    {
        List<User> userList = userMapper.getUserList(userIdList);
        logger.error("查询用户:"+userList);
        ResponseInfo<List<User>> responseInfo = new ResponseInfo<>();
        responseInfo.setData(userList);
        return responseInfo;
    }

    @Override
    public ResponseInfo getUserByName(String username) {
        return null;
    }

    @Override
    public ResponseInfo updateUser(User user) {
        return null;
    }

    @Override
    public ResponseInfo deleteUser(Integer userId)
    {
        Integer result = userMapper.deleteUser(userId);
        logger.error("删除用户:"+userId);
        ResponseInfo<Integer> responseInfo = new ResponseInfo<>();
        responseInfo.setData(result);
        return responseInfo;
    }
}
