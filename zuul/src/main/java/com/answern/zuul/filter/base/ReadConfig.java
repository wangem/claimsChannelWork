package com.answern.zuul.filter.base;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties.ZuulRoute;
import org.springframework.stereotype.Component;

@Component
public class ReadConfig {
	
	@Autowired
	ZuulProperties zuulProperties;
	 
    public String getRoutesPath(String key) {
    	Map<String, ZuulRoute> routes = zuulProperties.getRoutes();
    	ZuulRoute zuulRoute = routes.get(key);
    	String path = zuulRoute.getPath();
    	
    	return path;
    }
    public Boolean isRoutesKey(String key) {
    	Map<String, ZuulRoute> routes = zuulProperties.getRoutes();
    	ZuulRoute zuulRoute = routes.get(key);
    	  
    	if (zuulRoute.getPath().length()>1 ) {
    		return true;
    	}
    	return false;
    }
	 
	 
	 

}
