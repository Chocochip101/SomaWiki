package com.somawiki.somawiki.user.service;

import com.somawiki.somawiki.user.domain.User;
import com.somawiki.somawiki.user.dto.LoginRequestDto;
import com.somawiki.somawiki.user.dto.LoginResponseDto;
import com.somawiki.somawiki.user.dto.PasswordRequestDto;
import com.somawiki.somawiki.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserService {

  private final UserRepository userRepository;

  @Transactional
  public LoginResponseDto login(LoginRequestDto requestDto) {
    User result = userRepository.findUserByNameAndPassword(requestDto.getId(), requestDto.getPassword());

    if (result == null) {
      return null;
    }

    return new LoginResponseDto(result.getIdx(), result.getName(), result.getEmail());
  }

}
