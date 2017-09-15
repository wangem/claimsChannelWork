package com.answern.claimsChannel.demo.dao;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.answern.claimsChannel.base.utile.BaseUtile;
import com.answern.claimsChannel.base.utile.RedisUtile;
import com.answern.claimsChannel.demo.model.Person;
/**
 * @see 这是redis 查询dao
 * @author wem
 *
 */
@Repository 
public class PersonDao  {
 

	@Autowired
    private RedisUtile redisUtile;
	/**
	 * @see 根据key value形式保存数据
	 * @param key
	 * @param value
	 */
	public void stringRedisTemplateDemp(final String key,final String value) {
		this.redisUtile.stringRedisTemplate().set(key, value);
	}
	/**
	 * @see 保存一个对象
	 * @param person
	 */
	public void save(Person person) {
		this.redisUtile.redisTemplate().set(person.getId(), person);
	}
	/**
	 * 获取一个键值对
	 * @param key
	 * @return
	 */
	public String getString (final String key) {
		
		return this.redisUtile.stringRedisTemplate().get(key);
	}
	/**
	 * 获取一个对象
	 * @param id
	 * @return
	 */
	public Person getPerson (final String id) {
		Object object = this.redisUtile.redisTemplate().get(id) ;
		if(!BaseUtile.isNullOrEmpty(object) && object instanceof Person) {
			return (Person) object;
		}
		return null;
	}

}
