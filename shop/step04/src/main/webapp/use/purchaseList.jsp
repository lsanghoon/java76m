<%@page import="java76.pms.domain.Product"%>
<%@page import="java76.pms.dao.ProductDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

<link rel="stylesheet" type="text/css" href="../css/chartStyle.css" />

<h4>${loginUser.name}님의 구매 목록입니다.</h4>
<br>

<table id="hor-minimalist-b" summary="Employee Pay Sheet" border="0">
  <thead>
    <tr>
      <th scope="col" width="130px">판매일</th>
      <th scope="col" width="200px">상품명</th>
      <th scope="col" width="100px">총액</th>
    </tr>
  </thead>
  
  <tbody>
    <c:forEach var="purchase" items="${purchases}">
     
     <form action="update.do" method="post" >
       <tr>
         <td>${purchase.bDate}</td>
         <td>${purchase.bpname}</td>
         <td>${purchase.bpsum} 원</td>
       </tr>
    </form>
    
    </c:forEach>
  </tbody>

</table>

