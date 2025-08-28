package com.agoraboard.agoraboard.service;

import com.agoraboard.agoraboard.entity.post.Post;
import com.agoraboard.agoraboard.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public Long registration(Post post) {
        // 게시물 등록

        postRepository.save(post);
        return post.getId();
    }

    // 게시물 수정 (댓글이 없을 시 가능)

    // 게시물 추신 (댓글이 있을 시 수정 대신 추신)
}
