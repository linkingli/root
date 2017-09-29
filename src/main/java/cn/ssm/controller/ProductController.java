package cn.ssm.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.ssm.entity.Product;
import cn.ssm.service.master.ProductService;

/**
 * @author meiting
 * @date 2017年9月21日
 * @version 1.0
 */
@RestController
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private ProductService productService;
	
	/**
	 * 根据ID查询
	 * @param id
	 * @return
	 */
	@RequestMapping("/queryById")
	public Product queryProductById(String id) {
	        return productService.selectProductByIdService(id);
	    }
	
	/**
	 * 新增产品信息
	 * @param product
	 * @return
	 */
	@RequestMapping("/add")
	public Product addProduct(Product product) {
		product = productService.addProductService(product);
	    return product;
	    }
	  
	/**
	 * 修改产品信息
	 * @param id
	 * @return
	 */
	@RequestMapping("/update")
	public Product updateProduct(Product product) {
		product = productService.updateProductService(product);
	    return product;
	    }
	
	/**
	 * 单条删除
	 * @param id
	 * @return
	 */
	@RequestMapping("/deleteById")
	public int deleteProductById(String id) {
		return productService.deleteProductByIdService(id);
	    }
	/**
	 * 多条删除
	 * @param ids
	 * @return
	 */
	@RequestMapping("/deletes")
	public int deleteProduct(String ids) {
		return productService.deleteProductService(ids);    
	    }
	/**
	 * 关键字查询
	 * @param key
	 * @return
	 */
//	@RequestMapping("/queryByVague")
//	public List<Product> queryProductByVague(String key) {	
//	       return productService.queryProductByVagueService(key);
//	    }
	
	/**
	 * 条件查询、没条件查询所有、关键字查询
	 * @param product
	 * @return
	 */
	@RequestMapping("/queryByCondition")
	public Map queryProductByCondition(Product product, Integer page,Integer rows) {	
	       return productService.queryProductByConditionService(product,page,rows);
	    }
	
	@RequestMapping("/selectAll")
	public List<Product> selectAll(){
		return productService.selectAll();
	}
}
