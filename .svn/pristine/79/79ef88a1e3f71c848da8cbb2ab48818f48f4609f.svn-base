package cn.ssm.mapper.master;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import cn.ssm.entity.channel.ChannelType;
import cn.ssm.entity.channel.ChannelTypeExample;

public interface ChannelTypeMapper {
  
    int countByExample(ChannelTypeExample example);

   
    int deleteByExample(ChannelTypeExample example);

   
    int deleteByPrimaryKey(String id);

   
    int insert(ChannelType record);

    int insertSelective(ChannelType record);

   
    List<ChannelType> selectByExample(ChannelTypeExample example);

  
    ChannelType selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ChannelType record, @Param("example") ChannelTypeExample example);

   
    int updateByExample(@Param("record") ChannelType record, @Param("example") ChannelTypeExample example);


    int updateByPrimaryKeySelective(ChannelType record);

    int updateByPrimaryKey(ChannelType record);
    
    
    @Select("select * from channel_type where top_down=#{top_down}")
    List<ChannelType> getAllByTop_Down(Integer top_down);
    
    
}