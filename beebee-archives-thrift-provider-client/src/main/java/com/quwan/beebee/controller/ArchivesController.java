package com.quwan.beebee.controller;

import com.alibaba.fastjson.JSON;
import com.quwan.beebee.param.archives.*;
import com.quwan.beebee.utils.Result;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import com.quwan.beebee.utils.ThriftUtil;

/**
 * Created by anson on 2017/10/9.
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/archives")
public class ArchivesController {

    @Autowired
    private ThriftUtil thriftUtil;

    private static final Logger LOGGER = LoggerFactory.getLogger(ArchivesController.class);

    /**
     * 获取文章分类
     * @param
     * @return
     */
    @PostMapping("/getArchivesSort")
    public String getArchivesSort() {
        return thriftUtil.remoteInvoke("getArchivesSort", StringUtils.EMPTY);
    }

    /**
     * 首页接口
     * @param param
     * @return
     */
    @PostMapping("/getList")
    public String getList(@RequestBody ArchivesListParam param) {
        return thriftUtil.remoteInvoke("getArchivesList", param);
    }

    /**
     * @Title: getContent 
     * @Description: 文章详情页
     * @param param
     * @return String    返回类型 
     * @author lijing
      */
     @PostMapping("/getArchivesContent")
     public String getArchivesContent(@RequestBody ArchivesContentParam param) {
         String content = thriftUtil.remoteInvoke("getArchivesContent", param);
         if (!StringUtils.contains(content, "DOCTYPE")) {
             return JSON.toJSONString(Result.error());
         }
         thriftUtil.remoteInvoke("updateUserBehavior", param);
         return content;
     }
     
    /**
     * 回复评论
     * @param param
     * @return
     */
    @PostMapping("/answerComment")
    public String answerComment(@RequestBody AnswerParam param) {
        return thriftUtil.remoteInvoke("answerComment", param);
    }

    /**
     * 获取评论
     * @param param
     * @return
     */
    @PostMapping("/getCommentList")
    public String getCommentList(@RequestBody CommentListParam param) {
        return thriftUtil.remoteInvoke("getCommentList", param);
    }

    /**
     * 设置文章阅读完成、未完成
     * 李静
     * @param param
     * @return
     */
    @PostMapping("/updateArchivesReadStatus")
    public String updateArchivesReadStatus(@RequestBody ArchivesReadParam param) {
        return thriftUtil.remoteInvoke("updateArchivesReadStatus", param);
    }

    /**
     * 文章是否收藏 1：是，0：否
     * 李静
     * @param param
     * @return
     */
    @PostMapping("/isCollection")
    public String isCollection(@RequestBody ArchivesUserParam param) {
        return thriftUtil.remoteInvoke("isCollection", param);
    }

    /**
     * 收藏文章
     * 收藏文章
     * @param param
     * @return
     */
    @PostMapping("/collect")
    public String collect(@RequestBody ArchivesCollectionParam param) {
        return thriftUtil.remoteInvoke("collect", param);
    }

    /**
     * 文章点赞
     * 李静
     * @param param
     * @return
     */
    @PostMapping("/praise")
    public String praise(@RequestBody ArchivesPraiseParam param) {
        return thriftUtil.remoteInvoke("praise", param);
    }

    /**
     * 文章是否点赞 1：是，0：否
     * 李静
     * @param param
     * @return
     */
    @PostMapping("/isPraise")
    public String isPraise(@RequestBody ArchivesUserParam param) {
        return thriftUtil.remoteInvoke("isPraise", param);
    }

    /**
     * 举报文章
     * 李静
     * @param param
     * @return
     */
    @PostMapping("/addComplain")
    public String addComplain(@RequestBody ArchivesComplainParam param) {
        return thriftUtil.remoteInvoke("addComplain", param);
    }

    /**
     * 添加转发记录
     * 李静
     * @param param
     * @return
     */
    @PostMapping("/addShare")
    public String addShare(@RequestBody ArchivesShareParam param) {
        return thriftUtil.remoteInvoke("addShare", param);
    }

    /**
     * 文章评论
     * 于浩
     * @param param
     * @return
     */
    @PostMapping("/addComment")
    public String addComment(@RequestBody ArchivesCommentParam param) {
        return thriftUtil.remoteInvoke("addComment", param);
    }

    /**
     * 推荐文章列表
     * 何飞达
     * @param param
     * @return
     */
    @PostMapping("/pushArchivesList")
    public String pushArchivesList(@RequestBody ArchivesPushParam param) { return thriftUtil.remoteInvoke("pushArchivesList", param);}

}
