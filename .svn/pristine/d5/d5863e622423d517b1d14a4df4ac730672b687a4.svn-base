package cn.ssm.controller.divide;
/***
 * @author 康钟
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.ssm.entity.Divide;
import cn.ssm.service.master.divide.DivideService;
import cn.ssm.vo.DivideVO;

@RestController
@RequestMapping("/divide")
public class DivideController {

	@Autowired
	private DivideService divideService;
	
	/**
	 * 查询所有数据
	 * @return
	 */
	@RequestMapping("/getall")
	public List<DivideVO> getDivideList(){
		return divideService.selectAll();
	}
	
	/***
	 * 新增divide
	 */
	@RequestMapping("/insert")
	public void addDivide(Divide divide) {
		divideService.insertOne(divide);
	}
	
	/**
	 * 更新divide
	 */
	@RequestMapping("/update")
	public void updateDivide(Divide divide) {
		divideService.update(divide);
	}
	
	/**
	 * 删除divide
	 */
	@RequestMapping("/delete")
	public void deleteDivide(String id) {
		System.out.println(id);
		divideService.delete(id);
	}
	
}
