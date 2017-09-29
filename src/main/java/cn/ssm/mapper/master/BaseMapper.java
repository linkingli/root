package cn.ssm.mapper.master;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BaseMapper<T,Example> {
    /**
     * 根据实体扩展类查询实体记录数
     */
    int countByExample(Example example);

    /**
     * 根据实体扩展类删除实体
     */
    int deleteByExample(Example example);

    /**
     * 根据实体主键删除实体
     */
    int deleteByPrimaryKey(String id);

    /**
     * 插入实体
     */
    int insert(T record);

    /**
     * 插入实体(只插入不为null的字段,不会影响有默认值的字段)
     */
    int insertSelective(T record);

    /**
     * 根据实体扩展类查询实体
     */
    List<T> selectByExample(Example example);
    /**
     * 根据实体id查询实体
     */
    T selectByPrimaryKey(String id);

    /**
     * 根据实体扩展类更新实体(只更新不为null的字段,不会影响有默认值的字段)
     */
    int updateByExampleSelective(@Param("record") T record, @Param("example") Example example);

    /**
     * 根据实体扩展类更新实体
     */
    int updateByExample(@Param("record") T record, @Param("example") Example example);

    /**
     * 根据实体id更新实体(只更新不为null的字段,不会影响有默认值的字段)
     */
    int updateByPrimaryKeySelective(T record);

    /**
     * 根据实体id更新实体
     */
    int updateByPrimaryKey(T record);
}
