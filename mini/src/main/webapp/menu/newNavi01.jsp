<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<style>
body {
  font-family: "Lucida Sans Typewriter", "Lucida Console", Monaco, "Bitstream Vera Sans Mono", monospace;
  margin: 0px;
  padding: 50px;
  background: #eeeded;
}
#layer_fixed {
  height:44px;
  width:100%;
	position:fixed;
	z-index:999;
	top:0px;
	left:0px;
	-webkit-box-shadow: 0 1px 2px 0 #777;
	box-shadow: 0 1px 2px 0 #777;
}
.menu {
  position: relative;
  background: #00B0FF;
}
.menu ul {
  list-style: none;
  padding: 0;
  margin: 0;
  line-height: 1;
}
.menu > ul {
  position: relative;
  display: block;
  text-align:center;
  background: #00B0FF;
  width: 100%;
  z-index: 500;
}
.menu:after, .menu > ul:after {
  content: ".";
  display: block;
  clear: both;
  visibility: hidden;
  line-height: 0;
  height: 0;
}
.menu.align-right > ul > li {
  float: right;
}
.menu.align-center ul {
  text-align: center;
}
.menu.align-center ul ul {
  text-align: left;
}
.menu > ul > li {
  display: inline-block;
  position: relative;
  margin: 0;
  padding: 0;
}
.menu > ul > #menu-button {
  display: none;
}
.menu ul li a {
  display: block;
  font-family: Helvetica, sans-serif;
  text-decoration: none;
}
.menu > ul > li > a {
  font-size: 14px;
  font-weight: bold;
  padding: 15px 20px;
  color: #fff;
  text-transform: uppercase;
  -webkit-transition: color 0.25s ease-out;
  -moz-transition: color 0.25s ease-out;
  -ms-transition: color 0.25s ease-out;
  -o-transition: color 0.25s ease-out;
  transition: color 0.25s ease-out;
}
.menu > ul > li.sub > a {
  padding-right: 32px;
}
.menu > ul > li:hover > a {
  color: #ffffff;
}
.menu li.sub::after {
  display: block;
  content: "";
  position: absolute;
  width: 0;
  height: 0;
}
.menu > ul > li.sub::after {
  right: 10px;
  top: 20px;
  border: 5px solid transparent;
  border-top-color: #7a8189;
}
.menu > ul > li:hover::after {
  border-top-color: #ffffff;
}
.menu ul ul {
  position: absolute;
  left: -9999px;
  top: 70px;
  opacity: 0;
  -webkit-transition: opacity .3s ease, top .25s ease;
  -moz-transition: opacity .3s ease, top .25s ease;
  -ms-transition: opacity .3s ease, top .25s ease;
  -o-transition: opacity .3s ease, top .25s ease;
  transition: opacity .3s ease, top .25s ease;
  z-index: 1000;
}
.menu ul ul ul {
  top: 37px;
  padding-left: 5px;
}
.menu ul ul li {
  position: relative;
}
.menu > ul > li:hover > ul {
  left: auto;
  top: 44px;
  opacity: 1;
}
.menu.align-right > ul > li:hover > ul {
  left: auto;
  right: 0;
  opacity: 1;
}
.menu ul ul li:hover > ul {
  left: 170px;
  top: 0;
  opacity: 1;
}
.menu.align-right ul ul li:hover > ul {
  left: auto;
  right: 170px;
  top: 0;
  opacity: 1;
  padding-right: 5px;
}
.menu ul ul li a {
  width: 130px;
  border-bottom: 1px solid #eeeeee;
  padding: 10px 20px;
  font-size: 12px;
  color: #9ea2a5;
  background: #ffffff;
  -webkit-transition: all .35s ease;
  -moz-transition: all .35s ease;
  -ms-transition: all .35s ease;
  -o-transition: all .35s ease;
  transition: all .35s ease;
}
.menu.align-right ul ul li a {
  text-align: right;
}
.menu ul ul li:hover > a {
  background: #f2f2f2;
  color: #8c9195;
}
.menu ul ul li:last-child > a, .menu ul ul li.last > a {
  border-bottom: 0;
}
.menu > ul > li > ul::after {
  content: '';
  border: 6px solid transparent;
  width: 0;
  height: 0;
  border-bottom-color: #ffffff;
  position: absolute;
  top: -12px;
  left: 30px;
}
.menu.align-right > ul > li > ul::after {
  left: auto;
  right: 30px;
}
.menu ul ul li.sub::after {
  border: 4px solid transparent;
  border-left-color: #9ea2a5;
  right: 10px;
  top: 12px;
  -moz-transition: all .2s ease;
  -ms-transition: all .2s ease;
  -o-transition: all .2s ease;
  transition: all .2s ease;
  -webkit-transition: -webkit-transform 0.2s ease, right 0.2s ease;
}
.menu.align-right ul ul li.sub::after {
  border-left-color: transparent;
  border-right-color: #9ea2a5;
  right: auto;
  left: 10px;
}
.menu ul ul li.sub:hover::after {
  border-left-color: #ffffff;
  right: -5px;
  -webkit-transform: rotateY(180deg);
  -ms-transform: rotateY(180deg);
  -moz-transform: rotateY(180deg);
  -o-transform: rotateY(180deg);
  transform: rotateY(180deg);
}
.menu.align-right ul ul li.sub:hover::after {
  border-right-color: #ffffff;
  border-left-color: transparent;
  left: -5px;
  -webkit-transform: rotateY(180deg);
  -ms-transform: rotateY(180deg);
  -moz-transform: rotateY(180deg);
  -o-transform: rotateY(180deg);
  transform: rotateY(180deg);
}

</style>

<div id='layer_fixed' class='menu'>
	<ul>
		<li><a href='${pageContext.request.contextPath}/article/list.do'>Home</a></li>
		 <input id=inputContent type="text" name="search">
		<li>
     <a id='aSearch' href='search.do' onclick='searchArticle()'>검색</a>
      
    </li>
    <c:choose>
	    <c:when test="${not empty loginUser}">
		    <li><a href='${pageContext.request.contextPath}/article/add.do'>새 게시글</a></li>
		
				<li class='active sub'>
		    <a href='#'>${loginUser.name}</a>
		    <ul>
		    
		    <li>
          <a href='${pageContext.request.contextPath}/article/gall.do?email=${loginUser.email}'>내가올린 게시물</a>
        </li>
		    
		    <li>
		      <a href='${pageContext.request.contextPath}/member/detail.do?email=${loginUser.email}'>내정보 변경</a>
		    </li>
		    
		    <li class='last'>
		      <a href="${pageContext.request.contextPath}/auth/logout.do">로그아웃</a>
		    </li>
		    
		    </ul>
				</li>
	    </c:when>
	      
	    <c:otherwise>
		    <li class='last'>
		      <a href="${pageContext.request.contextPath}/auth/login.do">로그인</a>
		    </li>
		    <li><a href="${pageContext.request.contextPath}/member/add.do">회원가입</a></li>
	    </c:otherwise>
    </c:choose>
		
	</ul>
	
</div>
<script>
function searchArticle() {
  var content = document.getElementById('inputContent').value;
  
  var href = document.getElementById('aSearch').href 
             + "?content=" + content;
  
  document.getElementById('aSearch').href=href;
}
</script>