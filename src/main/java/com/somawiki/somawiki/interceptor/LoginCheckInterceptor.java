package com.somawiki.somawiki.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component
public class LoginCheckInterceptor implements HandlerInterceptor {
  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    HttpSession session = request.getSession(false);
    String requestURL = request.getRequestURI();

    if (session == null || session.getAttribute("loginUser") == null) {
      response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "로그인이 필요합니다.");
      return false;
    }
    return true;
  }
}
