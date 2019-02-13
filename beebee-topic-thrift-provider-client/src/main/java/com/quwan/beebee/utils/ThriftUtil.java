package com.quwan.beebee.utils;

import com.quwan.beebee.param.topic.*;
import com.quwan.beebee.service.topic.TopicService;
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
	 * 
	 * @param param
	 * @param method
	 * @return
	 */
	public <P> String remoteInvoke(String method, P param) {
		try {
			TTransport tTransport = new TSocket(host, port);
			TProtocol protocol = new TBinaryProtocol(tTransport);
			TopicService.Client client = new TopicService.Client(protocol);
			tTransport.open();
			switch (method) {
				case "getList" : return client.getList((TopicListParam) param);
				case "addComment" : return client.addComment((TopicCommentParam) param);
				case "getCommentList" : return client.getCommentList((TopicCommentListParam) param);
            	case "getCommentReplyList" : return client.getCommentReplyList((TopicCommentReplyListParam)param);
            	case "addCommentReply" : return client.addCommentReply((TopicCommentReplyParam)param);
				case "addVote" : return client.addVote((TopicVoteParam)param);
			 	case "getDetail" : return client.getDetail((TopicDetailParam) param);
			 	case "getBarrageList" : return client.getBarrageList((TopicBarrageListParam) param);
				case "updateCommentPraiseStatus" : return client.updateCommentPraiseStatus((TopicCommentPraiseParam) param);
				case "addTopic" : return client.addTopic((TopicParam) param);
				case "getHotRecommend" : return client.getHotRecommend((Integer) param);
				case "getCommentReplyThreeList" : return client.getCommentReplyThreeList((Integer) param);
				case "getCommentReplyUser" : return client.getCommentReplyUser((TopicCommentReplyUserParam) param);
				case "addTopicReport" : return client.addTopicReport((TopicReportParam) param);
			}
			tTransport.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return StringUtils.EMPTY;
	}
}
