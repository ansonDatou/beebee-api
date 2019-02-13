package com.quwan.beebee.utils;

import com.quwan.beebee.param.common.*;
import com.quwan.beebee.param.third.AuthcodeParam;
import com.quwan.beebee.param.third.CheckImageParam;
import com.quwan.beebee.param.third.CheckTextParam;
import com.quwan.beebee.param.third.SendMsgParam;
import com.quwan.beebee.service.common.*;
import com.quwan.beebee.service.third.ThirdService;
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
            ThirdService.Client client = new ThirdService.Client(protocol);
            tTransport.open();
            switch (method) {
                case "sendAuthcode" : return client.sendAuthcode((AuthcodeParam) param);
                case "checkText" : return client.checkText((CheckTextParam) param);
                case "checkImage" : return client.checkImage((CheckImageParam) param);
                case "sendMsg" : return client.sendMsg((SendMsgParam) param);
            }
            tTransport.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return StringUtils.EMPTY;
    }
}
