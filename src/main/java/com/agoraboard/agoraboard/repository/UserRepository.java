package com.agoraboard.agoraboard.repository;

import com.agoraboard.agoraboard.entity.user.User;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
// final이 붙은 필드의 생성자를 자동으로 만듬
public class UserRepository {

    private final EntityManager em;

    //=====User Service=====//
    public void save(User user) {
        // 유저를 DB에 저장
        em.persist(user);
    }

    //=====Admin Service=====//
    public User findOne (Long id) {
        // DB에서 id로 유저 한명을 찾기
        return em.find(User.class, id);
    }

    public List<User> findAll () {
        return em.createQuery("select u from User u", User.class).getResultList();
    }

    public List<User> findByNickName(String nickName) {
        // 맴버 특정 낙네임을 조회하는 메서드
        return em.createQuery("select u from User u where u.nickName = :name", User.class)
                .setParameter("name", nickName)
                .getResultList();
    }

    public List<User> findByLoginId(String loginId) {
        // 맴버 특정 로그인 아이디를 조회하는 메서드
        return em.createQuery("select u from User u where u.loginId = :name", User.class)
                .setParameter("name", loginId)
                .getResultList();
    }

}
