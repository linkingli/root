package cn.ssm.service.impl.master.divide;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.ssm.entity.DivideType;
import cn.ssm.mapper.master.DivideTypeMapper;
import cn.ssm.service.master.divide.DivideTypeService;
@Service
public class DivideTypeServiceImpl implements DivideTypeService {
	@Autowired
	private DivideTypeMapper  divideTypeMapper;
	
	@Override
	public List<DivideType> selectAll() {
		// TODO Auto-generated method stub
		return divideTypeMapper.selectAll();
	}

	@Override
	public int updateById(DivideType divideType) {
	
		return divideTypeMapper.updateById(divideType);
	}

	@Override
	public void deleteById(List id) {
		divideTypeMapper.deleteById(id);

	}

	@Override
	public int insert(DivideType divideType) {
		
		return divideTypeMapper.insert(divideType);
	}

}
