package site.clzblog.application.gateway;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.ctrip.framework.apollo.spring.annotation.ApolloConfig;
import com.alibaba.fastjson.JSONArray;
import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import com.spring4all.swagger.EnableSwagger2Doc;

import site.clzblog.application.zuul.entity.SwaggerDoc;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

@EnableSwagger2Doc
@EnableZuulProxy
@EnableEurekaClient
@EnableApolloConfig
@SpringBootApplication
public class ApplicationZuul {
	@ApolloConfig
	Config config;

	@Value("${clzblog.zuul.swagger.document.config.json}")
	private String docJsons;

	public static void main(String[] args) {
		SpringApplication.run(ApplicationZuul.class, args);
	}

	@Primary
	@Component
	class DocumentationConfig implements SwaggerResourcesProvider {

		@Override
		public List<SwaggerResource> get() {
			config.addChangeListener(listener -> get());
			return resources();
		}

		private List<SwaggerResource> resources() {
			List<SwaggerResource> resources = new ArrayList<>();
			List<SwaggerDoc> list = JSONArray.parseArray(docJsons, SwaggerDoc.class);
			list.forEach(doc -> resources.add(swaggerResource(doc.getName(), doc.getLocation(), doc.getVersion())));
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
