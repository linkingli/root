package cn.ssm.service.impl.master.divide;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.ssm.entity.Divide;
import cn.ssm.mapper.master.ChannelDownMapper;
import cn.ssm.mapper.master.ChannelTopMapper;
import cn.ssm.mapper.master.DivideMapper;
import cn.ssm.mapper.master.DivideTypeMapper;
import cn.ssm.mapper.master.ProductMapper;
import cn.ssm.service.master.divide.DivideService;
import cn.ssm.utils.UUIDUtils;
import cn.ssm.vo.DivideVO;
@Service
public class DivideServiceImpl implements DivideService {
	
	@Autowired
	private DivideMapper divideMapper;
	
	@Autowired
	private DivideTypeMapper divideTypeMapper;
	
	@Autowired
	private ChannelTopMapper channelTopMapper;
	
	@Autowired
	private ChannelDownMapper channelDownMapper;
	
	@Autowired
	private ProductMapper productMapper;

	/**
	 * 查询所有数据并封装vo
	 */
	@Override
	public List<DivideVO> selectAll() {
		List<DivideVO> volist = new ArrayList<>();
		List<Divide> list = divideMapper.selectAll();
		for (Divide divide : list) {
			DivideVO divideVO = new DivideVO();
			divideVO.setId(divide.getId());
			divideVO.setChannelDown(channelDownMapper.selectByPrimaryKey(divide.getChannelDownId()));
			divideVO.setChannelTop(channelTopMapper.selectByPrimaryKey(divide.getChannelTopId()));
			divideVO.setDivideType(divideTypeMapper.selectById(divide.getTypeId()));
			divideVO.setProduct(productMapper.queryProductById(divide.getProductId()));
			volist.add(divideVO);
		}
		return volist;
	}

	/**
	 * 添加数据
	 */
	@Override
	public void insertOne(Divide divide) {
		divide.setId(UUIDUtils.getUUID());
		divideMapper.insertOne(divide);
	}

	/**
	 * 更新数据
	 */
	@Override
	public void update(Divide divide) {
		divideMapper.update(divide);
	}

	/***
	 * 删除数据
	 */
	@Override
	public void delete(String id) {
		divideMapper.delete(id);
		
	}

	

}
