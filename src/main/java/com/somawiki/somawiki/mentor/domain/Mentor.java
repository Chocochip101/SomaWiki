package com.somawiki.somawiki.mentor.domain;

import com.somawiki.somawiki.review.domain.Review;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Mentor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idx")
    private Long idx;

    // 이름
    @NonNull
    @Column(name="name")
    private String name;

    // 후기
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "reviews", cascade = CascadeType.ALL)
    private List<Review> reviews = new ArrayList<>();

}
