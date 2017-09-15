package com.answern.claimsChannel.demo.model;



import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
/**
 * @see 这个类是外部传值使用
 * @author wem
 *
 */
@ApiModel(value="person" ,description="一个传入人员信息的类")
@Data 
public class Person implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(value = "关键字")
	private String id;
	@ApiModelProperty(value = "名称"  )
	private String name;
	@ApiModelProperty(value = "年龄" )
	private String age;
	
 
 
}
