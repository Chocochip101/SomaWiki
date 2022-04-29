package com.somawiki.somawiki.config;

import com.somawiki.somawiki.interceptor.LoginCheckInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
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
}
