namespace java com.quwan.beebee.service.archives

include "ArchivesEntity.thrift"
include "ArchivesParam.thrift"

service ArchivesService {

    // 获取文章分类接口
    string getArchivesSort();

    // getList 接口
    string queryArchivesList(1: required ArchivesParam.ArchivesListParam param);

    // getList 接口 score 排序
    string getArchivesList(1: required ArchivesParam.ArchivesListParam param);

    // 文章详情页
    string getArchivesContent(1: required ArchivesParam.ArchivesContentParam param);

    // 用户读取详情后，记录用户行为等
    string updateUserBehavior(1: required ArchivesParam.ArchivesContentParam param);
    
    // 文章阅读完成、未完成
    string updateArchivesReadStatus(1: required ArchivesParam.ArchivesReadParam param);
    
    // 文章是否收藏
    string isCollection(1: required ArchivesParam.ArchivesUserParam param);
    
    // 文章收藏、取消收藏
    string collect(1: required ArchivesParam.ArchivesCollectionParam param);
    
    // 文章是否点赞
    string isPraise(1: required ArchivesParam.ArchivesUserParam param);
    
    // 文章点赞、取消点赞
    string praise(1: required ArchivesParam.ArchivesPraiseParam param);

    // 回复评论接口
    string answerComment(1: required ArchivesParam.AnswerParam param);

    // 查询文章的评论
    string getCommentList(1: required ArchivesParam.CommentListParam param);
    
    // 举报文章
    string addComplain(1: required ArchivesParam.ArchivesComplainParam param);
    
    // 转发文章
    string addShare(1: required ArchivesParam.ArchivesShareParam param);

    // 推荐文章
    string pushArchivesList(1: required ArchivesParam.ArchivesPushParam param);

    // 文章评论
    string addComment(1: required ArchivesParam.ArchivesCommentParam param);
}