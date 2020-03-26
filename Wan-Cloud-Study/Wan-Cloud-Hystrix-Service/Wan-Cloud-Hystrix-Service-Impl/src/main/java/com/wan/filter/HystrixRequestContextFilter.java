package com.wan.filter;

import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;
import org.springframework.stereotype.Component;

import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @项目名称：wan-cloud-study
 * @类名称：HystrixRequestContextFilter
 * @类描述：使用Hystrix缓存需要初始化和关闭HystrixRequestContext
 * @创建人：万星明
 * @创建时间：2019/12/28
 */

@Component
@WebFilter(urlPatterns = "/*",asyncSupported = true)
public class HystrixRequestContextFilter implements Filter
{

    @Override
    public void doFilter(ServletRequest servletRequest,ServletResponse servletResponse,FilterChain filterChain) throws
            IOException, ServletException
    {
        HystrixRequestContext context = HystrixRequestContext.initializeContext();
        try
        {
            filterChain.doFilter(servletRequest,servletResponse);
        }
        finally
        {
            context.close();
        }
    }
}
