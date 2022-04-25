package com.somawiki.somawiki.user.domain;

import com.somawiki.somawiki.comment.domain.Comment;
import com.somawiki.somawiki.review.domain.Review;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name="User")
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idx")
    private Long idx;

    // 이름
    @NonNull
    @Column(name="name")
    private String name;

    // 비밀번호
    @NotNull
    @Column(name="password")
    private String password;

    // 이메일
    @NonNull
    @Column(name="email")
    private String email;

    // 후기
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "userReviews", cascade = CascadeType.ALL)
    private List<Review> reviews = new ArrayList<>();

    // 댓글
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "userComments", cascade = CascadeType.ALL)
    private List<Comment> comments = new ArrayList<>();

}
