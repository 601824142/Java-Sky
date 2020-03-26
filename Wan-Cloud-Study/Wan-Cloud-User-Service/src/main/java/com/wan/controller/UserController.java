package com.wan.controller;


import com.wan.common.ErrorCode;
import com.wan.common.ResponseInfo;
import com.wan.pojo.User;
import com.wan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController
{

    @Autowired
    private UserService userService;

    /**
     * 1、添加用户
     * @param user 用户
     * @param bindingResult 参数校验
     * @return 响应
     */
    @PostMapping(value = "/addUser")
    public ResponseInfo addUser(@RequestBody @Valid User user,BindingResult bindingResult)
    {
        if (bindingResult.hasErrors())
        {
            return new ResponseInfo( ErrorCode.CODE_REQUEST_PARAM_INVALID);
        }
        return userService.addUser(user);
    }


    /**
     * 2、获取用户
     * @param userId 用户ID
     * @return 响应
     */
    @GetMapping(value = "/getUser/{userId}")
    public ResponseInfo getUser(@PathVariable Integer userId)
    {
        return userService.getUser(userId);
    }


    /**
     * 3、批量获取用户列表
     * @param userIdList 用户ID列表
     * @return 用户列表
     */
    @PostMapping(value = "/getUserByUserIdList")
    public ResponseInfo getUserByUserIds(@RequestBody List<Integer> userIdList)
    {
        return userService.getUserByIds(userIdList);
    }


    /**
     * 4、根据昵称获取用户列表
     * @param username 昵称
     * @return 用户列表
     */
    @GetMapping(value = "/getUserByName")
    public ResponseInfo getUserByName(@RequestParam String username)
    {
        return userService.getUserByName(username);
    }


    /**
     * 5、修改用户
     * @param user 用户参数
     * @return 状态
     */
    @PostMapping(value = "/updateUser",consumes = "application/json",produces = "application/json")
    public ResponseInfo updateUser(@RequestBody User user)
    {
        return userService.updateUser(user);
    }


    /**
     * 6、删除用户
     * @param userId 用户ID
     * @return 响应
     */
    @GetMapping(value = "/deleteUser/{userId}")
    public ResponseInfo deleteUser(@PathVariable Integer userId)
    {
        return userService.deleteUser(userId);
    }
}
