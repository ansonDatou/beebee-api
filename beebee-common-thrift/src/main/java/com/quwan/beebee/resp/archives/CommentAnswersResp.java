package com.quwan.beebee.resp.archives;

/**
 * Created by anson on 2017/12/11.
 * 用于获取评论接口
 * 查询 bb_archives_comment 列表
 * 查询 bb_archives_comment_answer 列表
 * 最后将两个列表组合起来在排序
 */
public class CommentAnswersResp {

//  公共
    private Integer archId;
    private String addTime;
    private Integer type; // 0 = 评论，1 = 回复评论

//  评论
    private Integer commentId;
    private Integer userId;
    private String username;
    private String commentContent;
    private String nickname;
    private String head;

//  回复评论
    private Integer answerId;
    private String headAnswer;
    private String nicknameAnswer;
    private String nicknameNotify;
    private Integer userIdAnswer;
    private Integer userIdNotify;
    private String answerContent;

    public Integer getArchId() {
        return archId;
    }

    public void setArchId(Integer archId) {
        this.archId = archId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public Integer getAnswerId() {
        return answerId;
    }

    public void setAnswerId(Integer answerId) {
        this.answerId = answerId;
    }

    public String getHeadAnswer() {
        return headAnswer;
    }

    public void setHeadAnswer(String headAnswer) {
        this.headAnswer = headAnswer;
    }

    public String getNicknameAnswer() {
        return nicknameAnswer;
    }

    public void setNicknameAnswer(String nicknameAnswer) {
        this.nicknameAnswer = nicknameAnswer;
    }

    public String getNicknameNotify() {
        return nicknameNotify;
    }

    public void setNicknameNotify(String nicknameNotify) {
        this.nicknameNotify = nicknameNotify;
    }

    public Integer getUserIdAnswer() {
        return userIdAnswer;
    }

    public void setUserIdAnswer(Integer userIdAnswer) {
        this.userIdAnswer = userIdAnswer;
    }

    public Integer getUserIdNotify() {
        return userIdNotify;
    }

    public void setUserIdNotify(Integer userIdNotify) {
        this.userIdNotify = userIdNotify;
    }

    public String getAnswerContent() {
        return answerContent;
    }

    public void setAnswerContent(String answerContent) {
        this.answerContent = answerContent;
    }

    @Override
    public String toString() {
        return "CommentAnswersResp{" +
                "archId=" + archId +
                ", addTime='" + addTime + '\'' +
                ", type=" + type +
                ", commentId=" + commentId +
                ", userId=" + userId +
                ", username='" + username + '\'' +
                ", commentContent='" + commentContent + '\'' +
                ", nickname='" + nickname + '\'' +
                ", head='" + head + '\'' +
                ", answerId=" + answerId +
                ", headAnswer='" + headAnswer + '\'' +
                ", nicknameAnswer='" + nicknameAnswer + '\'' +
                ", nicknameNotify='" + nicknameNotify + '\'' +
                ", userIdAnswer=" + userIdAnswer +
                ", userIdNotify=" + userIdNotify +
                ", answerContent='" + answerContent + '\'' +
                '}';
    }
}
