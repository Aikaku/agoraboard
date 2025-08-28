package com.agoraboard.agoraboard.repository;

import com.agoraboard.agoraboard.entity.post.Post;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class PostRepository {

    private final EntityManager em;

    public void save(Post post) {
        // 게시글을 Transaction이 끝나면 DB에 저장

        em.persist(post);
    }

    public void delete(Post post) {
        // 게시글을 Tracsaction이 끝나면 DB에서 삭제
        em.remove(post);
    }
}
