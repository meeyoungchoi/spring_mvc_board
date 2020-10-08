<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="<%=request.getContextPath() %>"/>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="../layouts/header.jsp" />
<div class="jumbotron">
	<h1>게시글 목록</h1>
	<br> <a class="btn btn-primary btn-block"
		href="<c:url value='/boards/new'/>">글추가</a>
</div>


<table class="table text-center table-hover">
	<thead>
		<tr>
			<th>#</th>
			<th>제목</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="board" items="${boards}">
			<tr>
				<td>${board.boardNo}</td>
				<td>
					<a href="${path}/boards/${board.boardNo}">${board.title}</a>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>



<jsp:include page="../layouts/footer.jsp" />
