<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="<%=request.getContextPath()%>" />
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="../layouts/header2.jsp" />

<div class="jumbotron">
	<h1>회원상세 조회</h1>
</div>



<c:if test="${user ne null }">
<table class="table text-center table-hover">
	<tbody>
		<tr>
			<th>#</th>
			<td>${user.userNo}</td>
		</tr>
		<tr>
			<th>userName</th>
			<td>${user.userName}</td>
		</tr>
		<tr>
			<th>userId</th>
			<td>${user.userId}</td>
		</tr>
		<tr>
			<th>userPw</th>
			<td>${user.userPw}</td>
		</tr>

	</tbody>
</table>


<a class="btn btn-info btn-block" href="${path}/users/${user.userId}/edit">수정</a>	
<a class="btn btn-danger btn-block" href="${path}/users/${user.userId}/delete">삭제</a>	


</c:if>


<jsp:include page="../layouts/footer.jsp" />