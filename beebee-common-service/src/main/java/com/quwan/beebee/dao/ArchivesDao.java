package com.quwan.beebee.dao;

import java.util.List;

import com.quwan.beebee.entity.archives.*;
import com.quwan.beebee.param.archives.*;
import com.quwan.beebee.param.user.SaveUserTagsParam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.quwan.beebee.resp.archives.ArchivesListResp;
import com.quwan.beebee.resp.archives.ArchivesPraiseResp;
import com.quwan.beebee.resp.archives.ArchivesSortResp;
import com.quwan.beebee.resp.archives.CommentAnswerListResp;
import com.quwan.beebee.resp.archives.CommentAnswersResp;
import com.quwan.beebee.resp.user.UserIntegralLogResp;

@Mapper
@Repository("archivesDao")
public interface ArchivesDao {

    List<ArchivesSortResp> getArchivesSort();

    List<ArchivesListResp> queryArchivesList(ArchivesListParam param);

    int queryArchivesTotal(ArchivesListParam param);

    List<ArchivesListResp> getArchivesList(ArchivesListParam param);

    int getArchivesTotal(ArchivesListParam param);

    Archives getArchiveById(@Param("id") int id);

    void answerComment(@Param("param") AnswerParam param);

    CommentAnswerListResp getCommentList(@Param("param") CommentListParam param);

    int getCommentListTotal(@Param("param") CommentListParam param, @Param("userIds") List<Integer> userIds);

    List<CommentAnswersResp> getComments(@Param("param") CommentListParam param, @Param("userIds") List<Integer> userIds);

    List<CommentAnswersResp> getAnswers(@Param("param") CommentListParam param, @Param("userIds") List<Integer> userIds);

    int getCommentAndAnswerTotal(CommentListParam param);

    /* 文章阅读完、未阅读完 次数加1 */
    void updateArchivesReadStatusNum(@Param("id") int id, @Param("status") int status);

    /* 获取该设备最后一条未修改阅读状态的记录id */
    Integer getLastUnreadIdByCondition(@Param("cid") String cid, @Param("type") int type, @Param("archId") int archId);

    /* 设置阅读状态 */
    int updateClientReadLog(@Param("id") int id, @Param("param") ArchivesReadParam param);

    /* 文章是否收藏 1 ：是，0：否 */
    int isCollection(@Param("param") ArchivesUserParam param);

    /* 文章是否点赞  1 ：是，0：否 */
    int isPraise(@Param("param") ArchivesUserParam param);

    /* 添加举报记录 */
    int addComplain(@Param("param") ArchivesComplainParam param);

    /* 添加转发记录 */
    int addShare(@Param("param") ArchivesShareParam param);

    /* 同步 用户表 转发数量 */
    int syncUserShareCount(@Param("userId") int userId, @Param("totalShareCount") int totalShareCount);

    /* 同步 文章表  转发数量 */
    int syncArchiveShareCount(@Param("archId") int archId);

    /* 文章收藏表是否有该记录 李静 */
    int hasCollection(@Param("param") ArchivesCollectionParam param);

    /* 添加文章收藏 李静 */
    int addCollection(@Param("param") ArchivesCollectionParam param);

    /* 修改文章收藏状态 李静 */
    int updateCollection(@Param("param") ArchivesCollectionParam param);

    /* 同步用户表，收藏数量 李静 */
    void syncUserCollectionCount(@Param("userId") int userId);

    /* 同步文章表收藏数量 李静 */
    void syncArchiveCollectionCount(@Param("archId") int archId);

    /* 查询单条点赞记录 何飞达 */
    ArchivesPraiseResp getArchivesPraise(ArchivesPraiseParam param);

    /* 文章点赞 何飞达 */
    int addArchivesPraise(ArchivesPraiseParam param);


    /* 同步文章表收藏数量 何飞达 */
    void syncArchivePraiseCount(int archId);

    /* 取消文章点赞 何飞达 */
    int updateArchivesPraise(ArchivesPraiseParam param);

    /* 推荐文章 */
    List<ArchivesListResp> pushArchivesList(ArchivesPushParam param);

    /* 根据文章id 获取文章标签列表 -李静 */
    List<ArchivesTag> getArchivesTagsById(@Param("archId") int archId);

    /* 把此文章标签 更新到用户标签表里 -李静 */
    void saveUserTags(@Param("paramList") List<SaveUserTagsParam> paramList);

    /* 文章点击数+1 -李静 */
    void updateClickCount(ArchivesContentParam param);

    /* 增加客户端初始阅读记录 -李静 */
    //void addClientReadLog(@Param("param") ArchivesContentParam param);
    
    /* 评论文章后，评论数加一 */
    void updateArchivesComment(AnswerParam param);

    /**
     * 添加活动转发记录-陈晓婵-2018年1月6日11:10:24
     * @param param
     * @return
     */
    int addShareTopic(@Param("param") ArchivesShareParam param);

    /**
     * 根据用户id查询转发数量-陈晓婵-2018年1月6日13:24:18
     * @param userId
     * @return
     */
    int getRelayByUserId(int userId);

    /**
     *获取当天活动分享个数-陈晓婵-2018年1月6日17:03:05
     * @param userId
     * @return
     */
    int getTopicShareCount(int userId);

    /**
     * 获取当天文章分享个数-陈晓婵-2018年1月6日17:03:42
     * @param userId
     * @return
     */
    int getArchiShareCount(int userId);
    
    /* 文章评论 */
	Integer addComment(@Param("param") ArchivesCommentParam param);

    /* 更新文章评论数 */
    void syncCommentCount(@Param("archId") int archId);

    /* 更新用户评论数 */
    void syncUserCommentCount(@Param("userId") int userId);

    /**
     * 获取用户当天的评论文章的个数-陈晓婵-2018年1月8日15:56:28
     * @param userId
     * @return
     */
    int getArchivesCommentCount(int userId);
    
    /**
     * 获取用户当天的评论哔哔的个数-陈晓婵-2018年1月8日15:58:32
     * @param userId
     * @return
     */
    int getTopicCommentCount(int userId);
    
    /**
     * 判断今天是否回复别人的评论-陈晓婵-2018年1月8日19:35:24
     * @param userId
     * @return
     */
    int getCommentAnswer(int userId);

    /*查询collection list*/
    List<ArchivesCollection> queryCollectionList();

    /*通过文章id，查询collection list*/
    List<ArchivesCollection> queryCollectionListByIds(@Param("ids") List<Integer> ids);

    /*记录用户行为日志-入库*/
    void recordUserBehavior(List<UserBehavior> list);

    /* 查询tag list */
    List<Tag> queryTagList();

    /* 通过文章id，查询tag list */
    List<Tag> queryTagListByIds(@Param("ids") List<Integer> ids);
    
    /**
	 * 新增用户积分日志-陈晓婵-2018年1月17日21:14:27
	 * 
	 * @param param
	 * @return
	 */
	int insertIntegralLog(@Param("param") UserIntegralLogResp param);

	/* 更新用户阅读文章字段 */
    void updateArchivesRead(@Param("param") ArchivesContentParam param);

    Integer getArchiveIdByCommentId(Integer integer);

    Integer getArchiveIdByAnswerId(Integer integer);
}
