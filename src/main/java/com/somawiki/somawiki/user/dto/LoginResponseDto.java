package com.somawiki.somawiki.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class LoginResponseDto {
  private Long idx;
  private String name;
  private String email;
}
