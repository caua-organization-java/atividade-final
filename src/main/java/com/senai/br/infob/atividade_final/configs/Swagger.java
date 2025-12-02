package com.senai.br.infob.atividade_final.configs;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@Configuration
@OpenAPIDefinition(
    info = @Info(
        title = "Atividade final",
        version = "1.0",
        description = "Cauã França"
    )
)
public class Swagger {

}