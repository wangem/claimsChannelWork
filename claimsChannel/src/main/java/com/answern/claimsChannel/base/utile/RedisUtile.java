package com.answern.claimsChannel.base.utile;



import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author wem
 *
 */
@Repository 
public class RedisUtile {
	
	@Autowired
	 StringRedisTemplate stringRedisTemplate;
	
	
	@Autowired
	 RedisTemplate<Object, Object> redisTemplate;
	
	////////以下为指定注入/////////////////////////////
	
	@Resource(name="stringRedisTemplate")
	private ValueOperations<String, String> volOpsStr;
	
	@Resource(name="redisTemplate")
	private ValueOperations<Object, Object> volOps;

	

	public ValueOperations<String, String> stringRedisTemplate() {
		return this.volOpsStr;
	}


	public ValueOperations<Object, Object> redisTemplate() {
		return this.volOps;
	}


}
