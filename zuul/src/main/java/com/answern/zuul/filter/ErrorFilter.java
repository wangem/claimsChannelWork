package com.answern.zuul.filter;



import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.answern.zuul.filter.base.BaseFilter;
import com.answern.zuul.filter.base.ConstantUtile;
import com.netflix.zuul.context.RequestContext;


/**
 * 这个过滤器对所有错误进行了统一管理
 * @author wem
 *
 */
public class ErrorFilter extends BaseFilter {
    
	private static final Logger logger = LoggerFactory.getLogger(ErrorFilter.class);

 
 
	@Override
	public Object run() {
		RequestContext  ctx = RequestContext.getCurrentContext();
		 Throwable throwable = ctx.getThrowable();
		 logger.error("this is ErrorFilter : {} " , throwable.getCause().getMessage());
		 ctx.set(ConstantUtile.CTX_ERROR_CODE_KEY,HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		 ctx.set(ConstantUtile.CTX_ERROR_EXCEPTION,throwable.getCause());
		return null;
	}
	 

	 

}
