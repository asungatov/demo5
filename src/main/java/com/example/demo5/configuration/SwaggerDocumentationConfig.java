package com.example.demo5.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import java.util.Optional;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen",
    date = "2020-06-27T12:37:29.120+03:00")

@Configuration
public class SwaggerDocumentationConfig {

  ApiInfo apiInfo() {
    return new ApiInfoBuilder()
        .title("На промоигле")
        .description("Задача для Alfa Battle от X5 Retail Group")
        .license("")
        .licenseUrl("http://unlicense.org")
        .termsOfServiceUrl("https://x5.ru/")
        .version("1.0.0")
        .contact(new Contact("", "", ""))
        .build();
  }

  @Bean
  public Docket customImplementation() {
    return new Docket(DocumentationType.SWAGGER_2)
        .select()
        .apis(RequestHandlerSelectors.basePackage("io.swagger.api"))
        .build()
        .directModelSubstitute(java.time.LocalDate.class, java.sql.Date.class)
        .directModelSubstitute(java.time.OffsetDateTime.class, java.util.Date.class)
        .genericModelSubstitutes(Optional.class)
        .apiInfo(apiInfo());
  }

}
