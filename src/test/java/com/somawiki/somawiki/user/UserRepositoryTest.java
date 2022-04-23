package com.somawiki.somawiki.user;

import com.somawiki.somawiki.user.domain.User;
import com.somawiki.somawiki.user.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

@SpringBootTest
@Transactional
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Test
    @DisplayName("User Test")
    void findUser(){
//        User user = User.builder()
//                .name("권기호")
//                .email("dev.chocochip@gmail.com")
//                .password("1234")
//                .build();

    }
}
