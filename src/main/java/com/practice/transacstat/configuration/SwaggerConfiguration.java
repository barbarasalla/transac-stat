package com.practice.transacstat.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {

    @Bean
    public OpenAPI customApiTransactstaticOpenAI(){
        return new OpenAPI()
                .info(new Info()
                        .title("API Transactions Static")
                        .description("API for producer transactions static")
                        .contact(new Contact().name("Barbara Salla")).version("1.0.0")
                );
    }
}
