/**
 * 
 */
package cn.ssm.service.impl.master;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.ssm.entity.Product;
import cn.ssm.mapper.master.ProductMapper;
import cn.ssm.service.master.ProductService;
import cn.ssm.utils.UUIDUtils;

/**
 * @author meiting
 * @date 2017年9月21日
 * @version 1.0
 */
@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductMapper productMapper;
	
	/* 根据ID查询
	 * @see cn.ssm.service.master.ProductService#selectProductByIdService()
	 */
	@Override
	public Product selectProductByIdService(String id) {
		return productMapper.queryProductById(id);
	}
	/* 新增产品信息
	 * @see cn.ssm.service.master.ProductService#addProductService(cn.ssm.entity.Product)
	 */
	@Override
	public Product addProductService(Product product) {
		product.setId(UUID.randomUUID().toString());
		int i = 0;
			 product.setId(UUIDUtils.getUUID());
			i = productMapper.addProduct(product);
		if(i<=0){
            return null;
        }
		 return product;
	}
	/* 修改产品信息
	 * @see cn.ssm.service.master.ProductService#updateProductService(java.lang.String)
	 */
	@Override
	public Product updateProductService(Product product) {
		int i = productMapper.updateProduct(product);
		if(i<=0){
            return product;
        }else{
        	return productMapper.queryProductById(product.getId());
        }
       	
	}
	/* 单条删除
	 * @see cn.ssm.service.master.ProductService#deleteProductByIdService(java.lang.String)
	 */
	@Override
	public int deleteProductByIdService(String id) {
		return productMapper.deleteProductById(id);
		
	}
	/* 多条删除
	 * @see cn.ssm.service.master.ProductService#deleteProductService(java.lang.String[])
	 */
	@Override
	public int deleteProductService(String ids) {
		String[] split = ids.split(",");
		return productMapper.deleteProductList(split);
	
	}
	/* 关键字查询
	 * @see cn.ssm.service.master.ProductService#queryProductByVagueService(java.lang.String)
	 */
//	@Override
//	public List<Product> queryProductByVagueService(String key) {	
//		key = new StringBuilder("%").append(key).append("%").toString();
//		return productMapper.selectByVague(key);
//	}
	/* 条件查询、没条件查询所有
	 * @see cn.ssm.service.master.ProductService#queryProductByConditionService(cn.ssm.entity.Product)
	 */
	@Override
	public Map queryProductByConditionService(Product product,Integer page,Integer rows) {

		if(null!=product.getProduct_name() && product.getProduct_name() != ""){

		String	string = new StringBuilder("%").append(product.getProduct_name()).append("%").toString();
		
		product.setProduct_name(string);
		}
		int total = productMapper.count(product);
		int i = (page-1) * rows ;
		Map<String, Object> pra = new HashMap<>();
		List<Product> list = productMapper.selectByCondition(product,i,rows);
		pra.put("rows", list);
		pra.put("total", total);
		pra.put("page", page);
		return pra;
	}
	

	public List<Product> selectAll(){
		return productMapper.selectAll();
	}

}
