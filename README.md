# SPRING ADVANCED
✅ Lv 1. 코드 개선
Early Return 적용

이메일 중복 시 passwordEncoder.encode()를 실행하지 않도록 코드 위치 변경

불필요한 if-else 제거

조건 분기를 단순한 if 문으로 변경하여 가독성 향상

Validation 책임 분리

비밀번호 유효성 검사 로직을 DTO에 @Valid와 @Pattern, @Size 어노테이션으로 위임

✅ Lv 2. N+1 문제 해결
JPQL fetch join으로 연관된 user 엔티티를 함께 조회하여 N+1 문제 해결

동일한 기능을 @EntityGraph 기반으로도 구현

✅ Lv 3. 테스트 코드 개선
예외 발생 테스트에서 실제로 던지는 예외 타입에 맞춰 테스트 메서드명 및 예외 타입 수정

@DisplayName을 통해 테스트 목적 명확히 표현

의도된 예외가 발생하는 상황을 assertThrows로 검증

서비스 로직에서 user가 null인 경우를 고려한 예외 처리 추가

✅ Lv 4. API 로깅 기능 (선택)
Interceptor 기반 어드민 접근 로깅 기능 구현

/admin/** 요청에 대해 사용자 역할(Role), URI, 요청 시각을 로그로 남김

어드민이 아닐 경우 요청 차단 (403 Forbidden)

logback-spring.xml과 application.properties를 통해 로깅 레벨 및 콘솔 출력 설정
