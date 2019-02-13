package com.quwan.beebee.controller;

import com.quwan.beebee.common.Method;
import com.quwan.beebee.common.Server;
import com.quwan.beebee.param.archives.*;
import com.quwan.beebee.utils.EurekaUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by anson on 2017/10/9.
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/archives")
public class ArchivesController {

    @Autowired
    private EurekaUtil eurekaUtil;

    /**
     * 获取文章分类
     * @return
     */
    @PostMapping("/getArchivesSort")
    public String getArchivesSort() {
        return eurekaUtil.remoteInvoke(Server.BEEBEE_ARCHIVES_THRIFT_PROVIDER_CLIENT, Method.ARCHIVES_GET_ARCHIVES_SORT, StringUtils.EMPTY);
    }

    /**
     * 首页获取列表
     * @param param
     * @return
     */
    @PostMapping("/getList")
    public String getList(ArchivesListParam param) {
        return eurekaUtil.remoteInvoke(Server.BEEBEE_ARCHIVES_THRIFT_PROVIDER_CLIENT, Method.ARCHIVES_GET_LIST, param);
    }

    /**
     * @Title: getContent
     * @Description: 文章详情页
     * @param param
     * @return String    返回类型
     * @author 李静
     */
    @GetMapping("/getArchivesContent")
    public String getArchivesContent(ArchivesContentParam param) {
        return eurekaUtil.remoteInvoke(Server.BEEBEE_ARCHIVES_THRIFT_PROVIDER_CLIENT, Method.ARCHIVES_GET_ARCHIVES_CONTENT, param);
    }

    /**
     * 回复评论
     * @param param
     * @return
     */
    @RequestMapping("/answerComment")
    public String answerComment(AnswerParam param) {
        return eurekaUtil.remoteInvoke(Server.BEEBEE_ARCHIVES_THRIFT_PROVIDER_CLIENT, Method.ARCHIVES_ANSWER_COMMENT, param);
    }

    /**
     * 获取评论
     * @param param
     * @return
     */
    @RequestMapping("/getCommentList")
    public String getCommentList(CommentListParam param) {
        return eurekaUtil.remoteInvoke(Server.BEEBEE_ARCHIVES_THRIFT_PROVIDER_CLIENT, Method.ARCHIVES_GET_COMMENT_LIST, param);
    }

    /**
     * 设置文章阅读完成、未完成
     * 李静
     * @param param
     * @return
     */
    @PostMapping("/updateArchivesReadStatus")
    public String updateArchivesReadStatus(ArchivesReadParam param) {
        return eurekaUtil.remoteInvoke(Server.BEEBEE_ARCHIVES_THRIFT_PROVIDER_CLIENT, Method.ARCHIVES_UPDATE_ARCHIVES_READ_STATUS, param);
    }

    /**
     * 文章是否收藏 1：是，0：否
     * 李静
     * @param param
     * @return
     */
    @PostMapping("/isCollection")
    public String isCollection(ArchivesUserParam param) {
        return eurekaUtil.remoteInvoke(Server.BEEBEE_ARCHIVES_THRIFT_PROVIDER_CLIENT, Method.ARCHIVES_IS_COLLECTION, param);
    }

    /**
     * 收藏文章
     * 收藏文章
     * @param param
     * @return
     */
    @PostMapping("/collect")
    public String collect(ArchivesCollectionParam param) {
        return eurekaUtil.remoteInvoke(Server.BEEBEE_ARCHIVES_THRIFT_PROVIDER_CLIENT, Method.ARCHIVES_COLLECT, param);
    }

    /**
     * 文章点赞
     * 李静
     * @param param
     * @return
     */
    @PostMapping("/praise")
    public String praise(ArchivesPraiseParam param) {
        return eurekaUtil.remoteInvoke(Server.BEEBEE_ARCHIVES_THRIFT_PROVIDER_CLIENT, Method.ARCHIVES_PRAISE, param);
    }

    /**
     * 文章是否点赞 1：是，0：否
     * 李静
     * @param param
     * @return
     */
    @PostMapping("/isPraise")
    public String isPraise(ArchivesUserParam param) {
        return eurekaUtil.remoteInvoke(Server.BEEBEE_ARCHIVES_THRIFT_PROVIDER_CLIENT, Method.ARCHIVES_IS_PRAISE, param);
    }

    /**
     * 举报文章
     * 李静
     * @param param
     * @return
     */
    @PostMapping("/addComplain")
    public String addComplain(ArchivesComplainParam param) {
        return eurekaUtil.remoteInvoke(Server.BEEBEE_ARCHIVES_THRIFT_PROVIDER_CLIENT, Method.ARCHIVES_ADD_COMPLAIN, param);
    }

    /**
     * 添加转发记录
     * 李静
     * @param param
     * @return
     */
    @PostMapping("/addShare")
    public String addShare(ArchivesShareParam param) {
        return eurekaUtil.remoteInvoke(Server.BEEBEE_ARCHIVES_THRIFT_PROVIDER_CLIENT, Method.ARCHIVES_ADD_SHARE, param);
    }

    /**
     * 文章评论
     * 于浩
     * @param param
     * @return
     */
    @PostMapping("/addComment")
    public String addComment(ArchivesCommentParam param) { return eurekaUtil.remoteInvoke(Server.BEEBEE_ARCHIVES_THRIFT_PROVIDER_CLIENT, Method.ARCHIVES_ADD_COMMENT, param);}

    /**
     * 推荐文章列表
     * 何飞达
     * @param param
     * @return
     */
    @PostMapping("/pushArchivesList")
    public String pushArchivesList(ArchivesPushParam param) { return eurekaUtil.remoteInvoke(Server.BEEBEE_ARCHIVES_THRIFT_PROVIDER_CLIENT, Method.ARCHIVES_PUSH_ARCHIVES_LIST, param);}

}
