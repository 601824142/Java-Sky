package com.wan.service;

import com.wan.common.ResponseInfo;
import com.wan.pojo.User;

import java.util.List;

/**
 * @项目名称：Wan_Cloud_Study
 * @类名称：
 * @类描述：
 * @创建人：万星明
 * @创建时间：2019/12/14
 */
public interface UserService
{

    ResponseInfo addUser(User user);

    ResponseInfo getUser(Integer userId);

    ResponseInfo getUserByIds(List<Integer> userIdList);

    ResponseInfo getUserByName(String username);

    ResponseInfo updateUser(User user);

    ResponseInfo deleteUser(Integer userId);
}
