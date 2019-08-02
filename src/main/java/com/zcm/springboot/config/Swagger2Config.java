package com.zcm.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @ClassName ZCM
 * @Author WXL
 * @Date 2019/8/2 9:30
 * @Description TODO
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {
    @Bean
    public Docket createRestApi(){

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.zcm.springboot.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo(){

        return new ApiInfoBuilder().title("mybaisplus")
                .description("mybatisplus的swaggerDemo")
                .contact(new Contact("zcm","",""))
                .version("1.0")
                .build();
    }
}
