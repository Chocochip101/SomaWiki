package com.somawiki.somawiki.review.domain;

import com.somawiki.somawiki.comment.domain.Comment;
import com.somawiki.somawiki.mentor.domain.Mentor;
import com.somawiki.somawiki.BaseTimeEntity;
import com.somawiki.somawiki.user.domain.User;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Review extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long idx;

    // 제목
    @Column(nullable = false)
    private String title;

    // 링크
    @Column(nullable = false)
    private String link;

    // 요약
    @Column(nullable = false)
    private String summary;

    // 조회수
    @Column(nullable = false)
    private Long views;

    // 후기 작성자
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "USER_ID", nullable = false)
    private User user;

    // 멘토
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "MENTOR_ID", nullable = false)
    private Mentor mentor;

    // 댓글
    @OneToMany(mappedBy = "review", orphanRemoval = true)
    private List<Comment> comments = new ArrayList<>();

    public Review(String title, String link, String summary, long views, User user, Mentor mentor) {
        this.title = title;
        this.link = link;
        this.summary = summary;
        this.views = views;
        this.user = user;
        this.mentor = mentor;
    }
}
