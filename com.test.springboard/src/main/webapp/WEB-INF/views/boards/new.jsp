<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="../layouts/header.jsp" />
<div class="jumbotron">
	<h1>글 작성</h1>
</div>

<form class="container" method="post" action="<c:url value='/boards/new'/>">
	<div class="form-gorup row">
		<label class="col-sm-2">작성자</label>
		<div class="col-sm-10">
			<input type="text" name="writer" placeholder="이름을 입력하세요" class="form-control">
		</div>
	</div>
	<div class="form-group row">
		<label class="col-sm-2">제목</label>
		<div class="col-sm-10">
			<input type="text" name="title" placeholder="제목을 입력하세요" class="form-control">
		</div>
	</div>
	<div class="form-group row">
		<label class="col-sm-2">내용</label>
		<div class="col-sm-10">
			<input type="text" name="content" placeholder="내용을 입력하세요" class="form-control">
		</div>
	</div>
	<div class="form-group row">
		<div class="col-sm-10">
			<input type="hidden" name="readCount" value="0"  class="form-control">
		</div>
	</div>
	<button type="submit" class="btn btn-primary btn-block">저장</button>



</form>





<jsp:include page="../layouts/footer.jsp" />
