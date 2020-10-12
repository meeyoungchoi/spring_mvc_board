<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="path" value="<%=request.getContextPath()%>" />
<jsp:include page="../layouts/header.jsp" />
<%
	String userId = (String) session.getAttribute("loginSuccess");	
%>

	<div class="jumbotron">
		<h1>회원제 게시판 글쓰기</h1>
		<% if (userId == null)  { %>
			<h1 class="text-danger">로그인을 먼저 해주세요</h1>
		<%  response.sendRedirect("login");} %>
	</div>
	
	<form method="" action="" class="container">
		<div class="form-group row">
			<label class="col-sm-2 col-form-label">작성자</label>
			<div class="col-sm-10">
				<input type="text" name="userId" value="<%=userId %>" class="form-control" readonly="readonly">
			</div>
		</div>
		<div class="form-group row">
			<label class="col-sm-2 col-form-label">제목</label>
			<div class="col-sm-10">
				<input type="text" name="title"  class="form-control">
			</div>
		</div>
		<div class="form-group row">
			<label class="col-sm-2 col-form-label">내용</label>
			<div class="col-sm-10">
				<input type="text" name="content"  class="form-control">
			</div>
		</div>
		<div class="form-group row">
			<label class="col-sm-2 col-form-label">비밀번호</label>
			<div class="col-sm-10">
				<input type="text" name="writerPw" placeholder="글 보안을 위해 회원님의 비밀번호를 입력하세요"  class="form-control">
			</div>
		</div>
		<button type="submit" class="btn btn-info btn-block">저장</button>
	
	</form>	
		
	

