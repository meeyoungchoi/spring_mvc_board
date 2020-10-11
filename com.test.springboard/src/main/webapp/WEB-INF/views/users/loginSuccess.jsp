<%@ page import="com.test.springboard.entity.UserEntity"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="path" value="<%=request.getContextPath()%>" />
<jsp:include page="../layouts/header3.jsp" />
<%
	String userId = (String) session.getAttribute("loginSuccess");
%>



<div class="jumbotron">
	<h1>로그인 성공</h1>
	<hr>
	<h2><%=userId %>님 환영합니다.</h2>
	<a>글쓰기</a>
	<a href="${path}/users/logout" class="btn btn-warning btn-block">로그아웃</a>
	<a href="${path}/users/remove" class="btn btn-danger btn-block">회원탈퇴</a>
</div>





