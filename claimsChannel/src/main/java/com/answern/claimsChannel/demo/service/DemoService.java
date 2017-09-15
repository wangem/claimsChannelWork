package com.answern.claimsChannel.demo.service;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.answern.claimsChannel.base.utile.ConstantUtile.ReturnHint;
import com.answern.claimsChannel.demo.bins.Goods;
import com.answern.claimsChannel.demo.dao.DemoDao;
import com.answern.claimsChannel.demo.dao.PersonDao;
import com.answern.claimsChannel.demo.model.Person;
import com.github.pagehelper.Page;
/**
 * @see  这个类中集成了Mybaitis的查询和redis的操作
 * @author wem
 *
 */
@Service
public class DemoService {
	
	@Autowired
	private DemoDao demoDao;  // Mybaitis
	
	@Autowired
	private PersonDao personDao ;//redis
 
	
	/**
	 * @see 查询所有
	 * @return
	 */
	public List<Goods> selectGoods() {
		
		return this.demoDao.selectAll();
	}
	/**
	 * @see 按照id查询
	 * @param index
	 * @return
	 */
	public Goods selectByPrimaryKey(Integer index) {
		Goods selectByPrimaryKey = this.demoDao.selectByPrimaryKey(index);
		 
		return selectByPrimaryKey;
	}
	/**
	 * @see 分页查询
	 * @return
	 */
	public   Page<Goods> selectAllPage() { 
		Page<Goods> selectAll = this.demoDao.findByPage();
		 
		System.out.println(selectAll);
		return selectAll;  
	}
	
	/**
	 * @see redis 保存key  value
	 * @return
	 */
	public String saveKeyValue() {
		this.personDao.stringRedisTemplateDemp("1","test");
		return ReturnHint.SAVE_SUCCESS.toString();
	}
	/**
	 * @see redis 保存person
	 * @return
	 */
	public String savePerson(Person person ) {
		
		this.personDao.save(person);
		
		return ReturnHint.SAVE_SUCCESS.toString();
	}
	/**
	 * @see redis 获取 key  value
	 * @return
	 */
	public String getKeyValue(final String key) {
		
		return this.personDao.getString(key);
	}
	/**
	 * @see  redis 获取person
	 * @return
	 */
	public Person getPerson(final String key) {
	 
		return this.personDao.getPerson(key);
	}
}
