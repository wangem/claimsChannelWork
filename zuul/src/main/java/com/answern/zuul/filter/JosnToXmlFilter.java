package com.answern.zuul.filter;



import java.util.Enumeration;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.answern.zuul.filter.base.BaseFilter;
import com.answern.zuul.filter.base.ConstantUtile;
import com.netflix.zuul.context.RequestContext;



public class JosnToXmlFilter extends BaseFilter {
    
	private static final Logger logger = LoggerFactory.getLogger(JosnToXmlFilter.class);
	 

	 @Override
    public boolean shouldFilter() {
		 RequestContext ctx = RequestContext.getCurrentContext();
		 String proxy =  ctx.get(ConstantUtile.CTXPROXY).toString();
		 if(proxy.equals(ConstantUtile.ZuulRoutesPath.JOSN_TO_XML.toString())) {
			 return true;
			}
		return false; 
    }
  /**
   * run：过滤器的具体逻辑。
   * 需要注意，这里我们通过ctx.setSendZuulResponse(false)令zuul过滤该请求，
   * 不对其进行路由，然后通过ctx.setResponseStatusCode(401)设置了其返回的错误码，
   * 当然我们也可以进一步优化我们的返回，
   * 比如，通过ctx.setResponseBody(body)对返回body内容进行编辑等。
   *
   * @return
   */
  @Override
  public Object run() {
      RequestContext ctx = RequestContext.getCurrentContext();
      
       
    	  HttpServletRequest request = ctx.getRequest();
          String url = request.getScheme()+"://"+ request.getServerName()+request.getRequestURI()+"?"+request.getQueryString();
//          logger.info("{} request to {}", request.getMethod(), request.getRequestURL().toString());
          Map<String, String[]> params = request.getParameterMap();  
          String queryString = "";  
          for (String key : params.keySet()) {  
              String[] values = params.get(key);  
              for (int i = 0; i < values.length; i++) {  
                  String value = values[i];  
                  queryString += key + "=" + value + "&";  
              }  
          }
          logger.info("JosnToXmlFilter Filter Type {}, request from {},queryString=={}",this.getFilterType(), url,queryString); 
          //打印头信息
          Enumeration<String> names = request.getHeaderNames();
          
          logger.info("===JosnToXmlFilter=Print head information start =================================="); 
          while(names.hasMoreElements()){
            String name = (String) names.nextElement();
            logger.info(name + ":" + request.getHeader(name));
                
          }
          logger.info("===JosnToXmlFilter=Print head information end ==================================");
 	 
      
 
      return null;
  }

}
