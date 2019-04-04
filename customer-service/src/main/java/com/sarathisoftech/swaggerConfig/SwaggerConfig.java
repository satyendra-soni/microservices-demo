package com.sarathisoftech.swaggerConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;


import static springfox.documentation.builders.PathSelectors.any;
import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
public class SwaggerConfig {
    /* @Bean
   public Docket customerApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.sarathisoftech.controllers.CustomerServiceResource.class"))
                .paths(regex("/rest.*"))
                .build();

    }*/
    @Bean
    public Docket postsApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.sarathisoftech.controllers"))
                .paths(PathSelectors.ant("/api/*"))
                .build();

    }



    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("customer-service API")
                .description("customer-service API reference for developers")
                .contact(new Contact("sarathisoftech","https://sarathisoftech.com/","info@sarathisoftech.com"))
                .version("1.0").build();
    }


}
