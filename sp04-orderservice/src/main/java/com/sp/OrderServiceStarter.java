package com.sp;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

//@EnableDiscoveryClient
//@SpringBootApplication

@EnableFeignClients
@SpringCloudApplication
public class OrderServiceStarter {
	public static void main(String[] args) {
		SpringApplication.run(OrderServiceStarter.class, args);
	}
}
