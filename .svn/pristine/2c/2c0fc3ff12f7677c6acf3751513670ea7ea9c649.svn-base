package cn.ssm.service.impl.master;

import cn.ssm.entity.ChannelDown;
import cn.ssm.entity.ChannelDownExample;
import cn.ssm.entity.channel.ChannelType;
import cn.ssm.entity.channel.PageBean;
import cn.ssm.mapper.master.ChannelDownMapper;
import cn.ssm.service.impl.BaseServiceImpl;
import cn.ssm.service.master.ChannelDownService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ChannelDownServiceImpl extends BaseServiceImpl<ChannelDown, ChannelDownExample>
		implements ChannelDownService {

	@Override
	@Transactional
	public int insert(ChannelDown entity) {
		return super.insert(entity);
	}

	@Override
	@Transactional
	public int updateBySelective(ChannelDown entity) {
		return super.updateBySelective(entity);
	}

	@Override
	@Transactional
	public int deleteByPrimaryKey(String id) {
		return super.deleteByPrimaryKey(id);
	}

	@Autowired
	private ChannelDownMapper channelDownMapper;
	@Override
	@Transactional
	public List<ChannelDown> selectByChannelName(String string) {
		String param = "%" + string + "%";
		return channelDownMapper.selectByChannelName(param);
	}

	@Override
	@Transactional
	public List<ChannelType> selectByChannelType(String string) {
		String s = "%"+string+"%";
		List<ChannelType> li = channelDownMapper.selectByChannelType(s);
		return li;
	}

	@Override
	public ChannelDown insertDown(ChannelDown down) {
		int insert = super.insert(down);
		ChannelDown channelDown ;
		if( insert == 0) {
			channelDown = new ChannelDown();
		}else {
			channelDown = super.selectByPrimaryKey(down.getId());
		}
		return channelDown;
	}
	

	public PageBean<ChannelDown> findByConditionPages(int currPage, int pageSize,ChannelDown channelDown) {
		PageBean<ChannelDown> bean = new PageBean<>();
		Map<String,Object> params = new HashMap<String, Object>();
		params.put("channelName", "%"+channelDown.getChannelName()+"%");
		params.put("channelType", channelDown.getType());
		int totalCount = channelDownMapper.countByExample(params);
		params.put("page", (currPage-1)*pageSize);
		params.put("pageSize", pageSize);
		//查询所有条件数据
		List<ChannelDown> list = channelDownMapper.quryByConditionPage(params);
		bean.setRows(list);
		bean.setCurrPage(currPage);
		bean.setPageSize(pageSize);
		bean.setTotal(totalCount);
		return bean;
	}

	@Override
	public List<ChannelDown> selectAll() {
		
		return channelDownMapper.selectAll();
	}

	@Override
	public ChannelDown updateDown(ChannelDown down) {
		int result = super.updateBySelective(down);
		ChannelDown channelDown;
		if (result==0) {
			channelDown=new ChannelDown();
		}else {
			channelDown=super.selectByPrimaryKey(down.getId());
		}
		return channelDown;
	}


}
