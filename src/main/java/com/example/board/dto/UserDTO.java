package com.example.board.dto;

import java.time.LocalDateTime;

public class UserDTO {

    // 회원가입
    public record JoinRequest(String username, String password, String email) {}

    // 로그인
    public record LoginRequest(String username, String password) {}

    // 비밀번호 변경
    public record ChangePasswordRequest(String password, String newPassword) {}

    // 응답
    public record UserResponse(String username, String email, LocalDateTime createdAt, LocalDateTime updatedAt) {}
}
