package com.wan.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @项目名称：wan-cloud-study
 * @类名称：PreLogFilter
 * @类描述：前置过滤器
 * @创建人：万星明
 * @创建时间：2020/1/16
 */

@Component
public class PreLogFilter extends ZuulFilter
{
    private Logger logger = LoggerFactory.getLogger(this.getClass());


    /**
     * 过滤器类型:pre、routing、post、error四种。
     */
    @Override
    public String filterType()
    {
        return "pre";
    }


    /**
     * 过滤器执行顺序,数值越小优先级越高。
     */
    @Override
    public int filterOrder()
    {
        return 1;
    }

    /**
     * 是否进行过滤,返回true会执行过滤。
     */
    @Override
    public boolean shouldFilter()
    {
        return true;
    }


    /**
     * 自定义的过滤器逻辑,当shouldFilter()返回true时执行
     */
    @Override
    public Object run() throws ZuulException
    {
        //获取当前请求上下文
        RequestContext requestContext = RequestContext.getCurrentContext();
        //通过上下文获取请求对象
        HttpServletRequest request = requestContext.getRequest();
        //获取地址
        String host = request.getRemoteHost();
        //获取方法
        String method = request.getMethod();
        //获取URL
        String url = request.getRequestURI();
        //打印请求日志
        logger.info("请求IP:{},请求方法:{},请求链接:{}", host, method, url);
        return null;
    }
}
