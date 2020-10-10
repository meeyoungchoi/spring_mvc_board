<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="<%=request.getContextPath() %>"/>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="../layouts/header2.jsp" />
<div class="jumbotron">
	<h1>회원가입 페이지</h1>
</div>

<form method="post" action="${path}/users/register">
	<div class="form-group row">
		<label  class="col-sm-2">이름</label>
		<div class="col-sm-10">
			<input type="text" name="userName" placeholder="이름을 입력하세요" class="form-control">
		</div>
	</div>
	<div class="form-group row">
		<label  class="col-sm-2">아이디</label>
		<div class="col-sm-10">
			<input type="text" name="userId" placeholder="아이디를 입력하세요" class="form-control">
		</div>
	</div>
	<div class="form-group row">
		<label  class="col-sm-2">비밀번호</label>
		<div class="col-sm-10">
			<input type="text" name="userPw" placeholder="비밀번호를 입력하세요" class="form-control">
		</div>
	</div>
	
	<button type="submit" class="btn btn-primary btn-block">회원가입</button>
	
</form>





<jsp:include page="../layouts/footer.jsp" />




