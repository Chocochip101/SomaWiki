package com.somawiki.somawiki.comment.domain;

import com.somawiki.somawiki.review.domain.Review;
import com.somawiki.somawiki.user.domain.User;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long idx;

    // 내용
    @Column(nullable = false)
    private String content;

    // 댓글 작성자
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "USER_ID", nullable = false)
    private User user;

    // 댓글이 달린 후기
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "REVIEW_ID", nullable = false)
    private Review review;

    // 날짜
    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime lastModifiedDate;

}
