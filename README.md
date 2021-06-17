# mysite_spring

### Backend - Spring

### Frontend - HTML, CSS, JS, Thymeleaf

## 메인 화면
![image](https://user-images.githubusercontent.com/46064193/122313444-32696280-cf51-11eb-85ea-4ae1babf7d41.png)

## 포트폴리오 글 목록
![image](https://user-images.githubusercontent.com/46064193/122313452-36958000-cf51-11eb-9b48-583ab052f636.png)

## 포트폴리오 카테고리 선택
![image](https://user-images.githubusercontent.com/46064193/122313458-38f7da00-cf51-11eb-9b7e-e6e746ad1f0a.png)

## 포트폴리오 이력 작성 및 사진 업로드
![image](https://user-images.githubusercontent.com/46064193/122313468-3b5a3400-cf51-11eb-8b41-6e538576338c.png)

## 메일로 Contact Me 메시지 전송
![image](https://user-images.githubusercontent.com/46064193/122313471-3d23f780-cf51-11eb-9280-775ca31385e9.png)

### 패키지 구조

    └─com
        └─example
            └─mysite
                │  MysiteApplication.java
                │
                ├─Config
                │      SecurityConfig.java
                │      UploadConfig.java
                │
                ├─Controller
                │      ActivitiesController.java
                │      AwardController.java
                │      BasicController.java
                │      ContentController.java
                │      ErrorController.java
                │      LicenseController.java
                │      MailController.java
                │      MemberController.java
                │      ResearchController.java
                │      SStackController.java
                │
                ├─Dto
                │      MemberDto.java
                │
                ├─Entity
                │      Content.java
                │      MemberEntity.java
                │      Role.java
                │
                ├─Repository
                │      ContentRepository.java
                │      MemberRepository.java
                │
                └─Service
                        ContentService.java
                        MemberService.java
