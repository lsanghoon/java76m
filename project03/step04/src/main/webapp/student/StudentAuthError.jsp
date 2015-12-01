<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<meta http-equiv="Refresh" content="2;url=list">
<title>학생-오류</title>
</head>
<body>
	<h1>실행 오류</h1>
	<p>
		<c:choose>
			<c:when test="${errorCode == '401'}">
        해당 학생이 존재하지 않습니다.
      </c:when>
			<c:otherwise>
        알수 없는 오류가 발생했습니다.
      </c:otherwise>
		</c:choose>
	</p>	<jsp:include page="/Copyright.jsp" />



</body>
</html>