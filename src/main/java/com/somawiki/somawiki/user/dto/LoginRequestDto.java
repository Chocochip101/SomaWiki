package com.somawiki.somawiki.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@AllArgsConstructor
public class LoginRequestDto {
  @NotEmpty
  private String id;
  @NotEmpty
  private String password;
}
