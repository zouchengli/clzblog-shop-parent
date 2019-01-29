package site.clzblog.application.wechat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ApplicationWechat {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationWechat.class, args);
	}

}
