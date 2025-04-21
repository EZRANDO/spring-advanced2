 package org.example.expert.domain;

import lombok.RequiredArgsConstructor;
import org.example.expert.config.JwtUtil;
import org.example.expert.domain.user.enums.UserRole;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test-token")
@RequiredArgsConstructor
public class JwtTestController {

    private final JwtUtil jwtUtil;

    @GetMapping
    public String generateToken() {
        // 테스트용 유저 정보
        Long userId = 1L;
        String email = "admin@example.com";
        UserRole role = UserRole.ADMIN;

        // 토큰 생성
        return jwtUtil.createToken(userId, email, role);
    }
}
