<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset='UTF-8'>
  <title>학생-목록</title>
</head>
<body>

<jsp:include page="/Header.jsp"/>

<h1>학생 목록</h1>

<a href='studentForm.html'>학생추가</a><br>
<form method="get" enctype="Multipart/form-data">

<table border='1'>
  <tr>
    <th>번호</th>
    <th>프로필</th>
    <th>이름</th>
    <th>이메일</th>
    <th>전화번호</th>
    <th>기수</th>
  </tr>
      
<c:forEach var="student" items="${students}">
  <tr>
    <td>${student.no}</td>
    <td><img src="../file/thumbnail/s-${(empty student.photo) ? 'default.jpg' : student.photo}" align="center" 
              style="height:50px; width:auto"></td>
    <td><a href='update.do?no=${student.no}'>${student.name}</a></td>
    <td>${student.email}</td>
    <td>${student.tel}</td>
    <td>${student.cid}</td>
  </tr>
</c:forEach>

</table>
</form>
<jsp:include page="/Copyright.jsp"/>

</body>
</html>