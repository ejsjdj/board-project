# Board Project

Spring Boot + JPA를 이용한 기본 CRUD 게시판 프로젝트

## 📋 현재 진행상황

### Phase 1
- [x] Entity 설계 (User, Post, Comment)
- [ ] Repository 작성
- [ ] Service 로직 구현
- [ ] Controller & View (Thymeleaf)
- [ ] 인증/인가 (Spring Security)

## 🏗️ 기술 스택

- Spring Boot 3.4.0
- Java 17
- JPA (Hibernate)
- H2 Database (테스트)
- Thymeleaf
- Lombok
- Gradle

## 📊 Entity 관계도

User (1) ←→ (N) Post
User (1) ←→ (N) Comment
Post (1) ←→ (N) Comment
Comment (1) ←→ (N) Comment (대댓글)

text

## 🚀 다음 할 일

1. Repository 인터페이스 작성
2. Service 계층 구현
3. Controller 작성
4. 로그인 기능 구현

---

[ ] .gitignore 파일 생성
[ ] git init
[ ] git add .
[ ] git commit -m "커밋 메시지"
[ ] GitHub 저장소 생성
[ ] git remote add origin [저장소 주소]
[ ] git push -u origin main
[ ] README.md 작성 (선택)
