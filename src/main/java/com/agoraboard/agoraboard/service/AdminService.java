package com.agoraboard.agoraboard.service;

import com.agoraboard.agoraboard.entity.post.Post;
import com.agoraboard.agoraboard.entity.user.User;
import com.agoraboard.agoraboard.repository.PostRepository;
import com.agoraboard.agoraboard.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class AdminService {
    // 관리자 영역

    private final PostRepository postRepository;
    private final UserRepository userRepository;

    //=====유저 서비스 관련=====//
    public User findUser(Long userId) {
        // 유저 한 명 찾기
        return userRepository.findOne(userId);
    }

    public List<User> findAllUser() {
        // 모든 유저 조회
        return userRepository.findAll();
    }

    //=====게시글 관련=====//

    public Long delete(Post post) {
        // 게시물 삭제

        postRepository.delete(post);
        return post.getId();
    }

    // 유저 한 명이 쓴 글 목록 조회

    // 유저 한 명이 쓴 모든 댓글 조회
}
