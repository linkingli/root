package cn.ssm.controller;

import cn.ssm.entity.ChannelTop;
import cn.ssm.entity.ChannelTopExample;
import cn.ssm.service.master.ChannelTopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@EnableAutoConfiguration
public class ChannelTopController extends BaseController<ChannelTop,ChannelTopExample>{

    @Autowired
    private ChannelTopService service;
    @Override
	@RequestMapping("/addChannelTop")
    public String insert(ChannelTop entity) {
        return super.insert(entity);
    }

    @Override
	@RequestMapping("/updateChannelTop")
    public String updateBySelective(ChannelTop entity) {
        return super.updateBySelective(entity);
    }

    @Override
	@RequestMapping("/deleteChannelTop")
    public String deleteByPrimaryKey(@RequestParam("ids[]")String[] ids) {
        return super.deleteByPrimaryKey(ids);
    }

    @Override
	@RequestMapping("/queryChannelTopById")
    public String selectByPrimaryKey(String id) {
        return super.selectByPrimaryKey(id);
    }

    @Override
	@RequestMapping("/queryAllChannelTop")
    public String selectAll() {
        return super.selectAll();
    }

    @Override
	@RequestMapping("/importChannelTop")
    public String importExcel(MultipartFile file) {
       try {
           List<List<String>> rows=getList(file);
           if(rows==null || rows.size()==0){
               return "error";
           }
           //遍历list
           for (List<String> column : rows) {
               ChannelTop channelTop=new ChannelTop();
               channelTop.setId(column.get(0));
               channelTop.setChannelName(column.get(1));
               channelTop.setParentId(column.get(2));
               channelTop.setChannelType(column.get(3));
               //保存
               int i=service.insert(channelTop);
               if(i<=0){
                   return "error";
               }
           }
           return "ok";
       }catch (Exception e){
           return "error";
       }
    }
}
