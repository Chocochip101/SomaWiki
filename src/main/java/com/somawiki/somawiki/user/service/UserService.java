package com.somawiki.somawiki.user.service;

import com.somawiki.somawiki.user.domain.User;
import com.somawiki.somawiki.user.dto.LoginRequestDto;
import com.somawiki.somawiki.user.dto.LoginResponseDto;
import com.somawiki.somawiki.user.dto.PasswordRequestDto;
import com.somawiki.somawiki.user.exception.LoginException;
import com.somawiki.somawiki.user.exception.NotLoggedInException;
import com.somawiki.somawiki.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@RequiredArgsConstructor
@Service
public class UserService {

  private final UserRepository userRepository;

  @Transactional
  public LoginResponseDto login(LoginRequestDto requestDto) {
    User result = userRepository.findUserByNameAndPassword(requestDto.getId(), requestDto.getPassword());
    if (Objects.isNull(result)) {
      throw new LoginException();
    }

    return new LoginResponseDto(result.getIdx(), result.getName(), result.getEmail());
  }

  @Transactional
  public void changeUserPassword(PasswordRequestDto requestDto, String userName) {
    User user = userRepository.findUserByName(userName);
    user.updatePassword(requestDto.getPassword());
  }

  public LoginResponseDto checkLoggedIn(LoginResponseDto loginUser) {
    if (Objects.isNull(loginUser)) {
      throw new NotLoggedInException("로그인이 필요합니다.");
    }
    return loginUser;
  }
}
