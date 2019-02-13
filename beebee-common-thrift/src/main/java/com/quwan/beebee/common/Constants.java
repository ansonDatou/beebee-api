package com.quwan.beebee.common;



/**
 * 公共常量
 */
public interface Constants {

    /** 判断代码：是 */
    String TRUE = "1";

    /** 判断代码：否 */
    String FALSE = "0";

    /** 通用字符集编码 */
    String CHARSET_UTF8 = "UTF-8";

    /** 中文字符集编码 */
    String CHARSET_CHINESE = "GBK";

    /** 英文字符集编码 */
    String CHARSET_LATIN = "ISO-8859-1";

    /** 根节点ID */
    String ROOT_ID = "root";

    /** NULL字符串 */
    String NULL = "null";

    /** 日期格式 */
    String FORMAT_DATE = "yyyy-MM-dd";

    /** 日期时间格式 */
    String FORMAT_DATETIME = "yyyy-MM-dd HH:mm:ss";

    /** 时间戳格式 */
    String FORMAT_TIMESTAMP = "yyyy-MM-dd HH:mm:ss.SSS";

    /** JSON成功标记 */
    String JSON_SUCCESS = "success";

    /** JSON数据 */
    String JSON_DATA = "data";

    /** JSON数据列表 */
    String JSON_ROWS = "rows";

    /** JSON总数 */
    String JSON_TOTAL = "total";

    /** JSON消息文本 */
    String JSON_MESSAGE = "message";

    String TAG_SYS = "sys";

    String TAG_MST = "mst";

    String TAG_MQ = "mq";

    String TAG_DAT = "dat";

    String TAG_STA = "sta";

    String TAG_INT = "int";

    String[] TAGS = {TAG_SYS, TAG_MST, TAG_MQ, TAG_DAT, TAG_STA, TAG_INT};

    /** Cookie键值：验证键值 */
    String COOKIE_VALIDATE_KEY = "VALIDATE_KEY";

    /** Cookie键值：验证键值分割符 */
    String COOKIE_VALIDATE_KEY_SPLIT = "$_";

    /** 请求属性键值：当前项目标识 */
    String REQ_CUR_TAG = "REQ_CUR_TAG";

    /** 请求属性键值：当前用户标识 */
    String REQ_CUR_USER_ID = "CUR_USER_ID";

    /** 请求属性键值：当前用户名称 */
    String REQ_CUR_USER_NAME = "CUR_USER_NAME";

    /** 请求属性键值：当前机构标识 */
    String REQ_CUR_ORG_ID = "CUR_ORG_ID";

    /** 请求属性键值：当前角色名称 */
    String REQ_CUR_ROLE_CODE = "CUR_ROLE_CODE";

    /**用户登录存入session */
    String SESSION_USER = "USER";

    /** 产品密钥ID，产品标识*/
    String SECRETID = "8af681ff5c95c58d6d154b4e4e62c401";

    /** 产品私钥，服务端生成签名信息使用，请严格保管，避免泄露*/
    String SECRETKEY = "e4361f801c1e21615434e3187b28caa5";

    /** 图片业务ID，易盾根据产品业务特点分配*/
    String IMAGEBUSINESSID = "c45375a8eed1f4a641f9fcb2984f2c7d";

    /** 易盾反垃圾云服务图片在线检测接口地址*/
   String IMAGEAPI_URL = "https://api.aq.163.com/v3/image/check";

    /** 文本业务ID，易盾根据产品业务特点分配*/
    String TEXTBUSINESSID = "c588f7c84bbc4a3af65f6d9f1efc0c5e";

    /** 易盾反垃圾云服务文本在线检测接口地址*/
     String TEXTAPI_URL = "https://api.aq.163.com/v3/text/check";

    /** 用户平台API账号(非登录账号,示例:N1234567)*/
    String account = "N2483522";

    /** 用户平台API密码(非登录密码)*/
    String pswd = "uvA3FS12c";

    /** 请求地址请登录253云通讯自助通平台查看或者询问您的商务负责人获取*/
    String smsSingleRequestServerUrl = "http://smssh1.253.com/msg/send/json";

    /** 模块所在服务器ip地址 */
    String serverIpAddress = "172.17.2.174";

}
