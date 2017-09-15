package com.answern.claimsChannel.demo.bins;



import java.util.Date;

import lombok.Data;



@Data  
public class Goods
{

	private Integer id;

	private String name;

	private String randomName;

	private Integer store;

	private Integer version;

	private Date startTime;

	private Date endTime;

	private Boolean delFlag;

 
 
}