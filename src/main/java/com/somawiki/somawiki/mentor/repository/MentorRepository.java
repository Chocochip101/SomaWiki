package com.somawiki.somawiki.mentor.repository;

import com.somawiki.somawiki.mentor.domain.Mentor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MentorRepository extends JpaRepository<Mentor, Long> {
    Mentor findByName(String name);
    Mentor findByIdx(Long idx);
    Page<Mentor> findAll(Pageable pageable);
    boolean existsByName(String name);
}
