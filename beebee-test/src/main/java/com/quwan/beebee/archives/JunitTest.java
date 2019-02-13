
package com.quwan.beebee.archives;

import com.quwan.beebee.HttpPostService;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Archives模块
 */
public class JunitTest {

    private static final String PORT = "10121";

    /**
     * 获取文章分类
     */
    @Test
    public void getArchivesSort() {
        Map<String, String> param = new HashMap<String, String>();
        HttpPostService.testService(param, PORT, "/archives/getArchivesSort");
    }

    /**
     * 获取文章列表
     */
    @Test
    public void getList() {
        Map<String, String> param = new HashMap<String, String>();
        param.put("userId", "64");
        param.put("sourceType", "1");
        param.put("pageNumber", "1");
        param.put("pageSize", "10");
        param.put("sortId", "1");
        HttpPostService.testService(param, PORT, "/archives/getList");
    }

    /**
     * 文章详情
     */
    @Test
    public void getArchivesContent() {
        Map<String, String> param = new HashMap<String, String>();
        param.put("id", "480");
        param.put("userId", "2");
        param.put("deviceType", "1");
        param.put("deviceId", "A922704D-792B-9B71-3852-A614B8673416");
        HttpPostService.testService(param, PORT, "/archives/getArchivesContent");
    }

    /**
     * 获取评论
     */
    @Test
    public void getCommentList() {
        Map<String, String> param = new HashMap<String, String>();
        param.put("archId", "1634");
        param.put("pageNumber", "1");
        param.put("pageSize", "10");
        param.put("userId", "64");
        HttpPostService.testService(param, PORT, "/archives/getCommentList");
    }

    /**
     * 文章阅读完成、未完成
     */
    @Test
    public void updateArchivesReadStatus() {
        Map<String, String> param = new HashMap<String, String>();
        param.put("archId", "56");
        param.put("duration", "100");
        param.put("status", "1");
        param.put("cId", "1222");
        param.put("type", "1");
        HttpPostService.testService(param, PORT, "/archives/updateArchivesReadStatus");
    }

    /**
     * 文章是否收藏
     */
    @Test
    public void isCollection() {
        Map<String, String> param = new HashMap<String, String>();
        param.put("archId", "518");
        param.put("userId", "479");
        HttpPostService.testService(param, PORT, "/archives/isCollection");
    }

    /**
     * 文章是否点赞
     */
    @Test
    public void isPraise() {
        Map<String, String> param = new HashMap<String, String>();
        param.put("archId", "56");
        param.put("userId", "56");
        param.put("deviceId", "1222");
        param.put("deviceType", "1");
        HttpPostService.testService(param, PORT, "/archives/isPraise");
    }

    /**
     * 文章是否点赞
     */
    @Test
    public void praise() {
        Map<String, String> param = new HashMap<String, String>();
        param.put("archId", "480");
        param.put("userId", "56");
        param.put("deviceId", "1222");
        param.put("deviceType", "1");
        param.put("valid","1");
        HttpPostService.testService(param, PORT, "/archives/praise");
    }

    /**
     * 回复评论接口
     */
    @Test
    public void answerComment(){
        Map<String, String> param = new HashMap<String, String>();
        param.put("commentId", "65");
        param.put("archId", "5");
        param.put("userIdAnswer", "66");
        param.put("content", "十多年福克斯的烦恼12");
        param.put("userIdNotify","16");
        param.put("answerTime","2017-12-18 24:34:12");
        HttpPostService.testService(param, PORT, "/archives/answerComment");
    }

    /**
     *  修改添加收藏
     */
    @Test
    public void collect(){
        Map<String, String> param = new HashMap<String, String>();
        param.put("archId", "615");
        param.put("userId","231");
        param.put("valid","1");
        param.put("modTime","2017-12-28 12:23:22");
        HttpPostService.testService(param, PORT, "/archives/collect");
    }

    /**
     *举报文章
     */
    @Test
    public void addComplain(){
        Map<String, String> param = new HashMap<String, String>();
        param.put("archId", "615");
        param.put("userId","231");
        param.put("reason","v啊u是发噶一个覅");
        param.put("deviceId","23");
        param.put("deviceType","3");
        HttpPostService.testService(param, PORT, "/archives/addComplain");
    }

    /**
     *添加分享记录
     */
    @Test
    public void addShare(){
        Map<String, String> param = new HashMap<String, String>();
        param.put("archId", "615");
        param.put("userId","231");
        param.put("target","23");
        param.put("deviceId","23");
        param.put("deviceType","3");
        HttpPostService.testService(param, PORT, "/archives/addShare");
    }

    /**
     * 文章评论
     */
    @Test
    public void addComment() {
        Map<String, String> param = new HashMap<String, String>();
        param.put("archId", "823");
        param.put("deviceId", "99");
        param.put("deviceType", "1");
        param.put("userId", "1273");
        param.put("content", "飞可谓JFK我");
        HttpPostService.testService(param, PORT, "/archives/addComment");
    }

    /**
     * 推荐文章列表
     */
    @Test
    public void pushArchivesList() {
        Map<String, String> param = new HashMap<String, String>();
        param.put("userId", "96");
        param.put("pushNum", "1");
        param.put("pushType", "1");
        HttpPostService.testService(param, PORT, "/archives/pushArchivesList");
    }

}
