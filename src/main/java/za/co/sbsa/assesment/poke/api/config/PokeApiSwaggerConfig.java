package za.co.sbsa.assesment.poke.api.config;

import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class PokeApiSwaggerConfig {
    public Docket pokeApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select().apis(RequestHandlerSelectors.basePackage("za.co.sbsa.assesment.poke.api.rest"))
                .paths(PathSelectors.regex("/api.*"))
                .build().apiInfo(pokeApiInfo());
    }

    private ApiInfo pokeApiInfo() {
        return new ApiInfoBuilder().title("Poke`API Spring Boot REST")
                .description("Poke`API Rest API")
                .contact(new Contact("Nare Francis Molokomme", "https://www.molokomme.co.za", "francis@molokomme.co.za"))
                .license("MIT")
                .licenseUrl("https://opensource.org/licenses/MIT")
                .version("0.0.1")
                .build();
    }
}
