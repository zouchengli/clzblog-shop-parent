package site.clzblog.application.member;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import com.spring4all.swagger.EnableSwagger2Doc;

@EnableFeignClients
@EnableEurekaClient
@EnableSwagger2Doc
@SpringBootApplication
public class ApplicationMember {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationMember.class, args);
	}

}
