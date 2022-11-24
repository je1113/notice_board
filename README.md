# notice_board


## 들어가기 전에.. 

### 버전정보
  eclipse IDE: 2018-09-win32-x86_64
  Java: jdk-11.0.16.1
  tomcat apache:Apache Tomcat v9.0
  mySQL: mysql-connector-j-8.0.31.jar
  js: ES6
  
### 필수세팅!
  [JSP] Eclipse - MySQL 커넥터 라이브러리 추가하기
  프로젝트 폴더명 - 우클릭 - Build Path - Configure Build Path
  Java Build Path - Libraries - Modulepath - Add External JARs - mysql-connector-j-8.0.31.jar 추가 - Apply
  Deployment Assembly - Add - Java Build Path Entries - mysql-connector-j-8.0.31.jar 선택 - Apply
  Apply and Close
  프로젝트 폴더 아래의 Referenced Libraries 아래에 mysql-connector~ 생겼으면 OK
  
## 구성요소
### jsp
#### login.jsp: 로그인
#### member.jsp: 회원가입
#### info.jsp: 회원정보 수정
#### idcheck: DB에 같은 아이디 있는지 중복체크
#### board: 게시판 관련 jsp파일 모음
##### list.jsp 게시글 리스트 
##### write.jsp 게시글 작성
##### view.jsp 게시글 보기
##### edit.jsp 게시글 수정
##### like_ok.jsp 좋아요 구현--> servelt으로 변환 예정
#### inclue: 페이지에 반복되는 jsp 모음
##### sessioncheck.jsp : 아이디,이름 세션 정보 확인
### js
#### info.js: 회원정보 수정 조건 설정
#### regist.js: 회원가입 조건 설정
### java src
#### Dbconn.java Db와 연결
#### DeleteOK.java 게시글 삭제 구현
#### EditOk.java 게시글 수정 구현
#### InfoOk.java 회원정보 수정 구현
#### Login.java 로그인 구현
#### Logout.java 로그아웃 구현
#### Member.java 회원가입 정보등록 구현
#### ReplyDelOk.java 댓글삭제 구현
#### ReWriteOk.java 댓글작성 구현
#### WriteOk.java 게시글 작성 구현
## DFD(Data Flow Diagram)
작성예정

## 자세한 구현내용
### 비밀번호 암호화 하여 DB에 저장, 로그인시 암호화된 정보 보내기
  velog주소 추가예정
### 좋아요 회원 1명의 게시글당 한번만 적용, 한번 더 누르면 좋아요 취소
  velog주소 추가예정
### 조회수 회원 1명의 게시글당 한번만 적용.
  velog주소 추가예정
### 자바스크립트로 회원가입 제약조건 설정
  velog주소 추가예정
