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
	<h1>회원제게시판 글 상세 조회</h1>
</div>

<c:if test="${memberArticle ne null }">
	
	

	<table class="table text-center table-hover">
		<tbody>
			<tr>
				<th>#</th>
				<td>${memberArticle.articleNo}</td>
			</tr>
			<tr>
				<th>아이디</th>
				<td>${memberArticle.userId}</td>
			</tr>
			<tr>
				<th>제목</th>
				<td>${memberArticle.title}</td>
			</tr>
			<tr>
				<th>내용</th>
				<td>${memberArticle.content}</td>
			</tr>
			<tr>
				<th>조회수</th>
				<td>${memberArticle.readCnt}</td>
			</tr>
			<tr>
				<th>작성일</th>
				<td>${memberArticle.writeDate}</td>
			</tr>
			<tr>
				<th>최종수정일</th>
				<td>${memberArticle.updatedDate}</td>
			</tr>


		</tbody>
	</table>

<a class="btn btn-info btn-block"
				href="${path}/users/${articleNo}/update">수정</a>



<a  class="btn btn-danger btn-block" href="${path}/users/delete/${articleNo}" >삭제</a>
		






</c:if>