package com.somawiki.somawiki.comment.domain;

import com.somawiki.somawiki.review.domain.Review;
import com.somawiki.somawiki.BaseTimeEntity;
import com.somawiki.somawiki.user.domain.User;
import lombok.*;

import javax.persistence.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Comment extends BaseTimeEntity {
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

    public Comment(String content, User user, Review review) {
        this.content = content;
        this.user = user;
        this.review = review;
    }

    public boolean isWrittenBy(Long userIdx) {
        return user.getIdx().equals(userIdx);
    }
}
