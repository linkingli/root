package cn.ssm.service.master;

import java.util.List;

import cn.ssm.entity.ChannelTop;
import cn.ssm.entity.ChannelTopExample;
import cn.ssm.entity.channel.ChannelType;
import cn.ssm.entity.channel.PageBean;
import cn.ssm.service.BaseService;

public interface ChannelTopService extends BaseService<ChannelTop,ChannelTopExample>{

	/**
	 * 通过渠道名称模糊查询
	 * @param str
	 * @return
	 * @author 张长江
	 */
	List<ChannelTop> selectByChannelName(String str);

	/**
	 * 通过渠道类型模糊查询
	 * @param string
	 * @return
	 * @author 张长江
	 */
	List<ChannelType> selectByChannelType(String string);

	/**
	 * 新增上游渠道信息
	 * 返回值不同
	 * @param top 新增的上游渠道实体
	 * @return 上游渠道实体
	 * @author 李林洪
	 */
	ChannelTop insertTop(ChannelTop top);

	/**
	 * 更新上游渠道信息
	 * 返回值不同
	 * @param top
	 * @return 上游渠道实体
	 * @author 李林洪
	 */
	ChannelTop updateTop(ChannelTop top);
	

	/**
	 * @author 韩超
	 * 分页模糊查找
	 * @param currPage 当前页
	 * @param pageSize 每一页显示条数
	 * @param kw 名称关键字
	 * @param type 类型关键字
	 * @return
	 */
	PageBean<ChannelTop> findByConditionPages(int currPage, int pageSize,ChannelTop channelTop);
	
	List<ChannelTop> queryCp();


	List<ChannelTop> selectAll();

}
