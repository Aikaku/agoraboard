package com.agoraboard.agoraboard.entity.user;

import com.agoraboard.agoraboard.entity.comment.Comment;
import com.agoraboard.agoraboard.entity.post.Post;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@Table(name = "users")
public class User {
    // 유저 엔티티

    @Id @GeneratedValue
    @Column(name = "user_id")
    private Long id;
    // (중복 불가능)

    private String loginId;
    // 유저 로그인 아이디 (중복 불가능)

    private String password;
    // 유저 비밀번호 (중복 가능)

    private String name;
    // 유저 이름 (중복 가능)

    private String nickName;
    // 유저 닉네임 (중복 불가능)

    @OneToMany(mappedBy = "user")
    private List<Post> posts = new ArrayList<>();
    // 유저가 작성한 글 리스트 (유저는 조회하지 못함)

    @OneToMany(mappedBy = "user")
    private List<Comment> comments = new ArrayList<>();
    // 유저가 작성한 댓글 리스트 (유저는 조회하지 못함)
}
