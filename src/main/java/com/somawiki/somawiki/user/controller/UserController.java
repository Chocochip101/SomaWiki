package com.somawiki.somawiki.user.controller;

import com.somawiki.somawiki.user.dto.LoginRequestDto;
import com.somawiki.somawiki.user.dto.LoginResponseDto;
import com.somawiki.somawiki.user.dto.PasswordRequestDto;
import com.somawiki.somawiki.user.exception.LoginException;
import com.somawiki.somawiki.user.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Tag(name = "UserController", description = "사용자 관련 API")
@RequiredArgsConstructor
@RequestMapping("/users")
@RestController
public class UserController {
  private final UserService userService;

  @Operation(summary = "로그인")
  @PostMapping("/login")
  public void login(HttpServletRequest httpServletRequest,
                    @Validated @RequestBody LoginRequestDto requestDto,
                    BindingResult result) throws LoginException {
    if (result.hasErrors()) {
      throw new LoginException("올바른 값을 입력하세요.");
    }

    LoginResponseDto responseDto = userService.login(requestDto);
    HttpSession session = httpServletRequest.getSession();
    session.setAttribute("loginUser", responseDto);
  }

  @Operation(summary = "비밀번호 변경")
  @PutMapping("/password")
  public void changePassword(@RequestBody PasswordRequestDto requestDto,
                             @Parameter(hidden = true) @SessionAttribute LoginResponseDto loginUser) {
    userService.changeUserPassword(requestDto, loginUser.getName());
  }
}
