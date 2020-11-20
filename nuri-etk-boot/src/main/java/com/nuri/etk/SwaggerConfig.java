package com.nuri.etk;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    private String version;
    private String title;

    @Bean
    public Docket api() {
        version = "v2.0";
        title = "E-Ticket (E-Vending ↔ HES) API " + version;
        
        List<ResponseMessage> responseMessages = new ArrayList<>();
        responseMessages.add(new ResponseMessageBuilder()
                .code(200)
                .message("OK")
                .build());
        responseMessages.add(new ResponseMessageBuilder()
                .code(404)
                .message("Not Found")
                .build());
        responseMessages.add(new ResponseMessageBuilder()
                .code(500)
                .message("Internal Server Error")
                .build());


        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .paths(Predicates.not(PathSelectors.regex("/error.*")))     // Exclude Spring error controllers
                .build()
                .apiInfo(apiInfo(title, version))                                   // Swagger API Info 설정
                .globalResponseMessage(RequestMethod.GET, responseMessages);        // response를 글로벌 메시지로 설정
    }

    private ApiInfo apiInfo(String title, String version) {
        return new ApiInfo(
                title,
                "E-Token API Docs",
                version,
                "http://www.nuritelecom.co.kr/",
                new Contact("Contact", "http://www.nuritelecom.co.kr/", "jhdang@nuritelecom.com"),
                "Licenses",
                "http://www.nuritelecom.co.kr/",

                new ArrayList<>());
    }
}
