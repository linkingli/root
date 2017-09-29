package cn.ssm.mapper.master;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cn.ssm.entity.Divide;


@Mapper
public interface DivideMapper {

	/**
	 * 查询所有数据
	 * @return
	 */
	List<Divide> selectAll();
	
	/**
	 * 添加数据
	 */
	void insertOne(Divide divide);
	
	/**
	 * 更新数据
	 */
	void update(Divide divide);
	/**
	 * 删除数据
	 */
	void delete(String id);
}
