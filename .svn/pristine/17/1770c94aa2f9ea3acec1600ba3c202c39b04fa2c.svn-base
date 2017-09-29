package cn.ssm.controller.channel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.ssm.entity.channel.ChannelType;
import cn.ssm.service.master.ChannelTypeService;

/**
 * @Description: 渠道类型数据
 * @author 二组
 * @date 2017年9月21日
 * @version V1.0
 */
@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/channelType")
public class ChannelTypeController {

	@Autowired
	ChannelTypeService channelTypeService;
	/**
	 * @author 韩超
	 * 查询全部类型
	 * top_down 1上游  2下游
	 * @return
	 */
	@RequestMapping("findAllChannelType")
	public List<ChannelType> findAllChannelType(Integer top_down){
		return channelTypeService.findAllType(top_down);
	}
}
