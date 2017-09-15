package com.answern.claimsChannel.demo.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import lombok.Data;

@ApiModel(value="VhlownerVO" )
@Data
public class VhlownerVO {
	
	@ApiModelProperty(value = "名字" ,name = "COwnerNme"  )
	private String cOwnerNme;
	@ApiParam(hidden = true)
	private String cCertfCls;
	private String cCertfCde;
	 
}
