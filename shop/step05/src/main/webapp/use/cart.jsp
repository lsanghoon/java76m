<%@page import="java76.pms.domain.Product"%>
<%@page import="java76.pms.dao.ProductDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

<link rel="stylesheet" type="text/css" href="../css/chartStyle.css" />

<h4>장바구니</h4>
<br>
<table id="hor-minimalist-b" summary="Employee Pay Sheet" border="0">
  <thead>
    <tr>
      <th scope="col" width="150px">상품 이미지</th>
      <th scope="col" width="180px">상품명</th>
      <th scope="col" width="100px">가격</th>
      <th scope="col" width="80px" align="center">수량</th>
      <th scope="col" width="140px" align="center">변경 / 삭제</th>
    </tr>
  </thead>
  <tbody>
    
    <c:forEach var="cart" items="${cart}">
     <form id="form1" action="update.do" method="post" >
       <tr>
         <td>
           <img src="../productfile/${cart.cpphoto}" width="100px" height="100px">
           <input type="hidden" name="no" value="${cart.no}">
         </td>
         <td>
           ${cart.cpname}
         </td>
         <td>${cart.cpcost}</td>
         <td>
           <input type="number" name="cstock" value="${cart.cstock}" min="1" max="50" style="width: 45px;"/>
         </td>
         <td>
           <a class="button1" href='delete.do?no=${cart.no}' style="text-decoration: none;">삭제</a>
           <button class="button">변경</button>
         </td>
       </tr>
      </form>
    </c:forEach>
    
    <form id="form2" action="../purchase/add.do" method="post">
      <tr>
       <td colspan="2">
        <input type="hidden" name="bpname" value="${names}">
       </td>
       <td align="right">
         총액 :
       </td>
       <td>
         <input type="text" name="bpsum" value="${sum}" style="border: 0px; background-color: #f5f5f5;" readonly><br>
         
       </td>
       <td align="center">
         <button class="button">구매하기</button>
       </td>
      </tr>
    </form>
  </tbody>
</table>
<br>
<br><br><br>

