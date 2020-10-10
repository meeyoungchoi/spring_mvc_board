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

 
