package com.somawiki.somawiki.mentor.service;

import com.somawiki.somawiki.mentor.domain.Mentor;
import com.somawiki.somawiki.mentor.dto.MentorDetailResponseDto;
import com.somawiki.somawiki.mentor.exception.WrongMentorException;
import com.somawiki.somawiki.mentor.repository.MentorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@RequiredArgsConstructor
@Service
public class MentorService {
  private final MentorRepository mentorRepository;

  public MentorDetailResponseDto showDetailsOfMentor(long mentorIdx) {
    Mentor mentor = mentorRepository.findByIdx(mentorIdx);
    if (Objects.isNull(mentor)) {
      throw new WrongMentorException();
    }

    return new MentorDetailResponseDto(mentor.getIdx(), mentor.getName(), mentor.getReviews());
  }
}
