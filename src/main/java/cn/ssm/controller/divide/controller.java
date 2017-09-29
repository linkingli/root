package cn.ssm.controller.divide;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.ssm.entity.DivideType;
import cn.ssm.service.master.divide.DivideTypeService;
import cn.ssm.utils.UUIDUtils;

@RestController
@RequestMapping("/cost")
public class controller {
	@Autowired
	private DivideTypeService divideTypeService;
	
	/**
	 * 查询所有数据
	 * @author 1-ml
	 * @Title: selectAll   
	 * @Description: TODO   
	 * @param: @return      
	 * @return: List<DivideType>      
	 * @throws
	 */
	@RequestMapping("/selectAll")
	public List<DivideType> selectAll(){
		
		return divideTypeService.selectAll();
	}
	
	/**
	 * 根据id删除数据
	 * @author 黄易雄
	 * @Title: deleteById   
	 * @Description: TODO   
	 * @param: @param id      
	 * @return: int      
	 * @throws
	 */
	@RequestMapping("/deleteById")
	public int deleteById(String[] id) {
		try {
			List<String> list = new ArrayList<>();//创建一个空的list集合
			for (int i = 0; i < id.length-1; i++) {//遍历从前端传过来的String数组     id.length-1:前端字符串拼接中逗号后面拼接了一个空字符串
				list.add(id[i]);  //将遍历出来的数据放入list集合
			}
			divideTypeService.deleteById(list);//调用Service中的删除方法
		} catch (Exception e) {
			e.printStackTrace();
		}
		return id.length-1; //返回操作的行数
	}
	/**
	 * 添加数据和修改
	 * @author 1-ml
	 * @Title: insert   
	 * @Description: TODO   
	 * @param: @param divideType      
	 * @return: void      
	 * @throws
	 */
	@RequestMapping("/insertoradd")
	public DivideType insert(DivideType diviteType) {
		//判断id是否为空    空则新增  非空就是修改
		if(diviteType.getId()==null) {
			//给对象设置id
			diviteType.setId(UUIDUtils.getUUID());
			divideTypeService.insert(diviteType);
		return diviteType;
		}else{
			//修改
			divideTypeService.updateById(diviteType);
			return diviteType;
		}
	}
	
}
