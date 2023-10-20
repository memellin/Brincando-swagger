package enock.projeto.api;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;



@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	private Contact contato() {
		return new Contact("enock", "http://www.memelli.com.br", "enock@gmail.com.br");

	}

	private ApiInfoBuilder infoApi() {
		ApiInfoBuilder api = new ApiInfoBuilder();
		api.title("Rest Api");
		api.description("exemplo ");
		api.version("1.0");
		api.termsOfServiceUrl("termo de uso: open source");
		api.license("licença - memelli corporations");
		api.licenseUrl("http://www.memelli.com.br");
		api.contact(this.contato());

		return api;
	}
	
	@Bean
	public Docket detalheApi() {
		Docket docket = new Docket(DocumentationType.SWAGGER_2);
		docket.select()
		.apis(RequestHandlerSelectors.basePackage("enock.projeto.api.controller"))
		.paths(PathSelectors.any())
		.build()
		.apiInfo(this.infoApi().build())
		.consumes(new HashSet<>(Arrays.asList("application/json")))
		.produces(new HashSet<>(Arrays.asList("application/json")));
		
		return docket;
	}
	

}
