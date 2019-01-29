package site.clzblog.application.wechat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import com.spring4all.swagger.EnableSwagger2Doc;

@EnableEurekaClient
@EnableSwagger2Doc
@SpringBootApplication
public class ApplicationWechat {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationWechat.class, args);
	}

}
