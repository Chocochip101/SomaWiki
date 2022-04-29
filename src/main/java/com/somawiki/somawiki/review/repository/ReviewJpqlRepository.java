package com.somawiki.somawiki.review.repository;

import com.somawiki.somawiki.review.domain.Review;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ReviewJpqlRepository {
  @PersistenceContext
  private EntityManager em;

  /**
   *
   * @param size 출력할 item 개수
   * @return
   */
  public List<Review> findAllOrderByCreatedDateDesc(int size) {
    String jpql = "select r from Review r " +
      "order by r.createdDate desc";

    List<Review> resultList = em.createQuery(jpql, Review.class)
      .setFirstResult(0)
      .setMaxResults(size)
      .getResultList();

    return resultList;
  }

  /**
   *
   * @param size 출력할 item 개수
   * @return
   */
  public List<Review> findAllOrderByViewsDesc(int size) {
    String jpql = "select r from Review r " +
      "order by r.views desc";

    List<Review> resultList = em.createQuery(jpql, Review.class)
      .setFirstResult(0)
      .setMaxResults(size)
      .getResultList();

    return resultList;
  }


}
