package com.example.Parcial.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {

    @Bean
    public OpenAPI custoOpenApi(){
        return new OpenAPI()
                .info(new Info()
                        .title("API de partidos")
                        .version("1.0")
                        .description("Documentacion Api gestion de partidos")
                        .contact(new Contact()
                                .name("Cristian Cano")
                                .email("canox09@gmail.com")
                        )
                );
    }
}
