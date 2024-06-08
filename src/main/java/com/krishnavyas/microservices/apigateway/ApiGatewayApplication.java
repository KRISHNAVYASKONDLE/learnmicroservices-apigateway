package com.krishnavyas.microservices.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
		
//		http://localhost:8100/currency-conversion/from/USD/to/INR/quantity/17.5
//		http://localhost:8765/currency-conversion-service/currency-conversion/from/USD/to/INR/quantity/17.5
//		http://localhost:8765/currency-conversion-service/currency-conversion-feign/from/USD/to/INR/quantity/17.5
//      http://localhost:8000/currency-exchange/from/USD/to/INR
//      http://localhost:8765/currency-exchange-service/currency-exchange/from/USD/to/INR
		
		
	}

}
