package edu.projeto_design_patterns.config;


import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Rest API")
                        .description("Projeto feito para o desafio da aula  Design Patterns com Java: Dos Clássicos (GoF) ao Spring Framework")
                        .version("1.0")
                        .termsOfService("Termo de uso: Open Source")
                        .license(new License()));
    }

}
