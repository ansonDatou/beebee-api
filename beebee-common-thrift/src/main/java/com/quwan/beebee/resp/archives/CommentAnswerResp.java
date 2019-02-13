
package com.quwan.beebee.resp.archives;

public class CommentAnswerResp {

  private Integer answerId;
  private String headAnswer;
  private String nicknameAnswer;
  private String nicknameNotify;
  private Integer userIdAnswer;
  private Integer userIdNotify;
  private String content;
  private String answerTime;

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

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getAnswerTime() {
    return answerTime;
  }

  public void setAnswerTime(String answerTime) {
    this.answerTime = answerTime;
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

  @Override
  public String toString() {
    return "CommentAnswerResp{" +
            "answerId=" + answerId +
            ", headAnswer='" + headAnswer + '\'' +
            ", nicknameAnswer='" + nicknameAnswer + '\'' +
            ", nicknameNotify='" + nicknameNotify + '\'' +
            ", userIdAnswer=" + userIdAnswer +
            ", userIdNotify=" + userIdNotify +
            ", content='" + content + '\'' +
            ", answerTime='" + answerTime + '\'' +
            '}';
  }
}
