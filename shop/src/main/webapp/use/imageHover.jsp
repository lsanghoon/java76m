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
	
	<c:forEach var="article" items="${articles}">
	
	<li>
	<div class="imgteaser">
	<a href="#">
	  <img src="../img/logout2.png" width="256px" height="256px" alt="Daim Graffiti" />
	  <span class="desc">
	    <h2>슬랙스</h2>
	    <h3>20,000원</h3>
	    <p>
	    새벽녁...후배와 술한잔을 하다 보니 금새 날이 밝아 올랐다.
	    동이 트는 새벽에 느껴오는 이슬은 느껴본자만이 알 수 있는 피곤함과 자괴감, 그리고 후회라는걸..
	    </p>
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