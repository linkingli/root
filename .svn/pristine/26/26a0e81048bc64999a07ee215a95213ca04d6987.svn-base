package cn.ssm.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import cn.ssm.mapper.master.BaseMapper;
import cn.ssm.service.BaseService;

public abstract class BaseServiceImpl<T,Example> implements BaseService<T,Example> {

    private  final Logger LOGGER= LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BaseMapper<T,Example> mapper;

    @Override
	public int insert(T entity) {
       try {
           //参数为null，返回0
           if(null==entity){
               return 0;
           }
           //插入数据库,i为数据库受影响行数，
           return mapper.insert(entity);
       }catch (Exception e){
           e.printStackTrace();
           LOGGER.debug("insert exception");
           return 0;
       }
    }

    @Override
	public int updateBySelective(T entity) {
       try {
           //参数为null，返回0
           if(null==entity){
               return 0;
           }
           //更新到数据库
           return mapper.updateByPrimaryKeySelective(entity);
       }catch (Exception e){
           LOGGER.debug("update exception");
           return 0;
       }
    }

    @Override
	public int deleteByPrimaryKey(String id) {
        try{
            //id为null或者去掉首尾空格为空字符串
            if(null==id || "".equals(id.trim())){
                return 0;
            }
            //删除实体
            return mapper.deleteByPrimaryKey(id);
        }catch (Exception e){
            LOGGER.debug("delete exception");
            return 0;
        }
    }

    @Override
	public T selectByPrimaryKey(String id) {
        try {
            //id为null或者去掉首尾空格为空字符串
            if(null==id || "".equals(id.trim())){
                return null;
            }
            //查询数据库
            return mapper.selectByPrimaryKey(id);
        }catch (Exception e){
            LOGGER.debug("selectByPrimaryKey exception");
            return null;
        }
    }

    @Override
	public List<T> selectByExample(Example example) {
        try {
            //参数为null,返回null
            if(null==example){
                return null;
            }
            return mapper.selectByExample(example);
        }catch (Exception e){
            LOGGER.debug("selectByExample exception");
            return null;
        }
    }
}
