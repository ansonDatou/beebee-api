package com.quwan.beebee.common;

import com.quwan.beebee.entity.topic.Topic;
import com.quwan.beebee.param.user.*;
import org.springframework.boot.Banner;

/**
 * 方法名称常量
 */
public interface Method {

    /* user模块，registerUser */
    String USER_REGISTER = "/user/register";

    /* user模块，login */
    String USER_LOGIN = "/user/login";

    /* user模块，modifyPwd */
    String USER_MODIFY_PWD = "/user/modifyPwd";

    /* user模块，logout */
    String USER_LOGOUT = "/user/logout";

    /* user模块，getDetail */
    String USER_GET_DETAIL = "/user/getDetail";

    /* user模块，getReadedList */
    String USER_GET_READED_LIST = "/user/getReadedList";

    /* user模块，update */
    String USER_UPDATE = "/user/update";

    /* user模块，忘记密码 */
    String USER_RETRIEVE_PWD = "/user/retrievePwd";

    /* user模块，签到 */
    String USER_SIGNED = "/user/signed";

    /* user模块，获取积分列表 */
    String USER_GET_INTEGRAL_LIST = "/user/getIntegralList";

    /* user模块，修改头像 */
    String USER_UPDATE_HEAD = "/user/updateHead";

    /* user模块， */
    String USER_SET_WITCH = "/user/setwitch";

    /* user模块，我的收藏 */
    String USER_GET_COLLECTION_LIST = "/user/getCollectionList";

    /* user模块，商品列表 */
    String USER_GET_GOODS_LIST = "/user/getGoodsList";

    /* user模块，商品详情 */
    String USER_GET_GOODS_DETAIL = "/user/getGoodsDetail";

    /* user模块，获取订单列表 */
    String USER_GET_ORDER_LIST = "/user/getOrderList";

    /* user模块，获取订单详情 */
    String USER_GET_ORDER_DETAIL = "/user/getOrderDetail";

    /* user模块，获取我的系统消息 */
    String USER_GET_NOTIFICATION_LIST = "/user/getNotificationList";

    /* user模块，我的评论 */
    String USER_GET_MINE_COMMENT_LIST = "/user/getMineCommentList";

    /* user模块， 兑换商品*/
    String USER_EXCHANGE = "/user/exchange";

    /* user模块， getTaskList*/
    String USER_GET_TASK_LIST = "/user/getTaskList";

    /* user模块， getUserPersonalPage*/
    String USER_GET_USER_PERSONAL_PAGE = "/user/getUserPersonalPage";

    /* user模块， hideUserIdentitys*/
    String USER_HIDE_USER_IDENTITYS = "/user/hideUserIdentitys";

    /* user模块， getCommentsByUserIdentity*/
    String USER_GET_COMMENTS_BY_USER_IDENTITY = "/user/getCommentsByUserIdentity";

    /* user模块， getUserDynamic*/
    String USER_GET_USER_DYNAMIC = "/user/getUserDynamic";

    /* user模块， addBlacklist*/
    String USER_ADD_BLACKLIST = "/user/addBlacklist";

    /* user模块， removeBlackList */
    String USER_REMOVE_BLACKLIST = "/user/removeBlackList";

    /* user模块， getBlackList */
    String USER_GET_BLACKLIST = "/user/getBlackList";

    /* common模块，getBanner */
    String COMMON_GET_BANNER = "/common/getBanner";

    /* common模块，uploadImg */
    String COMMON_UPLOAD_IMG = "/common/uploadImg";

    /* common模块，getUploadToken */
    String COMMON_GET_UPLOAD_TOKEN = "/common/getUploadToken";

    /* common模块，getPreset */
    String COMMON_GET_PRESET = "/common/getPreset";

    /* common模块，getLastVersion */
    String COMMON_LAST_VERSION = "/common/getLastVersion";

    /* common模块，addUserFeedBack */
    String COMMON_FEED_BACK = "/common/addUserFeedBack";

