package com.somawiki.somawiki.comment.domain;

import com.somawiki.somawiki.review.domain.Review;
import com.somawiki.somawiki.user.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Setter
@Getter
@Entity
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idx")
    private Long idx;

    // 연수생
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userComments")
    private User user;

    // 후기
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "comment")
    private Review review;

    // 내용
    @Column(name="content")
    private String content;

    // 날짜
    @CreatedDate
    private Date createdDate;

    @LastModifiedDate
    private Date lastModifiedDate;

}
