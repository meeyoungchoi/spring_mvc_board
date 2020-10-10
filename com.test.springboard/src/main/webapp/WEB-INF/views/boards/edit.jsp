<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="<%=request.getContextPath()%>" />
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="../layouts/header.jsp" />
<div class="jumbotron">
	<h1>게시글 수정</h1>
</div>

<div class="container">
	<c:if test="${board ne null}">
		<form method="post" action="${path}/boards/${boardNo}/update}">
			<div class="form-group row">
				<label class="col-sm-2">번호</label>
				<div class="col-sm-10">
					<input type="text" name="boardNo" value="${board.boardNo}"
						readonly="readonly" class="form-control">
				</div>
			</div>

			<div class="form-group row">
				<label class="col-sm-2">작성자</label>
				<div class="col-sm-10">
					<input type="text" name="writer" value="${board.writer}"
						class="form-control" readonly="readonly">
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2">제목</label>
				<div class="col-sm-10">
					<input type="text" name="title" value="${board.title}"
						class="form-control">
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2">내용</label>
				<div class="col-sm-10">
					<input type="text" name="content" value="${board.content}"
						class="form-control">
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2">조회수</label>
				<div class="col-sm-10">
					<input type="number" name="readCount" value="${board.readCount}"  readonly="readonly"
						class="form-control">
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2">수정일</label>
				<div class="col-sm-10">
					<fmt:formatDate value="${board.updatedDate}"
						pattern="yyyy년 MM월 dd일 a hh:mm" />
				</div>
			</div>
			<button type="submit" class="btn btn-info btn-block">저장</button>

		</form>
		<a href="${path}/boards/${board.boardNo}/delete"
			class="btn btn-danger btn-block">삭제</a>
	</c:if>
</div>




<jsp:include page="../layouts/footer.jsp" />
