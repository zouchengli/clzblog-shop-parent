package site.clzblog.application.gateway;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.spring4all.swagger.EnableSwagger2Doc;

import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

@EnableSwagger2Doc
@EnableZuulProxy
@EnableEurekaClient
@SpringBootApplication
public class ApplicationZuul {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationZuul.class, args);
	}

	@Primary
	@Component
	class DocumentationConfig implements SwaggerResourcesProvider {

		@Override
		public List<SwaggerResource> get() {
			List<SwaggerResource> resources = new ArrayList<>();
			resources.add(swaggerResource("app-clzblog-member", "/app-clzblog-member/v2/api-docs", "2.0"));
			resources.add(swaggerResource("app-clzblog-wechat", "/app-clzblog-wechat/v2/api-docs", "2.0"));
			return resources;
		}

		private SwaggerResource swaggerResource(String name, String location, String version) {
			SwaggerResource swaggerResource = new SwaggerResource();
			swaggerResource.setName(name);
			swaggerResource.setLocation(location);
			swaggerResource.setSwaggerVersion(version);
			return swaggerResource;
		}
	}
}
