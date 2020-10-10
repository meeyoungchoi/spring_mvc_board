<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="<%=request.getContextPath()%>" />
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="../layouts/header2.jsp" />


<div class="jumbotron">
	<h1>회원정보 수정</h1>
</div>

<c:if test="${user ne null}">
	<form method="post" action="${path}/users/${userId}/update">
		<div class="form-group row">
			<label class="col-sm-2 col-form-label">회원번호</label>
			<div class="col-sm-10">
				<input type="number" name="userNo" value=${user.userNo
				}
					class="form-control" readonly="readonly">
			</div>
		</div>
		<div class="form-group row">
			<label class="col-sm-2 col-form-label">이름</label>
			<div class="col-sm-10">
				<input type="text" name="userName" value=${user.userName
				}
					class="form-control" readonly="readonly">
			</div>
		</div>
		<div class="form-group row">
			<label class="col-sm-2 col-form-label">아이디</label>
			<div class="col-sm-10">
				<input type="text" name="userId" value=${user.userId
				}
					class="form-control" readonly="readonly">
			</div>
		</div>
		<div class="form-group row">
			<label class="col-sm-2 col-form-label">비밀번호</label>
			<div class="col-sm-10">
				<input type="text" name="userPw" value=${user.userPw
				}
					class="form-control">
			</div>
		</div>
		<button type="submit" class="btn btn-info btn-block">수정</button>
	</form>
</c:if>


<jsp:include page="../layouts/footer.jsp" />