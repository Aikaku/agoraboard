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

        DuplicateUser(user);

        userRepository.save(user);
        return user.getId();
    }

    public void DuplicateUser(User user) {
        // 회원가입 시 중복되는 항목 검열

        //==닉네임 중복의 경우==//
        List<User> DuplicateNickName = userRepository.findByNickName(user.getName());

        if (!DuplicateNickName.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 닉네임입니다.");
        }

        //==로그인 아이디 중복의 경우==//
        List<User> DuplicateLoginId = userRepository.findByLoginId(user.getLoginId());

        if (!DuplicateLoginId.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 아이디입니다.");
        }
    }

    // 닉네임 변경 (한달에 두 번 가능)

    // 유저 탈퇴 (재가입은 2주후에 가능)

    // 유저 비밀번호 변경
}
