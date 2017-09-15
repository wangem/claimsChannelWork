package com.answern.claimsChannel.demo.dao;



import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.answern.claimsChannel.demo.bins.Goods;
import com.github.pagehelper.Page;

/**
 * @see Mybatis查询接口
 * @author wem
 *
 */
@Mapper
public interface DemoDao {
	
    /**
     * @see 根据id 查询一条数据
     * @param id
     * @return
     */
	Goods selectByPrimaryKey(Integer id);
	/**
	 * @see 查询说有的数据
	 * @return
	 */
	List<Goods> selectAll();
	/**
	 * @see 分页查询
	 * @return
	 */
	Page<Goods> findByPage();
}
