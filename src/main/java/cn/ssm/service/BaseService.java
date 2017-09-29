package cn.ssm.service;

import java.util.List;

import cn.ssm.entity.ChannelTop;

public interface BaseService<T,Example> {
    /**
     * 插入实体
     * @param entity 实体
     * @return 返回受影响行数
     */
    int insert(T entity);
    /**
     * 更新实体
     * @param entity 实体
     * @return 返回受影响行数
     */
    int updateBySelective(T entity);

    /**
     * 根据实体id删除
     * @param id 实体id
     * @return 返回受影响行数
     */
    int deleteByPrimaryKey(String id);

    /**
     * 根据实体id查询
     * @param id id
     * @return 查询成功返回实体，否则返回null
     */
    T selectByPrimaryKey(String id);

    /**
     * 根据实体扩展类查询
     * @param example 实体扩展类
     * @return 查询成功返回实体的list集合，否则返回null
     */
    List<T> selectByExample(Example example);
	
}
