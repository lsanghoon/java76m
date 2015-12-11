<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" type="text/css" href="../css/chartStyle.css" />

<h4>회원 목록</h4>
<br>
<table id="hor-minimalist-b" summary="Employee Pay Sheet">
  <thead>
    <tr>
      <th scope="col">Name</th>
      <th scope="col">Email</th>
      <th scope="col">PhoneNo</th>
      <th scope="col">Address</th>
      <th scope="col">Point</th>
      <th scope="col">Delete</th>
    </tr>
  </thead>
  <tbody>
    
    <c:forEach var="user" items="${users}">
      <tr>
        <td>${user.name}</td>
        <td>${user.email}</td>
        <td>${user.tel}</td>
        <td align="center">${user.addr}</td>
        <td>${user.point}</td>
        <td align="center"><a href='delete?email=${user.email}'>삭제</a></td>
      </tr>
    </c:forEach>
    
  </tbody>
</table>
