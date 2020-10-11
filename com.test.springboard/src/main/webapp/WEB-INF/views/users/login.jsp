<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="<%=request.getContextPath() %>"/>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="../layouts/header2.jsp" />
<div class="jumbotron">
	<h1>로그인 페이지</h1>
</div>

<form method="post" action="${path}/users/login">
	<div class="form-group row">
		<label class="col-sm-2 col-form-label">아이디</label>
		<div class="col-sm-10">
			<input type="text" name="userId" placeholder="아이디를 입력하세요" class="form-control">
		</div>
	</div>
	<div class="form-group row">
		<label class="col-sm-2 col-form-label">비밀번호</label>
		<div class="col-sm-10">
			<input type="text" name="userPw" placeholder="비밀번호를 입력하세요" class="form-control">
		</div>
	</div>

	<button type="submit" class="btn btn-info btn-block">로그인</button>
</form>

