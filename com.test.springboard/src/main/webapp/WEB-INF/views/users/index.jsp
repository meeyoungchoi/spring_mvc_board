<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="<%=request.getContextPath()%>" />
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="../layouts/header2.jsp" />

<div class="jumbotron">
	<h1>회원제 게시판 입니다.</h1>
</div>





<table class="table text-center table-hover">
	<thead>
		<tr>
			<th>#</th>
			<th>아이디</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="user" items="${users}">
			<tr>
				<td>${user.userNo}</td>
				<td><a href="${path}/users/${user.userId}">${user.userId}</a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<jsp:include page="../layouts/footer.jsp" />


