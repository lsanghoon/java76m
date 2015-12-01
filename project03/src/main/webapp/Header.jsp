<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div style="boarder: 1px solid gray; background-color: yellow">

	<c:if test="${not empty loginUser}">
		<form action="${pageContext.request.contextPath}/auth/logout"
			method="get">
			${loginUser.name}(${loginUser.cid}) 
			<input type="submit" value="로그아웃">
		</form>
	</c:if>

	<c:if test="${empty loginUser}">
		<form action="${pageContext.request.contextPath}/auth/LoginForm.jsp" method="get"> 
			<input type="submit" value="로그인" >
		</form>
	</c:if>
</div>