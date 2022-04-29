package com.somawiki.somawiki.mentor.controller;

import com.somawiki.somawiki.mentor.dto.MentorDetailResponseDto;
import com.somawiki.somawiki.mentor.exception.WrongMentorException;
import com.somawiki.somawiki.mentor.service.MentorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/mentors")
@RestController
public class MentorController {
  private final MentorService mentorService;

  @GetMapping("/{mentorIdx}")
  public MentorDetailResponseDto detailsOfMentor(@PathVariable long mentorIdx) throws WrongMentorException {
    MentorDetailResponseDto result = mentorService.showDetailsOfMentor(mentorIdx);

    if (result == null) {
      throw new WrongMentorException();
    }

    return result;
  }
}
