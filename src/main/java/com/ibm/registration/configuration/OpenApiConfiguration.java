package com.ibm.registration.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@ConfigurationProperties
public class OpenApiConfiguration {
    @Value("${app.title}")
    String title;
    @Value("${app.description}")
    String description;
    @Value("${app.version}")
    String version;


    @Bean
    public OpenAPI openAPIConfig() {
        return new OpenAPI()
                .info(new Info().title(title)
                        .description(description)
                        .version(version));

    }
}