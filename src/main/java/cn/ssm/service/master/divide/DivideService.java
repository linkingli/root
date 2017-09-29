package cn.ssm.service.master.divide;

import java.util.List;

import cn.ssm.entity.Divide;
import cn.ssm.vo.DivideVO;

public interface DivideService {
	
	/**
	 * 查询所有
	 * @return
	 */
	public List<DivideVO> selectAll();
	
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
