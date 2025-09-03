package com.agoraboard.agoraboard.service;

import com.agoraboard.agoraboard.entity.user.User;
import com.agoraboard.agoraboard.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public Long join(User user) {
        // 유저 회원가입

        DuplicateLoginId(user);
        DuplicateNickName(user);

        userRepository.save(user);
        return user.getId();
    }

    public void DuplicateLoginId(User user) {
        // 회원가입 시 중복되는 항목 검열

        //==로그인 아이디 중복의 경우==//
        List<User> DuplicateLoginId = userRepository.findByLoginId(user.getLoginId());

        if (!DuplicateLoginId.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 아이디입니다.");
        }
    }

    public void DuplicateNickName(User user) {
        // 회원가입 시 중복되는 항목 검열

        //==닉네임 중복의 경우==//
        List<User> DuplicateNickName = userRepository.findByNickName(user.getName());

        if (!DuplicateNickName.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 닉네임입니다.");
        }
    }

    public void DuplicateNickName(String nickName) {
        // 회원가입 시 중복되는 항목 검열

        //==닉네임 중복의 경우==//
        List<User> DuplicateNickName = userRepository.findByNickName(nickName);

        if (!DuplicateNickName.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 닉네임입니다.");
        }
    }

    public void UpdateNickName(Long userId, String nickName) {
        // 닉네임 변경 (한달에 두 번 가능)

        // 엔티티에서 user를 가져온다.
        User user = userRepository.findOne(userId);
        // 인자로 받은 닉네임이 디비에 있는지 중복이 있는지 확인한다.
        // 있다면 예외처리를 한다.
        DuplicateNickName(nickName);
        // 없다면 유저의 닉네임을 변경한다.
        user.setNickName(nickName);
    }


    // 유저 탈퇴 (재가입은 2주후에 가능)

    // 유저 비밀번호 변경
}
