package com.tenniscourts.config.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;


@Configuration
public class SwaggerConfig {

    private static final String APIS_BASE_PACKAGE = "com.tenniscourts";
    private static final String TITLE = "Tennis Courts - Challenge";
    private static final String DESCRIPTION = "TENNIS-COURTS";

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title(TITLE).description(DESCRIPTION).version("1.0.0").build();
    }

    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage(APIS_BASE_PACKAGE))
                .paths(PathSelectors.any())
                .build();
    }
}
