package com.agoraboard.agoraboard.entity.comment;

import com.agoraboard.agoraboard.entity.post.Post;
import com.agoraboard.agoraboard.entity.user.User;
import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.apache.logging.log4j.util.Lazy;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

import static jakarta.persistence.FetchType.LAZY;

@Entity
@Getter @Setter
public class Comment {

    @Id @GeneratedValue
    @Column(name = "comment_id")
    private Long id;
    // (중복 불가능)

    @Lob
    private String comment;
    // 댓글 내용 (중복 가능)

    @CreationTimestamp
    // 엔티티가 persist되는 시점의 시간을 저장함
    private LocalDateTime commentTime;
    // 댓글 작성 시간

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "user_id")
    private User user;
    // 댓글 작성자 (중복 가능)

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "post_id")
    private Post post;
    // 해당 댓글이 달린 게시글 (중복 가능)
}
