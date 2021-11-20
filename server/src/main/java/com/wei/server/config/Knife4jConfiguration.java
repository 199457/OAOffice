package com.wei.server.config;

import com.github.xiaoymin.knife4j.spring.extension.OpenApiExtensionResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@EnableOpenApi
@Configuration
public class Knife4jConfiguration {

    private final OpenApiExtensionResolver openApiExtensionResolver;

    public Knife4jConfiguration(OpenApiExtensionResolver openApiExtensionResolver) {
        this.openApiExtensionResolver = openApiExtensionResolver;
    }

    @Bean
    public Docket defaultApi3() {
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(new ApiInfoBuilder()
                        .title("【云易办】")
                        .license("123456")
                        .description("# 云易办 APIS")
                        .termsOfServiceUrl("https://terms.345.zone")
                        .contact(new Contact("ChenZhen", "https://345.zone", "everan@aliyun.com"))
                        .version("1.0")
                        .build())
                .groupName("3.x版本")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.wei.server.controller"))
                .paths(PathSelectors.any())
                .build()
                .extensions(openApiExtensionResolver.buildSettingExtensions());
    }

}
