package cn.ssm.service.master;

import java.util.List;

import cn.ssm.entity.ChannelDown;
import cn.ssm.entity.ChannelDownExample;
import cn.ssm.entity.channel.ChannelType;
import cn.ssm.entity.channel.PageBean;
import cn.ssm.service.BaseService;

public interface ChannelDownService extends BaseService<ChannelDown,ChannelDownExample>{

	/**
	 * 通过渠道名称模糊查询
	 * @param string 搜索关键字
	 * @return 渠道实体列表
	 * @author 张长江
	 */
	List<ChannelDown> selectByChannelName(String string);
	
	/**
	 * 通过渠道类型模糊查询
	 * @param string 搜索关键字
	 * @return 渠道实体列表
	 * @author 张长江
	 */
	List<ChannelType> selectByChannelType(String string);

	/**
	 * 新增下游渠道信息
	 * @param down
	 * @return 渠道实体
	 * @author 李林洪
	 */
	ChannelDown insertDown(ChannelDown down);
	
	/**
	 * @author 韩超
	 * 分页模糊查找
	 * @param currPage 当前页
	 * @param pageSize 每页显示条数
	 * @param kw 名称关键字
	 * @param type 类型关键字
	 * @return
	 */
	PageBean<ChannelDown> findByConditionPages(int currPage, int pageSize,ChannelDown channelDown);

	List<ChannelDown> selectAll();

	ChannelDown updateDown(ChannelDown down);
}
