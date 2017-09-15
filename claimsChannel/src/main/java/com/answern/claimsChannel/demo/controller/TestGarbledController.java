package com.answern.claimsChannel.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.answern.claimsChannel.demo.model.VhlownerVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "测试是否为乱码",description = " swagger 测试是否为乱码")
@Controller 
@RequestMapping("testGarbled")
public class TestGarbledController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@ApiOperation(value="方法使用说明", notes="测试是否为乱码")
	@ResponseBody 
	@RequestMapping(
			value = "index" ,
			method = RequestMethod.POST, 
			produces = {"application/xml;charset=UTF-8","application/json;charset=UTF-8"},
			consumes = {"application/xml;charset=UTF-8","application/json;charset=UTF-8"})
	public String index(@RequestBody VhlownerVO  v) {
		
		logger.debug(v.getCCertfCls());
		logger.debug(v.getCOwnerNme());
		return "this is index";
	}

}
