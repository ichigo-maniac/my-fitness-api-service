package com.my.fitness.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

/**
 * Swagger configuration
 */
@Configuration
@EnableSwagger2
@Profile("!test")
public class SwaggerConfiguration {

    /**
     * Docket bean
     * @return Docket bean
     */
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(new ApiInfo(
                        "My fintess application service",
                        "My fintess application service - REST API",
                        "1.0",
                        null,
                        null,
                        null,
                        null,
                        Collections.emptyList()
                ))
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.ant("/api/**"))
                .build();
    }

}
