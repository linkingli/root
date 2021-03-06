package cn.ssm.mapper.master;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import cn.ssm.entity.ChannelTop;
import cn.ssm.entity.ChannelTopExample;
import cn.ssm.entity.channel.ChannelType;

@Mapper
public interface ChannelTopMapper extends BaseMapper<ChannelTop,ChannelTopExample> {
	
	int countByExample(Map<String,Object> params);

    @Override
	int deleteByExample(ChannelTopExample channelTopExample);

    @Override
	int deleteByPrimaryKey(String id);

    @Override
	int insert(ChannelTop record);

    @Override
	int insertSelective(ChannelTop record);

    @Override
	List<ChannelTop> selectByExample(ChannelTopExample channelTopExample);

    @Override
	ChannelTop selectByPrimaryKey(String id);

    @Override
	int updateByExampleSelective(ChannelTop record, ChannelTopExample channelTopExample);

    @Override
	int updateByExample(ChannelTop record, ChannelTopExample channelTopExample);

    @Override
	int updateByPrimaryKeySelective(ChannelTop record);

    @Override
	int updateByPrimaryKey(ChannelTop record);
    
    List<ChannelTop> quryByPage(int param, int pageSize);

	List<ChannelTop> selectByChannelName(String param);

	List<ChannelType> selectByChannelType(String string);
	
	/**
	 * @author 韩超
	 * 分页模糊查找
	 * @param currPage
	 * @param pageSize
	 * @return
	 */
	List<ChannelTop> quryByConditionPage(Map<String,Object> params);
	@Select("select id,channel_name as channelName from channel_top where parent_id is null or parent_id=''")
	List<ChannelTop> queryCp();
	/**
	 * 查询所有
	 */
	List<ChannelTop> selectAll();
}