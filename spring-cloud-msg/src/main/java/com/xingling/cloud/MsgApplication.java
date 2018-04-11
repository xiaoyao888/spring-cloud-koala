package com.xingling.cloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan("com.xingling.cloud.mapper")
@EnableDiscoveryClient
@EnableFeignClients
public class MsgApplication {

	/**
	 * 实例化RestTemplate，通过@LoadBalanced注解开启均衡负载能力.
	 *
	 * @return restTemplate rest template
	 */
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	public static void main(String[] args) {
    SpringApplication.run(MsgApplication.class, args);
  }
}
