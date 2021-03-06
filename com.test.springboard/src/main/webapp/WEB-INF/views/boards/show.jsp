<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="<%=request.getContextPath() %>"/>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="../layouts/header.jsp" />
<div class="jumbotron">
	<h1>게시글 상세조회</h1>
</div>

<table class="table text-center table-hover">
	 <c:if test="${board ne null}">
	 <tbody>

        <tr>
            <th>#</th>
            <td>${board.boardNo}</td>
        </tr>
        <tr>
            <th>제목</th>
            <td>${board.title}</td>
        </tr>
        <tr>
            <th>내용</th>
            <td>${board.content}</td>
        </tr>
        <tr>
            <th>조회수</th>
            <td>${board.readCount}</td>
        </tr>
        <tr>
            <th>작성일</th>
            <td>
            	<fmt:formatDate value="${board.createdDate}" pattern="yyyy년 MM월 dd일 a hh:mm"/>
            </td>
        </tr>
        <tr>
            <th>최종수정일</th>
            <td>
            	<fmt:formatDate value="${board.updatedDate}" pattern="yyyy년 MM월 dd일 a hh:mm"/>
            </td>
        </tr>

	
 </tbody>
  </c:if>
	
		

</table>
<div class="container">
	<a href="${path}/boards/${board.boardNo}/edit" class="btn btn-info">수정</a>
	
</div>

<jsp:include page="../layouts/footer.jsp" />