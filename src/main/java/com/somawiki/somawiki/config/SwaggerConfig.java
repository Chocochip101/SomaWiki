package com.somawiki.somawiki.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

  @Value("${swagger-docs.url}")
  private String url;

  @Bean
  public OpenAPI api() {
    Info info = new Info()
      .title("Soma-Wiki")
      .version("V1.0")
      .license(new License()
        .name("Apache License Version 2.0")
        .url("http://www.apache.org/license/LICENSE-2.0"));

    SecurityScheme auth = new SecurityScheme()
      .type(SecurityScheme.Type.APIKEY).in(SecurityScheme.In.COOKIE).name("JSESSIONID");
    SecurityRequirement securityRequirement = new SecurityRequirement().addList("basicAuth");

    return new OpenAPI()
      .components(new Components().addSecuritySchemes("basicAuth", auth))
      .addServersItem(new Server().url(url))
      .addSecurityItem(securityRequirement)
      .info(info);
  }
}
