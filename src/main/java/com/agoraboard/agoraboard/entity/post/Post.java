package com.agoraboard.agoraboard.entity.post;

import com.agoraboard.agoraboard.entity.comment.Comment;
import com.agoraboard.agoraboard.entity.user.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.FetchType.LAZY;

@Entity
@Getter
@Setter
public class Post {
    // 게시글 엔티티

    @Id @GeneratedValue
    @Column(name = "post_id")
    private Long id;

    private String title;
    // 글 제목

    @Lob
    // 대용량의 데이터 컬럼을 매핑
    private String content;
    // 글 내용

    @CreationTimestamp
    // 엔티티가 persist되는 시점의 시간을 저장함
    private LocalDateTime postTime;
    // 글 작성 시간

    @ManyToOne(fetch = LAZY)
    // 불필요한 조인이 발생하지 않도록 함
    @JoinColumn(name = "user_id")
    private User user;
    // 글 작성자

    @OneToMany(mappedBy = "post")
    private List<Comment> comments = new ArrayList<>();
    // 게시글에 달린 댓글들
}
