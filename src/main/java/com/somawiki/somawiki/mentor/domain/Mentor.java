package com.somawiki.somawiki.mentor.domain;

import com.somawiki.somawiki.review.domain.Review;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Mentor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long idx;

    // 이름
    @Column(nullable = false)
    private String name;

    // 후기
    @OneToMany(mappedBy = "mentor")
    private List<Review> reviews = new ArrayList<>();
}
