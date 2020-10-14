<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="<%=request.getContextPath()%>" />
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="../layouts/header.jsp" />

<div class="jumbotron">
	<h1>회원전용 게시글 수정</h1>
</div>
    
<c:if test="${memberArticle ne null }">
	<form>
		<div class="form-group row">
			<label class="col-sm-2 col-form-label">글번호</label>
			<div class="col-sm-10">
				<input type="number" name="articleNo" value="${memberArticle.articleNo}" class="form-control" readonly="readonly">
			</div>
		</div>
		<div class="form-group row">
			<label class="col-sm-2 col-form-label">ID</label>
			<div class="col-sm-10">
				<input type="text" name="userId" value="${memberArticle.userId}" class="form-control" readonly="readonly">
			</div>
		</div>
		<div class="form-group row">
			<label class="col-sm-2 col-form-label">제목</label>
			<div class="col-sm-10">
				<input type="text" name="title" value="${memberArticle.title}" class="form-control">
			</div>
		</div>
		<div class="form-group row">
			<label class="col-sm-2 col-form-label">내용</label>
			<div class="col-sm-10">
				<input type="text" name="content" value="${memberArticle.content}" class="form-control">
			</div>
		</div>
		<div class="form-group row">
			<label class="col-sm-2 col-form-label">비밀번호</label>
			<div class="col-sm-10">
				<input type="text" name="userPw"  class="form-control">
			</div>
		</div>
		<div class="form-group row">
			<label class="col-sm-2 col-form-label">조회수</label>
			<div class="col-sm-10">
				<input type="text" name="readCnt" value="${memberArticle.readCnt}" class="form-control" readonly="readonly">
			</div>
		</div>
		<div class="form-group row">
			<label class="col-sm-2 col-form-label">작성일</label>
			<div class="col-sm-10">
				<input type="text" name="writeDate" value="${memberArticle.writeDate}" class="form-control" readonly="readonly">
			</div>
		</div>
		
		<button type="submit" class="btn btn-info btn-block">저장</button>
				
	
	</form>



</c:if>	    