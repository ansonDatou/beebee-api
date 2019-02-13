
package com.quwan.beebee.topic;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.quwan.beebee.HttpPostService;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 测试Topic模块
 */
public class JunitTest {

    private static final String PORT = "10221";

    /**
     * 哔哔首页 获取列表
     */
    @Test
    public void getList() {
        Map<String, String> param = new HashMap<String, String>();
        param.put("sortType", "1");
        param.put("pageNumber", "1");
        param.put("pageSize", "10");
        param.put("type", "1");
        param.put("userId", "64");
        HttpPostService.testService(param, PORT, "/topic/getList");
    }

    /**
     * 获取活动评论回复列表
     */
    @Test
    public void getCommentReplyList() {
        Map<String, String> param = new HashMap<String, String>();
        param.put("commentId", "56");
        param.put("pageNumber", "1");
        param.put("pageSize", "12");
        HttpPostService.testService(param, PORT, "/topic/getCommentReplyList");
    }

    /**
     * 添加活动评论回复
     */
    @Test
    public void addCommentReply() {
        Map<String, String> param = new HashMap<String, String>();
        param.put("userId", "56");
        param.put("topicId", "56");
        param.put("commentId", "56");
        param.put("content", "很好很好，腻害腻害666666");
        HttpPostService.testService(param, PORT, "/topic/addCommentReply");
    }

    /**
     * 话题投票
     */
    @Test
    public void addVote() {
        Map<String, String> param = new HashMap<String, String>();
        param.put("userId", "471");
        param.put("topicId", "55");
        param.put("optionId", "311");
        HttpPostService.testService(param, PORT, "/topic/addVote");
    }

    /**
     * 获取话题详情
     */
    @Test
    public void getDetail() {
        Map<String, String > param = new HashMap<String, String >();
        param.put("topicId", "1");
        HttpPostService.testService(param, PORT, "/topic/getDetail");
    }

    /**
     * 获取话题弹幕列表
     */
    @Test
    public void getBarrageList() {
        Map<String, String > param = new HashMap<String, String >();
        param.put("topicId", "33");
        param.put("userId", "95");
        param.put("sortType", "1");
        param.put("pageNumber", "1");
        param.put("pageSize", "10");
        HttpPostService.testService(param, PORT, "/topic/getBarrageList");
    }

    /**
     * 增加评论点赞
     */
    @Test
    public void addCommentPraise() {
        Map<String, String > param = new HashMap<String, String >();
        param.put("commentId", "133");
        param.put("userId", "600");
        param.put("valid", "0");
        HttpPostService.testService(param, PORT, "/topic/updateCommentPraiseStatus");
    }

    /**
     * 更新评论点赞状态
     */
    @Test
    public void updateCommentPraise() {
        Map<String, String > param = new HashMap<String, String >();
        param.put("commentId", "133");
        param.put("userId", "500");
        param.put("valid", "1");
        HttpPostService.testService(param, PORT, "/topic/updateCommentPraiseStatus");
    }

    /**
     * 添加哔哔话题
     */
    @Test
    public void addTopic(){
        Map<String, String> param = new HashMap<String , String>();
        param.put("userId", "111");
        param.put("title", "主题777");
        param.put("type", "2");
        param.put("content", "[{\"type\":\"text\",\"content\":\"嘻嘻嘻哈哈\"}]");
        param.put("img", "[{\"name\":\"img\",\"url\":\"\"}]");
        param.put("replierIdentity", "[{\"identity\":\"早已洞察一切的路人\"}]");
        param.put("multiSelect", "1");

        param.put("option[0].topicId", "1");
        param.put("option[0].name", "zs");
        param.put("option[0].male", "3");
        param.put("option[0].female", "4");
        param.put("option[0].unknownSex", "2");
        param.put("option[0].total", "11");
        param.put("option[0].img", "http://img");
//        param.put("option[0].order", "19");

        param.put("option[1].topicId", "2");
        param.put("option[1].name", "ls");
        param.put("option[1].male", "13");
        param.put("option[1].female", "14");
        param.put("option[1].unknownSex", "1");
        param.put("option[1].total", "111");
        param.put("option[1].img", "http://img1");
//        param.put("option[1].order", "20");

        HttpPostService.testService(param, PORT, "/topic/addTopic");
    }

    /**
     * 获取活动评论列表
     */
    @Test
    public void getCommentList() {
        Map<String, String > param = new HashMap<String, String >();
        param.put("topicId", "996");
        param.put("sort", "1");
        param.put("pageNumber", "1");
        param.put("pageSize", "10");
        param.put("userId", "64");
        HttpPostService.testService(param, PORT, "/topic/getCommentList");
    }

    /**
     * 活动添加评论
     */
    @Test
    public void addComment() {
        Map<String, String > param = new HashMap<String, String >();
        param.put("topicId", "96");
        param.put("userId", "1");
        param.put("content", "10");
        param.put("identity", "早已洞察一切的路人");
        param.put("color", "fb8e8d");
        HttpPostService.testService(param, PORT, "/topic/addComment");
    }

    /**
     * 热门推荐
     */
    @Test
    public void getHotRecommend() {
        Map<String, String > param = new HashMap<String, String >();
        param.put("type", "0");
        HttpPostService.testService(param, PORT, "/topic/getHotRecommend");
    }

    /**
     * 获取活动评论火热的三条回复评论
     */
    @Test
    public void getCommentReplyThreeList() {
        Map<String, String > param = new HashMap<String, String>();
        param.put("commentId", "56");
        HttpPostService.testService(param, PORT, "/topic/getCommentReplyThreeList");
    }

    /**
     * 获取话题评论回复用户
     */
    @Test
    public void getCommentReplyUser() {
        Map<String, String> param = new HashMap<>();
        param.put("userId", "64");
        param.put("topicId", "5");
        param.put("commentId", "11");
        HttpPostService.testService(param, PORT, "/topic/getCommentReplyUser");
    }

    @Test
    public void test() {
        String replierID = "[{\"identity\":\"老司机\"}]";
//        String replierID = "[{\"0\":\"zhangsan\",\"1\":\"lisi\",\"2\":\"wangwu\",\"3\":\"maliu\"}," +
//                "{\"00\":\"zhangsan\",\"11\":\"lisi\",\"22\":\"wangwu\",\"33\":\"maliu\"}]";
        System.out.println(replierID);


        List<Map<String,String>> listObjectFir = (List<Map<String,String>>) JSONArray.parse(replierID);
        System.out.println("利用JSONArray中的parse方法来解析json数组字符串");
        System.out.println(listObjectFir.get(0).get("identity"));
    }
}
