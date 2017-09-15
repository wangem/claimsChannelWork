package com.answern.claimsChannel.demo.controller;



import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.answern.claimsChannel.demo.bins.Goods;
import com.answern.claimsChannel.demo.model.Person;
import com.answern.claimsChannel.demo.service.DemoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(value = "Demo(表明类的使用)",description = " swagger 例子使用")
@Controller 
@RequestMapping("demo")
public class DemoController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private DemoService demoService;
	
	@ApiOperation(value="方法使用说明", notes="方法说明：说明方法具体作用")
	@ResponseBody
	@RequestMapping(value = "index" ,method = RequestMethod.GET)
	public String index() {
		logger.debug("这里是一个logger");
		return "this is index";
	}
	@ApiOperation(value="Mybatis查询所有", notes="查询所有的数据列表")
	@ResponseBody
	@RequestMapping(value = "selectAll" ,method = RequestMethod.GET)
	public String selectAll() {
		List<Goods> selectGoods = this.demoService.selectGoods();
		System.out.println(selectGoods);
		return "selectGoods is:"+selectGoods;
	}
	
//	@Loggable
	@ApiOperation(value="Mybatis按照ID查询一条数据", notes="这里说明传入值的写法")
	@ApiImplicitParams({ @ApiImplicitParam(name = "value", value = "要查询数据的ID", required = true, dataType = "Integer") })
	@ResponseBody
	@RequestMapping(value = "selectByPrimaryKey/{value}" ,method = RequestMethod.GET)
	public String selectByPrimaryKey(@PathVariable Integer value) {
		
		Goods selectGoods = this.demoService.selectByPrimaryKey(value); 
		return "this is selectGoods"+selectGoods;
	}
	@ApiOperation(value="Mybatis带分页的查询", notes="这里已经集成了Mybatis的分页")
	@RequestMapping(value = "/selectAllPage" ,method = RequestMethod.GET) 
	@ResponseBody
	public  PageInfo<Goods> selectAllPage() { 
		 PageHelper.startPage(1, 2);
		 List<Goods> selectAll = this.demoService.selectAllPage(); 
		System.out.println(selectAll);
		return new PageInfo<Goods> (selectAll);  
		
	}
	@ApiOperation(value="redis保存键值对写法", notes="这里写了一个以Key Value形式保存的方法")
	@RequestMapping(value = "/saveKeyValue" ,method = RequestMethod.GET) 
	@ResponseBody
	public  String saveKeyValue() { 
		 
		return this.demoService.saveKeyValue(); 
	}
	@ApiOperation(value="redis保存对象写法", notes="这里写了一个以对象形式保存的方法")
	@RequestMapping(value = "/savePerson",method = RequestMethod.GET) 
	@ResponseBody
	public  String savePerson(Person person) { 
		
		return this.demoService.savePerson(person);  
		 
	}
	@ApiOperation(value="redis获取字符串方法", notes="这里写了一个从redis获取Key  Value的方法")
	@RequestMapping(value ="/getKeyValue/{key}" ,method = RequestMethod.GET) 
	@ResponseBody
	public  String getKeyValue(@PathVariable String key) { 
		
		return this.demoService.getKeyValue(key); 
	}
	@ApiOperation(value="redis获取对象方法", notes="这里写了一个从redis获取对象的方法")
	@RequestMapping(value = "/getPerson/{key}" ,method = RequestMethod.GET) 
	@ResponseBody
	public  Person getPerson(@PathVariable String key) { 
		
		return this.demoService.getPerson(key); 
	}
	@ApiOperation(value="pos方式提交API写法", notes="这个方法是的Person对象的API在对象中写的注解")
	@RequestMapping(value = "/getIn",method = RequestMethod.POST) 
	@ResponseBody
	public  String getIn( Person person) { 
		return person.getId();   
	}

//	@Loggable
	@ApiOperation(value="@Loggable使用说明", notes="方法说明：说明@Loggable")
	@ResponseBody
	@RequestMapping(value = "loggable" ,method = RequestMethod.GET)
	public String Loggable () {
		logger.debug("这里是一个Loggable");
		return "this is Loggable";
	}
}
