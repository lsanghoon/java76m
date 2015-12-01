<%-- EL 사용 --%>
<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
  <meta charset='UTF-8'>
  <title>게시판-목록</title>
</head>
<body>
<h1>게시판(with JSP + JSTL)</h1>
<a href='boardForm.html'>새글</a><br>
<table border='1'>
  <tr>
    <th>번호</th>
    <th>제목</th>
    <th>조회수</th>
    <th>등록일</th>
  </tr>

<c:forEach var="board" items="${boards}">
  
	<tr>
    <td>${board.no}</td>
    <td><a href='update?no=${board.no}'>${board.title}</a></td>
    <td>${board.views}</td>
    <td>${board.createdDate}</td>
  </tr>
  
</c:forEach>

</table>

<jsp:include page="/Copyright.jsp"/>

</body>
</html>
    