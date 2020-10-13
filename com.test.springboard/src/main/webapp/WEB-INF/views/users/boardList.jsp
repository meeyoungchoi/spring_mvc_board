<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="<%=request.getContextPath()%>" />
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String userId = (String) session.getAttribute("loginSuccess");
%>


<jsp:include page="../layouts/header.jsp" />
<div class="jumbotron">
	<h1>회원전용 게시판 입니다.</h1>
	<hr>
	<%
		if (userId != null) {
	%>
	<a href="${path}/users/write">글쓰기</a>
	<%
		} else {
	%>
	<h1 class="text-danger">로그인을 하셔야 글을작성하실수 있습니다.</h1>
	<%
		}
	%>
</div>


<table class="table text-center table-hover">
	<thead>
		<tr>
			<th>#</th>
			<th>작성자</th>
			<th>제목</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="memArticles" items="${memberArticles}">

			<tr>
				<td>${memArticles.articleNo}</td>
				<td>${memArticles.userId}</td>
				<td>${memArticles.title}</td>
			</tr>

		</c:forEach>
	</tbody>

</table>
