package com.somawiki.somawiki.mentor.dto;

import com.somawiki.somawiki.mentor.domain.Mentor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MentorSimpleDto {
  private long id;
  private String name;

  public MentorSimpleDto(Mentor mentor) {
    this.id = mentor.getIdx();
    this.name = mentor.getName();
  }
}
