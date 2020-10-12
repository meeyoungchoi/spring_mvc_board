<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="path" value="<%=request.getContextPath()%>" />
<% String userId  = (String)session.getAttribute("loginSuccess"); %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
<title>intro</title>
</head>
<body>
	
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="#">Board</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="<c:url value='/boards/index'/>">자유게시판</a>
      </li>
      <li class="nav-item active">
        <a class="nav-link" href="${path}/users">회원관리 게시판</a>
      </li>
      <li class="nav-item active">
      	<a class="nav-link" href="${path}/users/boardList">회원전용 게시판</a>
      </li>
      <li class="nav-item active">
      	<a class="nav-link" href="${path}/users/myPage">마이페이지</a>
      </li>
     </ul>
     
      <% if (userId != null) {  %> 
      <a class="btn btn-outline-success my-2 my-sm-0" href="${path}/users/logout">로그아웃</a>
      <h1 class="text-success"><%=userId %>님 로그인중</h1>
      <%} else  { %>
     	<a class="btn btn-outline-success my-2 my-sm-0" href="${path}/users/register">회원가입</a>
      <a class="btn btn-outline-success my-2 my-sm-0" href="${path}/users/login">로그인</a>	 
      <% } %>	
      
  </div>
</nav>


