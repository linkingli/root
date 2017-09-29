package cn.ssm.controller;

import cn.ssm.service.BaseService;
import cn.ssm.utils.FileUtils;
import cn.ssm.utils.JSONUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.List;

public abstract class BaseController<T,Example> {

    @Autowired
    private BaseService<T,Example> service;

    /**
     * 插入实体
     * @param entity 实体
     */
    public String insert(T entity){
        if(null==entity){
            return "error";
        }
        //插入数据库
        int i=service.insert(entity);
        if(i<=0){
            return "error";
        }
        return "ok";
    }
    /**
     * 更新实体
     * @param entity 实体
     */
    public String updateBySelective(T entity){
        //参数为null
        if(null==entity){
            return "error";
        }
        //更新到数据库
        int i=service.updateBySelective(entity);
        if(i<=0){
            return "error";
        }
        return "ok";
    }

    /**
     * 根据实体id数组删除
     * @param ids 实体id数组
     */
    public String deleteByPrimaryKey(String[] ids){
        if(ids==null){
            return "error";
        }
        for (String id:ids) {
            int i= service.deleteByPrimaryKey(id);
            if(i<0){
                return "error";
            }
        }
        return "ok";
    }

    /**
     * 根据实体id查询
     * @param id id
     */
    public String selectByPrimaryKey(String id){
        if(null==id ||"".equals(id.trim())){
            return "error";
        }
        //查询数据库
        T entity=service.selectByPrimaryKey(id);
        if(null==entity){
            return "error";
        }
        //将实体对象转化成json字符串
        return JSONUtil.objectToJSON(entity,null);
    }

    /**
     * 查询所有实体对象
     */
    public String selectAll(){
        List<T> entities=service.selectByExample(null);
        //查询失败
        if(null==entities || entities.size()==0){
            return "error";
        }
        //将实体对象集合转化为json字符串
        return JSONUtil.objctToJSONArray(entities,null);
    }

    /**
     * 导入excel
     * @param file excel文件
     * @return
     */
    public abstract String importExcel(MultipartFile file);

    /**
     * 根据file获取实体属性的集合
     * @param file
     * @return
     */
    protected List<List<String>> getList(MultipartFile file){
        try{
            if(file==null){
                return null;
            }
            //获取file的mime类型
            String mimeType=file.getContentType();
            //file类型不正确
//            if(!mimeType.endsWith("excel")){
//                return null;
//            }
            InputStream in=file.getInputStream();
            String filename=file.getOriginalFilename();
            List<List<String>> values=FileUtils.importExcel(in,filename,true);
            return values;

        }catch (Exception e){
            return null;
        }
    }
}
