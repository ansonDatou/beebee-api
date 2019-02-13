package com.quwan.beebee.resp.archives;

import java.util.List;


public class CommentAnswerListResp {

  private Integer archId;

  private List<CommentListResp> commentListResp;

  public Integer getArchId() {
    return archId;
  }

  public void setArchId(Integer archId) {
    this.archId = archId;
  }

  public List<CommentListResp> getCommentListResp() {
    return commentListResp;
  }

  public void setCommentListResp(List<CommentListResp> commentListResp) {
    this.commentListResp = commentListResp;
  }

  @Override
  public String toString() {
    return "CommentAnswerListResp{" +
            "archId=" + archId +
            ", commentListResp=" + commentListResp +
            '}';
  }
}

