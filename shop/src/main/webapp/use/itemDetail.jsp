<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

<table style="background-color: white;margin-left: auto; margin-right: auto;">
  <tr>
    <td rowspan="5" width="400px"><img name="cpphoto" src="../productfile/${product.pphoto}"></td>
    <td width="100px"></td>
    <td width="500px" height="50"></td>
  </tr>
  <tr>
    <td height="50"></td>
    <td><h1>상품명: ${product.pname}</h1><hr></td>
  </tr>
  <tr>
    <td></td>
    <td height="80" style="font-size: 26px;">가격: <input type="text" name="cpcost" value="${product.pcost}" disabled="disabled" style="border:none;"></td>
  </tr>
  <tr>
    <td height="50"></td>
    <td style="font-size: 23px;">개수: <input type="number" name="cstock" value="0" style="width: 35px;"/></td>
  </tr>
  <tr>
    <td></td>
    <td height="80"></td>
  </tr>
</table>

<hr>
  <p style="text-align: center; font-size: 30px;">
    <a href="#" style="color: black; text-decoration: none;">즉시구매</a>
    &nbsp; &nbsp; &nbsp; &nbsp;
    <a href="#" style="color: black; text-decoration: none;">장바구니</a>
  </p>
<hr>

<table style="background-color: white;margin-left: auto; margin-right: auto;">
<tr>
  <td><img src="../productfile/${product.fimage}"></td>
</tr>
<tr>
  <td><img src="../productfile/${product.simage}"></td>
</tr>
</table>