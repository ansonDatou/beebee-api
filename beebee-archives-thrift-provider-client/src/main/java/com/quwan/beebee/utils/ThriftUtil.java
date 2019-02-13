package com.quwan.beebee.utils;

import com.quwan.beebee.param.archives.*;
import com.quwan.beebee.service.archives.ArchivesService;
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
            ArchivesService.Client client = new ArchivesService.Client(protocol);
            tTransport.open();
            switch (method) {
                case "queryArchivesList" : return client.queryArchivesList((ArchivesListParam) param);
                case "getArchivesList" : return client.getArchivesList((ArchivesListParam) param);
                case "getArchivesContent" : return client.getArchivesContent((ArchivesContentParam) param);
                case "updateUserBehavior" : return client.updateUserBehavior((ArchivesContentParam) param);
                case "updateArchivesReadStatus" : return client.updateArchivesReadStatus((ArchivesReadParam) param);
                case "answerComment" : return client.answerComment((AnswerParam) param);
                case "getCommentList" : return client.getCommentList((CommentListParam) param);
                case "isCollection" : return client.isCollection((ArchivesUserParam) param);
                case "collect" : return client.collect((ArchivesCollectionParam) param);
                case "isPraise" : return client.isPraise((ArchivesUserParam) param);
                case "praise" : return client.praise((ArchivesPraiseParam) param);
                case "addComplain" : return client.addComplain((ArchivesComplainParam) param);
                case "addShare" : return client.addShare((ArchivesShareParam) param);
                case "addComment" : return client.addComment((ArchivesCommentParam) param);
                case "pushArchivesList" : return client.pushArchivesList((ArchivesPushParam) param);
                case "getArchivesSort" : return client.getArchivesSort();
            }
            tTransport.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return StringUtils.EMPTY;
    }
}
