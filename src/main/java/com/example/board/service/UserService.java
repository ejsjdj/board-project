package com.example.board.service;

import com.example.board.dto.UserDTO;
import com.example.board.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    // 회원가입
    public UserDTO.JoinResponse join(UserDTO.JoinRequest request) {
        return null;
    }

    // 로그인
    public UserDTO.LoginResponse login(UserDTO.LoginRequest request) {
        return null;
    }

    // 비밀번호 변경
    public UserDTO.ChangePasswordResponse changePassword(UserDTO.ChangePasswordRequest request) {
        return null;
    }

    // 사용자 정보 조회
    public UserDTO.UserResponse getUserInfo(UserDTO.UserRequest request) {
        return null;
    }

}