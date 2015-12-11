<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>hh</title>

<link rel="stylesheet" type="text/css" href="../css/style.css" />
<style>
  #wrap{width:1200px;margin:0 auto;position:relative;}
  #main-content li{
  border-width:0 1px 1px 0;
  padding:2px; 
  text-align:center;
  position:relative;
  float:left;
  display:inline;
  margin:5px;
}
</style>

</head>

<body>
<div id="wrap"> 
<div id="main-content">
<div class="vertalign">
  <ui>
  
  <c:forEach var="product" items="${products}">
  
  <li>
  <div class="imgteaser">
  <a href="detail.do?no=${product.no}">
    <img src="../productfile/${product.pphoto}" width="256px" height="256px" />
    <span class="desc">
      <h2>${product.pname}</h2>
      <h3>${product.pcost} 원</h3>
    </span>
  </a>
  </div>
  </li>
  
  </c:forEach>
  
  </ui>
</div>
</div>
</div>

</body>
</html>