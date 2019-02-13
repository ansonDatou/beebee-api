package com.quwan.beebee.utils;

import com.quwan.beebee.param.common.*;
import com.quwan.beebee.service.common.*;
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
            CommonService.Client client = new CommonService.Client(protocol);
            tTransport.open();
            switch (method) {
                case "getBanner" : return client.getBanner((GetBannerParam)param);
                case "uploadImg" : return client.uploadImg((UploadImgParam) param);
                case "getUploadToken" : return client.getUploadToken((UploadImgParam) param);
                case "getPreset" : return client.getPreset((Integer) param);
                case "getLastVersion" : return client.getLastVersion();
                case "addUserFeedBack" : return client.addUserFeedBack((UserFeedBackParam) param);
            }
            tTransport.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return StringUtils.EMPTY;
    }
}
