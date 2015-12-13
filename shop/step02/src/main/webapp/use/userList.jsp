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
      <th scope="col" width="80px">Name</th>
      <th scope="col" width="150px">Email</th>
      <th scope="col" width="180px">PhoneNo</th>
      <th scope="col" width="300px">Address</th>
      <th scope="col" width="80px" align="center">Point</th>
      <th scope="col" width="80px">Delete</th>
    </tr>
  </thead>
  <tbody>
    
    <c:forEach var="user" items="${users}">
      <tr>
        <td>${user.name}</td>
        <td>${user.email}</td>
        <td>${user.tel}</td>
        <td>${user.addr}</td>
        <td align="right">${user.point} P</td>
        <td><a class="button" href='delete.do?email=${user.email}' style="text-decoration: none;">삭제</a></td>
      </tr>
    </c:forEach>
    
  </tbody>
</table>
