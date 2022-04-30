package com.somawiki.somawiki.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Objects;

@Component
public class LoginCheckInterceptor implements HandlerInterceptor {
  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    HttpSession session = request.getSession(false);
    if (session == null || Objects.isNull(session.getAttribute("loginUser"))) {
      response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "로그인이 필요합니다.");
      return false;
    }
    return true;
  }
}