    /* third，sendAuthcode */
    String THIRD_SEND_AUTHCODE = "/third/sendAuthcode";

    /* third，sendMsg */
    String THIRD_SEND_MSG = "/third/sendMsg";

    /* third，checkText */
    String THIRD_CHECK_TEXT = "/third/checkText";

    /* third，checkImage */
    String THIRD_CHECK_IMAGE = "/third/checkImage";




    /* archives模块，getArchivesSort */
    String ARCHIVES_GET_ARCHIVES_SORT = "/archives/getArchivesSort";

    /* archives模块，getList */
    String ARCHIVES_GET_LIST = "/archives/getList";

    /* archives模块，getArchivesContent */
    String ARCHIVES_GET_ARCHIVES_CONTENT = "/archives/getArchivesContent";

    /* archives模块， answerComment */
    String ARCHIVES_ANSWER_COMMENT = "/archives/answerComment";

    /* archives模块，getCommentList */
    String ARCHIVES_GET_COMMENT_LIST = "/archives/getCommentList";

    /* archives模块，updateArchivesReadStaus */
    String ARCHIVES_UPDATE_ARCHIVES_READ_STATUS = "/archives/updateArchivesReadStatus";

    /* archives模块，isCollection */
    String ARCHIVES_IS_COLLECTION = "/archives/isCollection";

    /* archives模块，isPraise */
    String ARCHIVES_IS_PRAISE = "/archives/isPraise";

    /* archives模块，addComplain */
    String ARCHIVES_ADD_COMPLAIN = "/archives/addComplain";

    /* archives模块，addShare */
    String ARCHIVES_ADD_SHARE = "/archives/addShare";

    /* archives模块，collect */
    String ARCHIVES_COLLECT = "/archives/collect";

    /* archives模块，praise */
    String ARCHIVES_PRAISE = "/archives/praise";

    /* archives模块，addComment */
    String ARCHIVES_ADD_COMMENT = "/archives/addComment";

    /* archives模块，pushArchivesList */
    String ARCHIVES_PUSH_ARCHIVES_LIST = "/archives/pushArchivesList";



    /* Topic，getList */
    String TOPIC_GET_LIST = "/topic/getList";

    /* Topic，addComment */
    String TOPIC_ADD_COMMENT = "/topic/addComment";

    /* Topic，getCommentList */
    String TOPIC_GET_COMMENTLIST = "/topic/getCommentList";

    /* Topic，getCommentReplyList */
    String TOPIC_GET_COMMENT_REPLY_LIST = "/topic/getCommentReplyList";

    /* Topic，addCommentReply */
    String TOPIC_ADD_COMMENT_REPLY = "/topic/addCommentReply";

    /* Topic，getDetail */
    String TOPIC_GET_DETAIL = "/topic/getDetail";

    /* Topic，getBarrageList */
    String TOPIC_GET_BARRAGE_LIST = "/topic/getBarrageList";

    /* Topic，addVote */
    String TOPIC_ADD_VOTE = "/topic/addVote";

    /* Topic，updateCommentPraiseStatus */
    String TOPIC_UPDATE_COMMENT_PRAISE_STATUS = "/topic/updateCommentPraiseStatus";

    /* Topic，addTopic */
    String TOPIC_ADD_TOPIC = "/topic/addTopic";

    /* Topic，getHotRecommend */
    String TOPIC_GET_HOT_RECOMMEND = "/topic/getHotRecommend";

    /* Topic，addTopicReport */
    String TOPIC_ADD_REPORT = "/topic/addTopicReport";

    /* topic, getCommentReplyThreeList */
    String TOPIC_GET_COMMENT_REPLY_THREE_LIST = "/topic/getCommentReplyThreeList";

    /* topic, getCommentReplyUser */
    String TOPIC_GET_COMMENT_REPLY_USER = "/topic/getCommentReplyUser";
}
