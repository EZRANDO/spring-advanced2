# SPRING ADVANCED

## ✅ Lv 1. 코드 개선

### 📌 1. Early Return 적용
- 이메일 중복 체크를 회원가입 로직 초기에 수행하고 passwordEncoder.encode()를 예외처리 이후에 적   용 
### 📌 2. 불필요한 if-else 제거
- 조건이 맞지 않을 경우 먼저 예외를 던지는 방식으로 Early Return방식 적용 

### 📌 3. Validation 로직 개선
-  비밀번호 복잡성 검사(숫자/대문자 포함, 8자 이상)를 서비스 로직이 아닌 요청 DTO에서 처리하도록 검증 책임을 위임

---

## ✅ Lv 2. N+1 문제 해결

### 📌 1. 기존 JPQL 방식
- `fetch join`을 사용하여 연관된 `user` 엔티티를 한 번의 쿼리로 조회함으로써 N+1 문제 방지

### 📌 2. @EntityGraph 전환
- `@EntityGraph(attributePaths = "user")`를 통해 동일한 동작을 구현
- 쿼리 성능 개선과 함께 코드의 명확성 향상

---

## ✅ Lv 3. 테스트 코드 개선
### 📌 1. 패스워드 인코더 정상 동작하도록 수정
- PasswordEncoder는 자체적으로 인스턴스를 만들 수 없기 때문에 new 구현체 생성을 통해 해결

### 📌 2. 예외 테스트 수정
- `NullPointerException`or `ServerException`이 아닌 `InvalidRequestException`을 실제 예외로 사용
- 메서드명도 예외에 맞춰 수정

### 📌 3. 서비스 로직 보완
- `Todo`에 연관된 `User`가 null인 경우 예외 처리 추가
- 기존 테스트가 실패하지 않도록 서비스 로직 수정

---

## ✅ Lv 4. API 로깅 기능

### 📌 1. Interceptor 기반 로깅 구현
- `/admin/**` 경로에 대해 관리자 접근 로그 기록
- 요청 시각, URI, Role 정보를 `INFO`, `WARN` 수준 로그로 출력

### 📌 2. 접근 권한 제어
- 헤더의 `Role` 값이 `ADMIN`이 아닌 경우 `403 Forbidden` 반환

### 📌 3. 로깅 설정
- `logback-spring.xml`에 interceptor 패키지 로그 레벨 추가
- `application.properties`에서 로그 출력 레벨 명시
