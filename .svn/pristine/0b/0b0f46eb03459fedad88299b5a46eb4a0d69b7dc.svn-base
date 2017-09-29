package cn.ssm.service.impl.master;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.ssm.entity.channel.ChannelType;
import cn.ssm.mapper.master.ChannelTypeMapper;
import cn.ssm.service.master.ChannelTypeService;

@Service
public class ChannelTypeServiceImpl implements ChannelTypeService{
	
	@Autowired
	private ChannelTypeMapper channelTypeMapper;
	@Override
	public List<ChannelType> findAllType(Integer top_down) {	
		
		return  channelTypeMapper.getAllByTop_Down(top_down);
	}

}
