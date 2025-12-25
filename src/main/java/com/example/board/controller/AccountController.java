package com.example.board.controller;

import com.example.board.dto.AccountDTO;
import com.example.board.service.AccountServiceImpl;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AccountController {

    private final AccountServiceImpl accountService;

    @PostMapping("/join")
    public ResponseEntity<AccountDTO.JoinResponse> join(@RequestBody @Valid AccountDTO.JoinRequest request) {
        AccountDTO.JoinResponse response = accountService.join(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping("/login")
    public ResponseEntity<AccountDTO.LoginResponse> login(@RequestBody @Valid AccountDTO.LoginRequest request, HttpServletResponse res) {
        AccountDTO.LoginResponse response = accountService.login(request, res);

        return ResponseEntity.ok().body(response);
    }

}