package edu.ifma.lpweb.rest.imobiliaria.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("edu.ifma.lpweb.rest.imobiliaria"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo("API REST para um fragmento de um sistema de imobiliária",
                "Esta API apresenta vários recursos, como busca paginada, consultas com filtro via request params, " +
                        "cadastro, atualização e remoção de recursos",
                "v1.0.0", "Termos de Serviço", new Contact("Autor", "https://github.com/autor", "autor@email.com"),
                "Licença da API", "Licença URL", Collections.emptyList());
    }
}
