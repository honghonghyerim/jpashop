# 🛒 JPA Shop - 스프링 부트와 JPA 활용 웹 애플리케이션

스프링 부트와 JPA를 활용해서 **회원, 상품, 주문 도메인**을 가진 간단한 쇼핑몰 형태의 웹 애플리케이션을 구현하는 프로젝트입니다.  

---

## 🧱 주요 기능 (도메인)

다음 도메인을 중심으로 애플리케이션을 설계하고 구현합니다.

- **회원(Member)**
  - 회원 등록
  - 회원 조회 (목록)
- **상품(Item)**
  - 상품 등록
  - 상품 목록 조회
  - 상품 수정
- **주문(Order)**
  - 상품 주문
  - 주문 내역 조회 및 검색
  - 주문 취소

---

## 🛠️ 사용 기술 스택

- **Language**: Java
- **Framework**: Spring Boot, Spring Web, Spring Data JPA
- **ORM**: Hibernate
- **DB**: H2 Database (개발/테스트용)
- **View**: Thymeleaf
- **Build Tool**: Gradle or Maven
- **기타**: Lombok

---

## 🗂️ 프로젝트 구조 예시

```bash
src
 ├─ main
 │   ├─ java
 │   │   └─ jpabook.jpashop
 │   │       ├─ JpashopApplication.java
 │   │       ├─ domain      # 엔티티, 값 객체
 │   │       ├─ repository  # JPA 리포지토리
 │   │       ├─ service     # 비즈니스 로직
 │   │       └─ controller  # 웹 계층(컨트롤러)
 │   └─ resources
 │       ├─ application.yml
 │       ├─ templates       # 타임리프 뷰
 │       └─ static          # 정적 리소스(css, js)
 └─ test
     └─ java
         └─ jpabook.jpashop
             └─ service     # 서비스 테스트 코드
