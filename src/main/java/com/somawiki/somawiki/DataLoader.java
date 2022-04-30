package com.somawiki.somawiki;

import com.somawiki.somawiki.data.MentorData;
import com.somawiki.somawiki.data.StudentData;
import com.somawiki.somawiki.mentor.domain.Mentor;
import com.somawiki.somawiki.mentor.repository.MentorRepository;
import com.somawiki.somawiki.user.domain.User;
import com.somawiki.somawiki.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Component
@RequiredArgsConstructor
public class DataLoader implements ApplicationRunner {

    private final UserRepository userRepository;
    private final MentorRepository mentorRepository;

    /*
    @Override
    public void run(ApplicationArguments args) {
        User user1 = new User("유저1", "1111", "user1@naver.com");
        User user2 = new User("유저2", "1111", "user2@naver.com");
        User user3 = new User("유저3", "1111", "user3@naver.com");
        User user4 = new User("유저4", "1111", "user4@naver.com");
        User user5 = new User("유저5", "1111", "user5@naver.com");
        User user6 = new User("유저6", "1111", "user6@naver.com");
        userRepository.saveAll(Arrays.asList(user1, user2, user3, user4, user5, user6));

        Mentor mentor1 = new Mentor("멘토1");
        Mentor mentor2 = new Mentor("멘토2");
        Mentor mentor3 = new Mentor("멘토3");
        Mentor mentor4 = new Mentor("멘토4");
        Mentor mentor5 = new Mentor("멘토5");
        Mentor mentor6 = new Mentor("멘토6");
        mentorRepository.saveAll(Arrays.asList(mentor1, mentor2, mentor3, mentor4, mentor5, mentor6));

        Review review1 = new Review("리뷰1", "https://joel-dev.site", "리뷰1: 유저1-멘토1", 0, user1, mentor1);
        Review review2 = new Review("리뷰2", "https://joel-dev.site", "리뷰2: 유저1-멘토2", 0, user1, mentor2);
        Review review3 = new Review("리뷰3", "https://joel-dev.site", "리뷰3: 유저1-멘토3", 0, user1, mentor3);
        Review review4 = new Review("리뷰4", "https://joel-dev.site", "리뷰4: 유저2-멘토1", 0, user2, mentor1);
        Review review5 = new Review("리뷰5", "https://joel-dev.site", "리뷰5: 유저2-멘토4", 0, user2, mentor4);
        Review review6 = new Review("리뷰6", "https://joel-dev.site", "리뷰6: 유저3-멘토5", 0, user3, mentor5);
        Review review7 = new Review("리뷰7", "https://joel-dev.site", "리뷰7: 유저4-멘토3", 0, user4, mentor3);
        Review review8 = new Review("리뷰8", "https://joel-dev.site", "리뷰8: 유저4-멘토6", 0, user4, mentor6);
        Review review9 = new Review("리뷰9", "https://joel-dev.site", "리뷰9: 유저5-멘토1", 0, user5, mentor1);
        Review review10 = new Review("리뷰10", "https://joel-dev.site", "리뷰10: 유저5-멘토2", 0, user5, mentor2);
        Review review11 = new Review("리뷰11", "https://joel-dev.site", "리뷰11: 유저5-멘토5", 0, user5, mentor5);
        Review review12 = new Review("리뷰12", "https://joel-dev.site", "리뷰12: 유저5-멘토6", 0, user5, mentor6);
        Review review13 = new Review("리뷰13", "https://joel-dev.site", "리뷰13: 유저6-멘토6", 0, user6, mentor6);
        reviewRepository.saveAll(Arrays.asList(review1, review2, review3, review4, review5, review6, review7, review8, review9, review10, review11, review12, review13));

        Comment comment1 = new Comment("댓글1: 유저1-리뷰1", user1, review1);
        Comment comment2 = new Comment("댓글2: 유저1-리뷰2", user1, review2);
        Comment comment3 = new Comment("댓글3: 유저1-리뷰3", user1, review3);
        Comment comment4 = new Comment("댓글4: 유저1-리뷰4", user1, review4);
        Comment comment5 = new Comment("댓글5: 유저1-리뷰5", user1, review5);
        Comment comment6 = new Comment("댓글6: 유저3-리뷰1", user3, review1);
        Comment comment7 = new Comment("댓글7: 유저3-리뷰10", user3, review10);
        Comment comment8 = new Comment("댓글8: 유저5-리뷰11", user5, review11);
        Comment comment9 = new Comment("댓글9: 유저6-리뷰12", user6, review12);
        Comment comment10 = new Comment("댓글10: 유저6-리뷰13", user6, review13);
        commentRepository.saveAll(Arrays.asList(comment1, comment2, comment3, comment4, comment5, comment6, comment7, comment8, comment9, comment10));
    }
     */

    @Override
    public void run(ApplicationArguments args) {
        int duplicate = 2;

        String[] students = StudentData.students.split(",");
        for (String student : students) {
            String name = student;
            while (userRepository.existsByName(name)) {
                name += Integer.toString(duplicate);
                duplicate++;
            }
            userRepository.save(new User(name, "1111", ""));
            duplicate = 2;
        }

        String[] mentors = MentorData.mentors.split(",");
        for(String mentor: mentors) {
            String name = mentor;
            while(mentorRepository.existsByName(name)) {
                name += Integer.toString(duplicate);
                duplicate++;
            }
            mentorRepository.save(new Mentor(name));
            duplicate = 2;
        }
    }
}
