package com.somawiki.somawiki.mentor.controller;

import com.somawiki.somawiki.mentor.dto.MentorDetailResponseDto;
import com.somawiki.somawiki.mentor.exception.WrongMentorException;
import com.somawiki.somawiki.mentor.service.MentorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "MentorController", description = "멘토 관련 API")
@RequiredArgsConstructor
@RequestMapping("/mentors")
@RestController
public class MentorController {
  private final MentorService mentorService;

  @Operation(summary = "멘토 디테일")
  @GetMapping("/{mentorIdx}")
  public MentorDetailResponseDto detailsOfMentor(@PathVariable long mentorIdx) throws WrongMentorException {
    MentorDetailResponseDto result = mentorService.showDetailsOfMentor(mentorIdx);

    if (result == null) {
      throw new WrongMentorException();
    }

    return result;
  }
}
