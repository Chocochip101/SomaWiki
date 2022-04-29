package com.somawiki.somawiki.review.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReviewRequestDto {
  @NotEmpty
  private String title;
  @NotNull
  private long mentor;
  @NotEmpty
  private String link;
  @NotEmpty
  private String summary;
}
