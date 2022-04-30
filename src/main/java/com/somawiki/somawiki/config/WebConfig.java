package com.somawiki.somawiki.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@RequiredArgsConstructor
@Configuration
public class WebConfig implements WebMvcConfigurer {

  private final LoginCheckInterceptor loginCheckInterceptor;

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(loginCheckInterceptor)
      .order(1)
      .addPathPatterns("/**")
      .excludePathPatterns("/users/login", "/v3/api-docs/**", "/swagger-resources/**", "/webjars/**", "/swagger-ui/**");
  }

  @Override
  public void addCorsMappings(CorsRegistry registry) {
    registry.addMapping("/**")
            .allowCredentials(true)
            .allowedMethods("*")
            .allowedHeaders("*")
            .allowedOrigins("http://localhost:3000", "http://localhost:8080", "https://soma-wiki.vercel.app");
  }
}
