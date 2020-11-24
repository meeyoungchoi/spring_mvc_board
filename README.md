### spring 게시판 만들기
## 2020 10월 7일

>게시글 추가
+  [게시글 추가 상세 소스코드](https://blog.naver.com/tkgksw/222109584223) 
+ DTO -> controller -> Entity -> Service -> Repository -> Mapper -> DB
+ new.jsp 에서 데이터를 입력받아서 DTO객체 생성
+ 컨트롤러에서 DTO 데이터를 가지고 Entity 객체 생성
+ Service로 Entity 전달
+ Repository로 Entity 전달
+ Mapper에서 insert문 사용하여 db에 Entity 저장



>게시글 전체 조회
+ [게시글 전체 조회 상세 소스코드](https://blog.naver.com/tkgksw/222109588265)
+ controller -> Service -> Repository -> Mapper -> DB
+ url을 통해 /boards/list 요청을 보냄
+ Service의 목록 가져오는 메서드 실행
+ Reposiotry의 목록 가져오는 메서드 실행
+ Mapper에서 select 쿼리를 사용하여 DB에 저장된 전체 게시글을 가져옴

>사용한 라이브러리
+ JPA
+ LOMBOK
+ MyBatis
+ MySQL

>JPA 목적
+ sql 쿼리가 아니라 메서드로 데이터를 조작할수 있다
+ 객체간 관계를 바탕으로 sql을 자동으로 생성한다
+ @Entity 가 붙은 클래스는 JPA가 관리하는 클래스가 된다
+ @ID로 primary key를 지정할수 있다
+ @GeneratedValue(strategy=IDENTITY)를 통해 pk 관리를 db에 위임할수 있다

>LOMBOK 목적
+ @Data가 getter()/setter()/toString()를 자동으로 만들어 준다
+ @Builder를 사용하여 생성자의 파라미터 순서아 관계없이 객체를 완전하게 만들수 있다

>MyBatis 목적
+ sql 쿼리문을 xml 형식의 파일로 분리시켜 저장및 관리할수 있다
+ java 코드에서 xml태그의 id값만 호출하여 CRUD를 실행할수 있다

>MySQL 목적
+ 테이블을 통해 데이터를 저장 및 관리할수 있다

## 2020 10월 8일

> 게시글 조회
+ [게시글 단일 조회 상세 코드](https://blog.naver.com/tkgksw/222110656540)
+ /boards/${boardNo} -> controller -> service -> repository -> mapper -> DB
+ url로 넘어온 게시글 번호를 사용하여 데이터베이스에서 해당 게시글을 꺼내온다

> 게시글 수정
+ [게시글 수정 상세 코드](https://blog.naver.com/tkgksw/222110668774)
+ 원본 게시글 보여주기
+ /boards/${boardNo}/edit -> controller -> service -> repository -> mapper -> db
+ 수정된 정보를 가지고 새로운 DTO 와 Entity객체를 만든다
+ mapper를 통해 수정된 Entity 객체를 update할때 이미 해당 id가 db에 있으면 객체의 값을 덮어쓰게 된다

> 게시글 삭제
+ [게시글 삭제 상세 코드](https://blog.naver.com/tkgksw/222110672416)
+ /boards/${boardNo}/delete -> controller -> service -> repository -> mapper -> db
+ url을 통해 넘어온 게시글 번호를 사용하여 db에서 해당 객체를 삭제한다
 

## 2020 10월 10일
> 게시글 작성시 작성자, 작성일, 수정일, 조회수 추가
+ 데이터베이스 테이블 구조 변경

> 작성일 표시
+ java.util.Date를 Entity 클래스에 import
+ mapper에서 insert 쿼리가 실행되고 current_timestamp() 가 호출될때 데이터베이스에 Entity 생성시각이 기록된다

> 수정일 표시
+ mapper에서 update 쿼리가 실행되고 current_timestamp on update current_timestamp() 가 호출될때 데이터베이스에 Entity 수정시각이 기록된다

> 조회수 증가
+ index.jsp에서 글 제목을 선택하면 detail.jsp 페이지로 이동하는데 이때 service에서 increase()를 호출하여 해당 Entity의 조회수를 증가시킨다
+ 조회수가 증가된 Entity를 데이터베이스에 반영한다

> 회원관리
> 회원가입
+ user 테이블 생성
+ register.jsp -> DTO -> Entity -> controller -> service -> repository -> db

> 회원정보 조회
+ /users/${userId} -> controller -> service -> repository -> db

> 회원정보 수정
+ /users/${userId}/edit -> controller -> service -> repository -> db -> edit.jsp
+ db에 저장되있던 회원 Entity를 꺼내온다
+ edit.jsp에서 회원정보를 수정한다
+ DTO -> Entity -> service -> repository -> db
+ 수정된 값을 사용하여 새로운 DTO 객체와 Entity 객체가 만들어지고 db에 저장된다

> 회원정보 삭제(회원탈퇴)
+ /users/${userId}/delete -> controller -> service -> repository -> db
+ userId를 바탕으로 db에서 해당 아이디를 가지는 Entity 객체를 삭제한다


## 2020 10월 11일
> 로그인
+ /users/login -> controller -> login.jsp
+ 아이디와 비밀번호 입력
+ service에서 checkIdPw 메서드 호출
+ 사용자가 입력한 로그인 정보가 db에 저장된 회원가입된 정보와 일치하는지 검사
+ 일치하면 로그인 정보를 세션에 저장
+ login 성공 페이지로 이동
+ 세션에서 로그인한 사용자의 id값을 꺼내 로그인한 사용자 id를 보여줌

> 로그아웃
+ 로그인 되어져있는 페이지에서 로그아웃 버튼클릭
+ 컨틀롤러에서 로그인된 정보를 담고있는 세션을 invalidate 시킨다

> 회원탈퇴
+ 로그인 되어져있는 페이지에서 회원탈퇴 버튼클릭
+ 컨트롤러의 remove메서드에서 session에 담겨진 회원 id정보를 가져옴
+ /users/${id}/delete 재요청을 보냄
+ db에서 해당 id를 가지는 Entity 객체를 삭제


## 2020 10월 12일
> 로그인후 로그인 상태 유지
+ 로그인된 사용자의 id를 세션에 담아놓는다
+ view 페이지가 전환될때 마다 세션에서 id를 꺼내서 id값이 null 인지 검사한다
+ null이 아닌 경우 로그인된 상태가 유지된다
+ null인경우 로그인이 되어져있지 않기 때문에 로그인 페이지로 재요청 보낸다


## 2020 10월 13일
> 회원제 게시판
+ 로그인한 회원만 글을 작성할수 있다
+ 글을 작성할때 현재 로그인 중인 회원의 id가 작성자 칸에 표시된다
+ 보안을 위해 글 작성시 회원의 비밀번호를 한번더 입력하게 한다
+ 사용자가 글작성시 입력한 비밀번호가 회원정보와 일치하는지 검사후 
+ 회원정보가 일치하는 경우에만 회원이 작성한 글을 db에 저장한다

> 회원제 게시판 전체회원 글 목록 조회
+ 회원제 게시판에 작성된 모든 글 목록을 db에서 가져와서 보여준다
+ 로그인 했을시에도 전체 회원들이 작성한 글목록을 확인할수 있다

## 2020 10월 14일
> 회원제 게시판 글조회
+ 회원, 비회원 관계없이 글을 조회할수 있다

## 2020 10월 15일
> 회원제 게시판 글수정
+ 글 수정시 비밀번호를 검사
+ 비밀번호가 로그인한 정보와 일치하는 경우에만 글 수정 가능

## 2020 10월 16일
> 회원제 게시판 글 삭제
+ 로그인이 되어진 사람과 삭제하기위해 입력한 비밀번호가 일치하는 사람의 글만 삭제할수 있다

## 2020 10월 17일
> 회원탈퇴시 세션 삭제
> 회원제 게시판 글 수정시 비밀번호가 일치하지 않는경우 예외처리


 
