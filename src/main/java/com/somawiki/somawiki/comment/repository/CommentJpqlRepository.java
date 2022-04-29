package com.somawiki.somawiki.comment.repository;

import com.somawiki.somawiki.comment.domain.Comment;
import com.somawiki.somawiki.review.domain.Review;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class CommentJpqlRepository {
  @PersistenceContext
  private EntityManager em;

  public List<Comment> findAllByReview(Review review) {
    String jpql = "select c from Comment c " +
      "where c.review = :review";

    List<Comment> result = em.createQuery(jpql, Comment.class)
      .setParameter("review", review)
      .getResultList();

    return result;
  }
}
