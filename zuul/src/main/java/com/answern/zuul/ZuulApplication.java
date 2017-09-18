package com.answern.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.answern.zuul.filter.ErrorFilter;
import com.answern.zuul.filter.JosnToXmlFilter;
import com.answern.zuul.filter.LoggerFilter;
import com.answern.zuul.filter.XmlFilter;

@SpringBootApplication
@EnableZuulProxy
public class ZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulApplication.class, args);
	}
	

	
 
	/**
	 * 日志过滤器
	 * 路由前调用
	 * 所有连接都要过此过滤器
	 * @return
	 */
	@Bean
	public LoggerFilter loggerPreFilter() {
		LoggerFilter loggerFilter = new LoggerFilter();
		loggerFilter.setShouldFilter(true);
		loggerFilter.setFilterOrder(6);
		loggerFilter.setFilterType("pre");
		return loggerFilter;
	}
	/**
	 * 日志过滤器
	 * 路由后调用
	 * 所有连接都要过此过滤器
	 * @return
	 */
	@Bean
	public LoggerFilter loggerPostFilter() {
		LoggerFilter loggerFilter = new LoggerFilter();
		loggerFilter.setShouldFilter(true);
		loggerFilter.setFilterOrder(7);
		loggerFilter.setFilterType("post");
		return loggerFilter;
	}
	/**
	 * JosnToXmlFilter
	 * 路由前调用
	 * 所有连接都要过此过滤器
	 * @return
	 */
	@Bean
	public JosnToXmlFilter josnToXmlFilter() {
		JosnToXmlFilter josnToXmlFilter = new JosnToXmlFilter();
		josnToXmlFilter.setShouldFilter(false);
		josnToXmlFilter.setFilterOrder(8);
		josnToXmlFilter.setFilterType("pre");
		return josnToXmlFilter;
	}
	/**
	 *  XmlFilter
	 * 路由前调用
	 * 所有连接都要过此过滤器
	 * @return
	 */
	@Bean
	public XmlFilter xmlFilter() {
		XmlFilter xmlFilter = new XmlFilter();
		xmlFilter.setShouldFilter(false);
		xmlFilter.setFilterType("pre");
		xmlFilter.setFilterOrder(9);
		return xmlFilter;
	}
	/**
	 * 错误处理过滤器
	 * @return
	 */
	@Bean
	public ErrorFilter errorFilter() {
		ErrorFilter errorFilter = new ErrorFilter();
		errorFilter.setShouldFilter(true);
		errorFilter.setFilterType("error");
		errorFilter.setFilterOrder(10);
		return errorFilter;
	}
	
	
}
