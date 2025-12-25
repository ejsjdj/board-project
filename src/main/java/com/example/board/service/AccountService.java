package com.example.board.service;

import com.example.board.dto.AccountDTO;
import jakarta.servlet.http.HttpServletResponse;

public interface AccountService {

    // 회원가입
    public AccountDTO.JoinResponse join(AccountDTO.JoinRequest request);

    // 로그인
    public AccountDTO.LoginResponse login(AccountDTO.LoginRequest request, HttpServletResponse res);

}