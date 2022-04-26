package com.somawiki.somawiki.review.domain;

import com.somawiki.somawiki.comment.domain.Comment;
import com.somawiki.somawiki.mentor.domain.Mentor;
import com.somawiki.somawiki.user.domain.User;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Entity
public class Review {
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

    // 날짜
    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime lastModifiedDate;

    // 후기 작성자
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "USER_ID", nullable = false)
    private User user;

    // 멘토
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "MENTOR_ID", nullable = false)
    private Mentor mentor;

    // 댓글
    @OneToMany(mappedBy = "review")
    private List<Comment> comments = new ArrayList<>();

}
