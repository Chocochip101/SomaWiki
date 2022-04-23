package com.somawiki.somawiki.review.domain;

import com.somawiki.somawiki.comment.domain.Comment;
import com.somawiki.somawiki.mentor.domain.Mentor;
import com.somawiki.somawiki.user.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idx")
    private Long idx;

    // 연수생
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userReviews")
    private User user;

    // 멘토
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "")
    private Mentor mentor;

    // 제목
    @Column(name="title")
    private String title;

    // 링크
    @Column(name="link")
    private String link;

    // 요약
    @Column(name="summary")
    private String summary;

    // 날짜
    @CreatedDate
    private Date createdDate;

    @LastModifiedDate
    private Date lastModifiedDate;

    // 조회수
    @Column(name="views")
    private Long views;

    // 댓글
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "comment", cascade = CascadeType.ALL)
    private List<Comment> comments = new ArrayList<>();

    public Review() {

    }
}
