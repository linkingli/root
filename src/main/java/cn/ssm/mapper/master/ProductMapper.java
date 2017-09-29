/**
 * 
 */
package cn.ssm.mapper.master;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cn.ssm.entity.Product;

/**
 * @author meiting
 * @date 2017年9月21日
 * @version 1.0
 */
@Mapper
public interface ProductMapper {

	/*
	 * 按产品ID查询
	 */
	Product queryProductById(String id);
	/*
	 * 条件查询、没条件查询所有、模糊查询总条数
	 */
	int count(Product product);
	/*
	 * 条件查询、没条件查询所有
	 */
	List<Product> selectByCondition(Product product,Integer page,Integer rows);
	/*
	 * 模糊查询
	 */
//	List<Product> selectByVague(String key);
	/*
	 * 新增产品信息
	 */
	int addProduct(Product product);  
	/*
	 * 修改产品信息  
	 */
	int updateProduct (Product product);
	/*
	 * 单条删除产品  
	 */
	int deleteProductById (String id);
	/*
	 * 多条删除产品
	 */
	int deleteProductList(String[] ids);
	/*
	 * 查询所有
	 */
	 List<Product> selectAll();
}
