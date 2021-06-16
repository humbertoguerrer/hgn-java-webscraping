package com.hgn.hgnjavawebscraping.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;

@Configuration
public class SwaggerConfig {

    @Bean
    public Docket swagger() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(metaInfo());
    }

    private ApiInfo metaInfo() {
        ApiInfo apiInfo = new ApiInfo("Java web scraping for Knewin", "API for register and search news from " +
                "InfoMoney portal through web scraping.", "0.1",
                "Terms of Service",
                new Contact("Humberto Guerrer Neto", "https://github.com/humbertoguerrer", "humberto.guerrer@gmail.com"),
                "Apache License Version 2.0", "https://www.apache.org/licesen.html", new ArrayList<VendorExtension>());

        return apiInfo;
    }

}