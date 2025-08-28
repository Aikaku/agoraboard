package com.agoraboard.agoraboard.service;

import com.agoraboard.agoraboard.entity.comment.Comment;
import com.agoraboard.agoraboard.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;

    public Long registration(Comment comment) {
        // 댓글 작성

        commentRepository.save(comment);
        return comment.getId();
    }

    // 댓글 삭제
}
