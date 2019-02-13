package com.quwan.beebee.utils;

import com.quwan.beebee.param.user.*;
import com.quwan.beebee.service.user.UserService;
import org.apache.commons.lang3.StringUtils;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ThriftUtil {

    @Value("${thrift.server.host}")
    private String host;

    @Value("${thrift.server.port}")
    private int port;

    /**
     * 调用thrift接口
     * @param param
     * @param method
     * @return
     */
    public <P> String remoteInvoke(String method, P param) {
        try {
            TTransport tTransport = new TSocket(host, port);
            TProtocol protocol = new TBinaryProtocol(tTransport);
            UserService.Client client = new UserService.Client(protocol);
            tTransport.open();
            switch (method) {
                case "register" : return client.registering((RegisterParam) param);
                case "login" : return client.login((LoginParam) param);
                case "getDetail" : return client.getDetail((Integer) param);
                case "getReadedList" : return client.getReadedList((HistoryArchivesParam) param);
                case "modifyPwd" : return client.modifyPwd((ModifyPwdParam) param);
                case "update" : return client.update((UpdateUserParam) param);
                case "retrievePwd" : return client.retrievePwd((RetrievePwdParam) param);
                case "signed" : return client.signed((Integer) param);
                case "getIntegralList" : return client.getIntegralList((IntegralListParam) param);
                case "updateHead": return client.updateHead((UpdateHeadParam) param);
                case "setwitch": return client.setwitch((SetwitchParam) param);
                case "getCollectionList": return client.getCollectionList((CollectionParam) param);
                case "getGoodsList": return client.getGoodsList((GoodsListParam) param);
                case "getGoodsDetail": return client.getGoodsDetail((Integer) param);
                case "getOrderList": return client.getOrderList((OrderListParam) param);
                case "getOrderDetail": return client.getOrderDetail((Integer) param);
                case "getNotificationList": return client.getNotificationList((NotificationParam) param);
                case "getMineCommentList": return client.getMineCommentList((NotificationParam) param);
                case "exchange": return client.exchange((ExchangeParam) param);
                case "getTaskList": return client.getTaskList((GetTaskListParam)param);
                case "checkRedPacket": return client.checkRedPacket((RedPacketParam)param);
                case "getUserPersonalPage": return client.getUserPersonalPage((UserPersonalPageParam)param);
                case "getUserDynamic": return client.getUserDynamic((UserDynamicParam)param);
                case "hideUserIdentitys": return client.hideUserIdentitys((HideUserIdentitysParam)param);
                case "getCommentsByUserIdentity": return client.getCommentsByUserIdentity((GetCommentsByUserIdentityParam)param);
                case "addBlacklist": return client.addBlacklist((BlacklistParam)param);
                case "removeBlackList": return client.removeBlackList((BlacklistParam) param);
                case "getBlackList": return client.getBlackList((NotificationParam) param);
            }
            tTransport.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return StringUtils.EMPTY;
    }
}
