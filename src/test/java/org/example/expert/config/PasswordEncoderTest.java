package org.example.expert.config;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
class PasswordEncoderTest {

    //injectMocks를 passwordEncoder에 붙이면 안됨. 테스트할 대상 클래스에 붙여야함.
    //PasswordEncoder는 인터페이스고, @InjectMocks는 객체를 new해서 만들어야함.
    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    //패스워드인코더는 인터페이스고 이걸 쓰려면 실제 구현체 등록하거나 new로 만들어야.
    @Test
    @DisplayName("패스워드 인코더가 정상적으로 동작")

    void encodeAndMatchPassword_successfully(){
        passwordEncoder = new BCryptPasswordEncoder();

        // given 특정 패스워드가 존재한다고 가정.
        String rawPassword = "testPassword";
        String encodedPassword = passwordEncoder.encode(rawPassword);

        //PasswordEncoder은 인터페이스라 new 불가능
        //BCryptPasswrodEncoder은 구현체 클래스.
        // when
        boolean matches = passwordEncoder.matches(rawPassword, encodedPassword);

        // then
        //true가 나와야하는 테스트 전제조건.
        assertTrue(matches);
    }
}
        //rawPassword사용자가 입력한 평문비번. encodedPassword db저장되어있는 해시문자열. verifyer검증도구.
//    public boolean matches(String rawPassword, String encodedPassword) {
//        BCrypt.Result result = BCrypt.verifyer().verify(rawPassword.toCharArray(), encodedPassword);
//        return result.verified;
//    }
