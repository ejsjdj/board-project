package com.example.board.service;

import com.example.board.entity.User;
import com.example.board.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    // 회원가입
    public void join(User user) {
        userRepository.save(user);
    }

    // 로그인
    public User login(String username, String password) {

        User user = userRepository.findByUsername(username);

        if (user == null) throw new IllegalArgumentException("User not found");

        if (password.equals(user.getPassword())) return user;
        else throw new IllegalArgumentException("Invalid password");
    }

    // 비밀번호 변경



    // 사용자 정보 조회


}