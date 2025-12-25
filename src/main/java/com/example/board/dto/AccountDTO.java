package com.example.board.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public class AccountDTO {

    // 회원가입 요청
    public record JoinRequest(
            @NotBlank(message = "아이디는 필수 입력값입니다.")
            @Size(min = 4, max = 20, message = "아이디는 4자 이상 20자 이하이어야 합니다.")
            String username,

            @NotBlank(message = "비밀번호는 필수 입력값입니다.")
            @Pattern(
                    regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[@$!%*#?&])[A-Za-z0-9@$!%*#?&]{8,20}$",
                    message = "비밀번호는 8~20자이며 대소문자, 숫자, 특수문자를 모두 포함해야 합니다"
            )
            String password,

            @NotBlank(message = "이메일은 필수 입력값입니다.")
            @Email(message = "이메일 형식이 올바르지 않습니다.")
            String email
    ) {}

    // 회원가입 응답
    public record JoinResponse(String username, String email) {}

    // 로그인 요청
    public record LoginRequest(
            @NotBlank
            String username,
            @NotBlank
            String password) {}

    // 로그인 응답
    public record LoginResponse(String username, String email, LocalDateTime createdAt, LocalDateTime updatedAt) {}

}
