package com.agoraboard.agoraboard.repository;

import com.agoraboard.agoraboard.entity.comment.Comment;
import com.agoraboard.agoraboard.entity.post.Post;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CommentRepository {

    private final EntityManager em;

    public void save(Comment comment) {
        em.persist(comment);
    }
}
