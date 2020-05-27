package net.web.app.senior;

import java.util.Collections;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage("net.web.app.senior"))
                .build().apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo("Ordering Food Online REST API", "This is the back end Ordering Food Online APIs provied by spring boot ", "API TOS",
                "Terms of service", new Contact("Ahmed Baz", "www.facebook.com/SourceCode1024", "ahmedbaz1024@gmail.com"),
                "License of API", "API license URL", Collections.emptyList());
    }

}
