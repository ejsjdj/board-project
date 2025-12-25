package com.example.board.service;

import com.example.board.common.util.HttpUtils;
import com.example.board.common.util.TokenUtils;
import com.example.board.dto.AccountDTO;
import com.example.board.entity.User;
import com.example.board.etc.AccountConstants;
import com.example.board.repository.UserRepository;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public AccountDTO.JoinResponse join(AccountDTO.JoinRequest request) {

        // 중복 체크
        if (userRepository.existsByUsername(request.username())) {
            throw new IllegalArgumentException("이미 존재하는 아이디입니다.");
        }

        // 비밀번호 암호화
        String BCryptedPassword = passwordEncoder.encode(request.password());

        // 사용자 저장
        User user = new User(request.username(), BCryptedPassword, request.email());
        userRepository.save(user);

        return new AccountDTO.JoinResponse(request.username(), request.email());
    }

    @Override
    @Transactional
    public AccountDTO.LoginResponse login(AccountDTO.LoginRequest request, HttpServletResponse res) {

        User user = userRepository.findByUsername(request.username())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 아이디입니다."));

        if (!passwordEncoder.matches(request.password(), user.getPassword())) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }

        // 회원정보
        long userid = user.getId();
        String username = user.getUsername();

        // 액세스 토큰 발급
        String accessToken = TokenUtils.generate(AccountConstants.ACCESS_TOKEN_NAME, AccountConstants.MEMBER_NAME, username, AccountConstants.ACCESS_TOKEN_EXP_MINUTES);

        // 리프레시 토큰 발급
        String refreshToken = TokenUtils.generate(AccountConstants.REFRESH_TOKEN_NAME, AccountConstants.MEMBER_NAME, username, AccountConstants.REFRESH_TOKEN_EXP_MINUTES);

        HttpUtils.setCookie(res, AccountConstants.ACCESS_TOKEN_NAME, accessToken,AccountConstants.ACCESS_TOKEN_EXP_MINUTES);
        HttpUtils.setCookie(res, AccountConstants.REFRESH_TOKEN_NAME, refreshToken,AccountConstants.REFRESH_TOKEN_EXP_MINUTES);

        return new AccountDTO.LoginResponse(
                user.getUsername(),
                user.getEmail(),
                user.getCreatedAt(),
                user.getUpdatedAt()
        );
    }
}