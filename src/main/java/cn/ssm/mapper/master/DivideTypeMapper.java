package cn.ssm.mapper.master;

import java.util.List;

import cn.ssm.entity.DivideType;

public interface DivideTypeMapper {
	/**
	 * 
	 * @author 1-ml
	 * @Title: chan'xun   
	 * @Description: 查询所有   
	 * @param: @return      
	 * @return: List<DivideType>      
	 * @throws
	 */
	List<DivideType> selectAll();
	/**
	 * @return 
	 * 
	 * @author 1-ml
	 * @Title: updateById   
	 * @Description: 根据id修改信息   
	 * @param: @param divideType      
	 * @return: void      
	 * @throws
	 */
	int updateById(DivideType divideType);
	
	/**
	 * 
	 * @author 1-ml
	 * @Title: deleteById   
	 * @Description: 根据id批量删除   
	 * @param: @param id      
	 * @return: void      
	 * @throws
	 */
	void deleteById(List id);
	/**
	 * @return 
	 * 
	 * @author 1-ml
	 * @Title: insert   
	 * @Description: 添加数据   
	 * @param: @param divideType      
	 * @return: void      
	 * @throws
	 */
	 int insert(DivideType divideType);
	 
	 DivideType selectById(String id);
}
