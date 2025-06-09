package com.claudsaints.api_boleto.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI customOpenApi(){
        return new OpenAPI().info(new Info()
                .title("Api boleto")
                .description("Api de bagamento de boletos")
                .contact(new Contact().name("Claudio Siqueira").email("claudio@gmail.com"))
                .version("1.0.0")
        );

    }
}
