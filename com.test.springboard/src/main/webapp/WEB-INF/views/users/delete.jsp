<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="<%=request.getContextPath()%>" />
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="../layouts/header.jsp" />

<%
	String loginId = (String) session.getAttribute("userId");
%>
<div class="jumbotron">

	<p class="container">${articleNo}번글 삭제</p>

</div>




	<form class="container" method="post" action="${path}/users/${articleNo}/remove">
		<div class="form-group row">
			<label class="col-sm-2 col-form-label">비밀번호</label>
			<div class="col-sm-10">
				<input type="text" name="userPw" class="form-control" placeholder="삭제할 게시글의 비밀번호를 입력하세요">
			</div>
			<button type="submit" class="btn btn-danger btn-block">삭제</button>
			
		</div>
			
	</form>
       