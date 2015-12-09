<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    

<!DOCTYPE html>
<html>
<head>
  <meta charset='UTF-8'>
  <title>학생-목록</title>
</head>
<body>

<jsp:include page="/Header.jsp"/>


<h1>학생2</h1>
<a href='add.do'>새 학생</a><br>
<table border='1'>
  <tr>
    <th>프로필</th>
    <th>이메일</th>
    <th>이름</th>
    <th>전화</th>
  </tr>
<c:forEach var="member" items="${members}">    

  
  <tr>
    <td>
      <img style="height:50px; width:auto" 
      src="../file/s-${(empty member.photo)?'anonymous.png':member.photo}">
    </td><td> 
      ${student.email}</td>
    <td><a href='detail.do?email=${member.email}'>${member.name}</a></td>
    <td>${member.tel}</td>
  </tr>
</c:forEach> 
</table>

<jsp:include page="/Copyright.jsp"/>

</body>
</html>    