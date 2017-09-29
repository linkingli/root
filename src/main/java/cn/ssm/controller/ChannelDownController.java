package cn.ssm.controller;

import cn.ssm.entity.ChannelDown;
import cn.ssm.entity.ChannelDownExample;
import cn.ssm.service.master.ChannelDownService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping(value="channelDown")
public class ChannelDownController extends BaseController<ChannelDown,ChannelDownExample>{

    @Autowired
    private ChannelDownService service;

    @Override
	@RequestMapping("/addChannelDown")
    public String insert(ChannelDown channelDown) {
        return super.insert(channelDown);
    }

    @Override
	@RequestMapping("/updateChannelDown")
    public String updateBySelective(ChannelDown channelDown) {
        return super.updateBySelective(channelDown);
    }

    @Override
	@RequestMapping("/deleteChannelDown")
    public String deleteByPrimaryKey(@RequestParam("ids[]") String[] ids) {
        return super.deleteByPrimaryKey(ids);
    }

    @Override
	@RequestMapping("/queryChannelDownById")
    public String selectByPrimaryKey(String id) {
        return super.selectByPrimaryKey(id);
    }

    @Override
	@RequestMapping("/queryAllChannelDown")
    public String selectAll() {
        return super.selectAll();
    }

    @Override
	@RequestMapping("/importChannelDown")
    public String importExcel(MultipartFile file) {
        List<List<String>> rows=getList(file);
        if(null==rows || rows.size()==0){
            return "error";
        }
        //遍历list
        for (List<String> column : rows) {
            ChannelDown channelDown=new ChannelDown();
            channelDown.setId(column.get(0));
            channelDown.setChannelName(column.get(1));
            channelDown.setType(Integer.parseInt(column.get(2)));
            //保存
            int i=service.insert(channelDown);
            if(i<=0){
                return "error";
            }
        }
        return "ok";
    }
}
