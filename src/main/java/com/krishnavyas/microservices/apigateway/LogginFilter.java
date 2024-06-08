package com.krishnavyas.microservices.apigateway;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

@Component
public class LogginFilter implements GlobalFilter{

	private Logger logger=LoggerFactory.getLogger(LogginFilter.class);
	
	public LogginFilter() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		// TODO Auto-generated method stub
	
		logger.info("path of request recieved -> {}", exchange.getRequest().getPath() );
		return chain.filter(exchange);
	}

}
