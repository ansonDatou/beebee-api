package com.quwan.beebee.controller;

import com.quwan.beebee.entity.archives.Tag;
import com.quwan.beebee.entity.archives.UserBehavior;
import com.quwan.beebee.service.SendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProducerController {

    @Autowired
    private SendService service;

    @RequestMapping(value = "/send/recordUserBehavior", method = RequestMethod.POST)
    public void recordUserBehavior(@RequestBody List<UserBehavior> list){
        service.recordUserBehavior(list);
    }









    // ------------------------------------------------------------------------------------------

    /**
     * 测试代码
     * @param msg
     */
    @RequestMapping(value = "/send/{msg}", method = RequestMethod.GET)
    public void send(@PathVariable("msg") String msg){
        service.sendMessage(msg);
    }

    /**
     * 测试kafka 自定义数据结构
     * @param list
     */
    @RequestMapping(value = "/send/testList", method = RequestMethod.POST)
    public void send(@RequestBody List<Tag> list){
        service.sendMessage(list.get(0).getCat1());
    }

    /**
     * 测试kafka List数据结构
     * @param ids
     * @return
     */
    @RequestMapping(value = "/sendList/{ids}", method = RequestMethod.POST)
    public String sendIds(@PathVariable("ids") List<Integer> ids){
        service.sendList(ids);
        return "1";
    }
}