package cn.ssm.service.impl.master;

import cn.ssm.entity.ChannelTop;
import cn.ssm.entity.ChannelTopExample;
import cn.ssm.entity.channel.ChannelType;
import cn.ssm.entity.channel.PageBean;
import cn.ssm.mapper.master.ChannelTopMapper;
import cn.ssm.service.impl.BaseServiceImpl;
import cn.ssm.service.master.ChannelTopService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ChannelTopServiceImpl extends BaseServiceImpl<ChannelTop, ChannelTopExample> implements ChannelTopService {
	@Autowired
	private ChannelTopMapper channelTopMapper;

	@Override
	@Transactional
	public  ChannelTop insertTop(ChannelTop entity) {
		int insert = channelTopMapper.insert(entity);
		ChannelTop channelTop ;
		if( insert == 0) {
			channelTop = new ChannelTop();
		}else {
			channelTop = super.selectByPrimaryKey(entity.getId());
		}
		return channelTop;
	}

	@Override
	@Transactional
	public int updateBySelective(ChannelTop entity) {
		return super.updateBySelective(entity);
	}

	@Override
	@Transactional
	public int deleteByPrimaryKey(String id) {
		return super.deleteByPrimaryKey(id);
	}

	

	@Override
	public List<ChannelTop> selectByChannelName(String str) {
		String param = "%" + str + "%";

		List<ChannelTop> li = channelTopMapper.selectByChannelName(param);

		return li;
	}

	@Override
	public List<ChannelType> selectByChannelType(String string) {
		String s = "%"+string+"%";
		List<ChannelType> li = channelTopMapper.selectByChannelType(s);
		return li;
	}

	@Override
	public ChannelTop updateTop(ChannelTop top) {
		int update = super.updateBySelective(top);
		ChannelTop channel ;
		if(update == 0) {
			channel = new ChannelTop();
		}else {
			channel = super.selectByPrimaryKey(top.getId());
		}
		return channel;
	}

	@Override
	public PageBean<ChannelTop> findByConditionPages(int currPage, int pageSize,ChannelTop channelTop) {
		PageBean<ChannelTop> bean = new PageBean<>();
	
		//如果名称不为空，插入名称查询条件
	

		//查询总条数
		Map<String,Object> params = new HashMap<String, Object>();
		if (null!=channelTop.getChannelName()) {
			params.put("channelName", "%"+channelTop.getChannelName()+"%");
		}else{
			params.put("channelName", channelTop.getChannelName());
		}
		params.put("channelType", channelTop.getChannelType());
		int totalCount = channelTopMapper.countByExample(params);
		params.put("page", (currPage-1)*pageSize);
		params.put("pageSize", pageSize);
		//查询所有条件数据
		List<ChannelTop> list = channelTopMapper.quryByConditionPage(params);
		//封装pageBean
		bean.setRows(list);
		bean.setCurrPage(currPage);
		bean.setPageSize(pageSize);
		bean.setTotal(totalCount);
		return bean;
	}
	@Override
	public List<ChannelTop> queryCp(){
		return channelTopMapper.queryCp();
	}





	


	@Override
	public List<ChannelTop> selectAll() {
		
		return channelTopMapper.selectAll();
	}

}
