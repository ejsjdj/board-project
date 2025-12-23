package com.example.board.dto;

import java.time.LocalDateTime;

public class UserDTO {

    // 회원가입 요청
    public record JoinRequest(String username, String password, String email) {}

    // 회원가입 응답
    public record JoinResponse(String username, String email, LocalDateTime createdAt, LocalDateTime updatedAt) {}

    // 로그인 요청
    public record LoginRequest(String username, String password) {}

    // 로그인 응답
    public record LoginResponse(String username, String email, LocalDateTime createdAt, LocalDateTime updatedAt) {}

    // 비밀번호 변경요청
    public record ChangePasswordRequest(String password, String newPassword) {}

    // 비밀번호 변경응답
    public record ChangePasswordResponse(String username, String email, LocalDateTime createdAt, LocalDateTime updatedAt) {}

    // 사용자 정보 요청
    public record UserRequest(String username, String email) {}

    // 사용자 정보 응답
    public record UserResponse(String username, String email, LocalDateTime createdAt, LocalDateTime updatedAt) {}

}
