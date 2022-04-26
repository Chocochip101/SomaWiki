package com.somawiki.somawiki.user.repository;

import com.somawiki.somawiki.user.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByName(String name);
    User findByIdx(Long idx);
    User findByEmail(String email);
    Page<User> findAll(Pageable pageable);

}
