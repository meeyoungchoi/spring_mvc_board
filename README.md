### spring portfolio 게시판 만들기
## 2020 10월 7일

>게시글 추가
+ DTO -> controller -> Entity -> Service -> Repository -> Mapper -> DB
+ new.jsp 에서 데이터를 입력받아서 DTO객체 생성
+ 컨트롤러에서 DTO 데이터를 가지고 Entity 객체 생성
+ Service로 Entity 전달
+ Repository로 Entity 전달
+ Mapper에서 insert문 사용하여 db에 Entity 저장

>게시글 전체 조회
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




 
