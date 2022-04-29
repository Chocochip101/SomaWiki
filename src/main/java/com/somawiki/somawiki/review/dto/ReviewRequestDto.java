package com.somawiki.somawiki.review.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReviewRequestDto {
  @NotEmpty
  private String title;
  @NotEmpty
  private long mentor;
  @NotEmpty
  private String link;
  @NotEmpty
  private String summary;
}
