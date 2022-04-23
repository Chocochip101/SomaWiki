package com.somawiki.somawiki.mentor.repository;

import com.somawiki.somawiki.mentor.domain.Mentor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MentorRepository extends JpaRepository<Mentor, Long> {
}
