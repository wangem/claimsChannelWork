package com.answern.zuul.filter.base;
 
/**
 * 
 */

import com.netflix.zuul.ZuulFilter;

 
import lombok.Getter;
import lombok.Setter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author wem
 *
 */
public abstract class BaseFilter extends ZuulFilter {
    Logger logger = LoggerFactory.getLogger(getClass());
    @Getter
    @Setter
    private String filterType ;
    @Getter
    @Setter
    private Integer filterOrder=6;
    @Getter
    @Setter
    private boolean isShouldFilter=true;

    /**
     * filterType：返回一个字符串代表过滤器的类型，在zuul中定义了四种不同生命周期的过滤器类型，具体如下：
     * pre：可以在请求被路由之前调用
     * routing：在路由请求时候被调用
     * post：在routing和error过滤器之后被调用
     * error：处理请求时发生错误时被调用
     *
     * @return
     */
    @Override
    public String filterType() {
        return filterType;
    }

    /**
     * 通过int值来定义过滤器的执行顺序
     *
     * @return
     */
    @Override
    public int filterOrder() {
        return filterOrder != null ? filterOrder : 0;
    }

    /**
     * shouldFilter：返回一个boolean类型来判断该过滤器是否要执行，所以通过此函数可实现过滤器的开关。
     *
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return isShouldFilter;
    }

 
}
