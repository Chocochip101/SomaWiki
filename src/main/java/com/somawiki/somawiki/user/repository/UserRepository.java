package com.somawiki.somawiki.user.repository;

import com.somawiki.somawiki.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
