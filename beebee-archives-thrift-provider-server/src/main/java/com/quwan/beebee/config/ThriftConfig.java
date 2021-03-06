package com.quwan.beebee.config;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.annotation.PostConstruct;

import com.quwan.beebee.service.archives.ArchivesService;
import com.quwan.beebee.service.impl.ArchivesServiceImpl;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.apache.thrift.transport.TTransportException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ThriftConfig {

	@Autowired
	private ArchivesServiceImpl archivesServiceImpl;

	@Value("${thrift.server.port}")
	private int port;

	ExecutorService executor = Executors.newSingleThreadExecutor();

	@Bean
	public TServerTransport tServerTransport() {
		try {
			return new TServerSocket(port);
		} catch (TTransportException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Bean
	public TServer tServer() {
		ArchivesService.Processor processor = new ArchivesService.Processor(
				archivesServiceImpl);
		TServer server = new TThreadPoolServer(new TThreadPoolServer.Args(
				tServerTransport()).processor(processor));
		return server;
	}
	
	@PostConstruct
	public void init(){
		executor.execute(new Runnable() {
			@Override
			public void run() {
				tServer().serve();
			}
		});
	}

}
