package org.example.expert.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.time.LocalDateTime;

//어드민 사용자만 접근할 수 있는 특정 API에는 접근할 때마다 접근 로그를 기록
@Slf4j
@Component
public class LoggingInterceptor implements HandlerInterceptor {

    //로그를 찍기 위한 객체를 생성. 실제로는 logger.info(), logger.warn()방식 로그 출력 가능.
    //private static final Logger logger = LoggerFactory.getLogger(LoggingInterceptor.class);
    //HttpServletRequest사전처리
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        //인증하기 위해서 Header를 가져와야함. uri와 role,time
        String time = LocalDateTime.now().toString();
        String requestURI = request.getRequestURI();
        String role = request.getHeader("Role");

        //어드민이 맞는지 확인. http상태코드 forbidden설정.
        if(!"ADMIN".equals(role)) {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            log.warn("{} is not allowed to access this resource", role);
            log.error("ewrwer");
            return false;
        }
        //요청시각과 URL로깅
        System.out.println("preHandle 실행됨");
        log.info("time={}, requestURI={}, role={}", time, requestURI, role);
        return true;
    }

}
