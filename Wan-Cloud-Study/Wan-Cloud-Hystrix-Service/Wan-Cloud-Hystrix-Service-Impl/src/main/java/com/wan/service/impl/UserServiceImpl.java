package com.wan.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCollapser;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheRemove;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheResult;
import com.netflix.hystrix.contrib.javanica.command.AsyncResult;
import com.wan.common.ResponseInfo;
import com.wan.pojo.User;
import com.wan.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;

/**
 * @项目名称：Wan-Cloud-Study
 * @类名称：UserServiceImpl
 * @类描述：业务实现
 * @创建人：万星明
 * @创建时间：2019/12/19
 */
@Service
public class UserServiceImpl implements UserService
{

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private RestTemplate restTemplate;

    @Value("${service-url.user-service}")
    private String userServiceUrl;

    /**
     * 1、添加用户
     * @param user 用户
     * @return 响应
     */
    @HystrixCommand(fallbackMethod = "addUserDefault")
    @Override
    public ResponseInfo addUser(User user)
    {
        logger.error("添加用户:"+user);
        return restTemplate.postForObject(userServiceUrl + "/user/addUser", user, ResponseInfo.class);
    }

    public ResponseInfo addUserDefault( User user)
    {
        ResponseInfo<Integer> responseInfo = new ResponseInfo<>();
        logger.error("已熔断");
        responseInfo.setData(-2);
        return responseInfo;
    }


    /**
     * 2、查询用户
     * @param userId 用户ID
     * @return 用户
     */
    @Override
    @HystrixCommand(fallbackMethod = "getUserDefault",commandKey="getUserCommand",groupKey = "getUserGroup",threadPoolKey = "getUserThreadPool")
    public ResponseInfo getUser(Integer userId)
    {
        logger.error("查询用户:"+userId);
        //这个地方有个坑,{}中是参数的序号
        ResponseInfo responseInfo = this.restTemplate.getForObject( userServiceUrl + "/user/getUser/{1}",ResponseInfo.class,userId );
        logger.error("查询用户结果:"+responseInfo);
        return responseInfo;
    }

    public ResponseInfo getUserDefault(@PathVariable Integer userId)
    {
        ResponseInfo<Integer> responseInfo = new ResponseInfo<>();
        responseInfo.setData(-2);
        logger.error("已熔断");
        return responseInfo;
    }


    /**
     * 3、查询用户(使用IgnoreException忽略异常降级)
     * @param userId 用户ID
     * @return 用户
     */
    @HystrixCommand(fallbackMethod = "getUserIgnoreExceptionDefault",ignoreExceptions = {NullPointerException.class})
    @Override
    public ResponseInfo getUserIgnoreException(Integer userId)
    {
        ResponseInfo responseInfo = null;
        switch (userId)
        {
            case 1:
                throw new IndexOutOfBoundsException(  );
            case 2:
                throw new NullPointerException(  );
            default:
        }
        responseInfo = restTemplate.getForObject( userServiceUrl + "/user/getUser/{1}",ResponseInfo.class,userId );
        return responseInfo;
    }

    public ResponseInfo getUserIgnoreExceptionDefault(Integer userId,Throwable throwable)
    {
        logger.error("getUserIgnoreExceptionDefault==userId:{},throwableClass:{}",userId,throwable.getClass());
        ResponseInfo<Integer> responseInfo = new ResponseInfo<>();
        responseInfo.setData(-2);
        logger.error("已熔断");
        return responseInfo;
    }



    /**
     * 4、查询用户(请求缓存)
     * @param userId 用户ID
     * @return 用户
     */
    @CacheResult(cacheKeyMethod = "getUserCacheKey")
    @HystrixCommand(fallbackMethod = "getUserCacheDefault",commandKey = "getUserCache")
    @Override
    public ResponseInfo getUserCache(Integer userId)
    {
        logger.error("查询用户:"+userId);
        return restTemplate.getForObject( userServiceUrl + "/user/getUser/{1}",ResponseInfo.class,userId);
    }

    public String getUserCacheKey(Integer userId)
    {
        return String.valueOf( userId );
    }

    public ResponseInfo getUserCacheDefault(@PathVariable Integer userId)
    {
        ResponseInfo<Integer> responseInfo = new ResponseInfo<>();
        responseInfo.setData(-2);
        logger.error("已熔断");
        return responseInfo;
    }



    /**
     * 5、查询用户(移除缓存)
     * @param userId 用户ID
     */
    @CacheRemove(commandKey = "getUserCache",cacheKeyMethod = "getUserCacheKey")
    @HystrixCommand
    @Override
    public ResponseInfo removeCache(Integer userId)
    {
        logger.error("删除请求缓存:{}",userId);
        return restTemplate.getForObject( userServiceUrl + "/user/deleteUser/{1}",ResponseInfo.class,userId );
    }


    /**
     * 6、查询用户(请求合并)
     * @param userId 用户ID
     * @return 响应
     */
    @HystrixCollapser(batchMethod = "getUserByUserIds",collapserProperties ={@HystrixProperty(name = "timerDelayInMilliseconds", value = "100")})
    @Override
    public Future<User> getUserFuture(final Integer userId)
    {
        //异步调用
        return new AsyncResult<User>()
        {
            @Override
            public User invoke()
            {
                ResponseInfo responseInfo = restTemplate.getForObject( userServiceUrl + "/user/getUser/{1}",ResponseInfo.class,userId);
                if (responseInfo!=null && responseInfo.getData()!=null)
                {
                    Map data = (Map) responseInfo.getData();
                    User user = BeanUtil.mapToBean(data,User.class,true);
                    logger.info("异步内部实现获取:{}", user);
                    return user;
                }
                return new User();
            }
        };
    }


    @HystrixCommand
    public List<User> getUserByUserIds(List<Integer> userIds)
    {
        logger.info("熔断参数:{}", userIds);
        ResponseInfo responseInfo = restTemplate.postForObject( userServiceUrl + "/user/getUserByUserIdList",userIds,ResponseInfo.class);
        return (List<User>) responseInfo.getData();
    }

}
