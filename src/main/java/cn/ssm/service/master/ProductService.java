/**
 * 
 */
package cn.ssm.service.master;

import java.util.List;
import java.util.Map;

import cn.ssm.entity.Product;

/**
 * @author meiting
 * @date 2017年9月21日
 * @version 1.0
 */
public interface ProductService {

	/**
	 * 根据ID查询
	 */
	Product selectProductByIdService(String id);

	/**
	 * 新增产品信息
	 * @param product
	 * @return
	 */
	Product addProductService(Product product);

	/**
	 * 修改产品信息
	 * @param id
	 * @return
	 */
	Product updateProductService(Product product);

	/**单条删除
	 * @param id
	 * @return
	 */
	int deleteProductByIdService(String id);

	/**多条删除
	 * @param ids
	 * @return
	 */
	int deleteProductService(String ids);

	/**关键字查询
	 * @param key
	 * @return
	 */
//	List<Product> queryProductByVagueService(String key);

	/**条件查询、没条件查询所有
	 * @param product
	 * @return
	 */
	Map queryProductByConditionService(Product product,Integer page,Integer rows);

	List<Product> selectAll();

	
	
}
