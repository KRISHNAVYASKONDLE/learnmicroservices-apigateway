package com.krishnavyas.microservices.apigateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {

	public ApiGatewayConfiguration() {
		// TODO Auto-generated constructor stub
	}
	

//http://localhost:8765/currency-exchange/from/USD/to/INR
//http://localhost:8765/currency-conversion/from/USD/to/INR/quantity/10
//http://localhost:8765/currency-conversion-feign/from/USD/to/INR/quantity/10
//http://localhost:8765/currency-conversion-new/from/USD/to/INR/quantity/10
			
	@Bean
	public RouteLocator getewayRouter(RouteLocatorBuilder builder)
	{
		return builder.routes().route(p->p.path("/get").filters(
				f->f.addRequestHeader("MyHeader","MyUri")
				.addRequestParameter("param", "myvalue")).uri("http://httpbin.org:80"))
				.route(p->p.path("/currency-exchange/**").uri("lb://currency-exchange-service"))
				.route(p->p.path("/currency-conversion/**").uri("lb://currency-conversion-service"))
				.route(p->p.path("/currency-conversion-feign/**").uri("lb://currency-conversion-service"))
				.route(p->p.path("/currency-conversion-new/**")
				.filters(f->f.rewritePath(
						"/currency-conversion-new/(?<segment>.*)",
						"/currency-conversion-feign/${segment}")).uri("lb://currency-conversion-service"))
				.build();		
	}
}
