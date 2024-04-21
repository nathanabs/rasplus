package com.client.api.rasplus.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Rest API Rasplus")
                        .description("API para a integração Rasmoo Plus")
                        .version("1.0")
                        .termsOfService("Termo de uso: Open Source")
                );
    }
}
