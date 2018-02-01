package edu.zzu.rbw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringCloudCliApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudCliApplication.class, args);
	}
}
