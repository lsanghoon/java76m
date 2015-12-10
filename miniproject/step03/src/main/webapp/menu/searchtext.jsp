<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<style>
body {
}

p {
  margin: 0 0 1.5em;
}
.archive {
  max-width: 400px;
  margin: 0 auto;
}

.entry {
  position: relative;
  overflow: hidden;
  margin: 30px 0;
  padding: 20px 20px 1em 20px;
  background: #FFF;
  font-family: "Open Sans", sans-serif;
  box-shadow: 0 0 15px #999;
}

.entry-title,
.entry-title a {
  margin-top: 0;
  font-family: Oswald, sans-serif;
  color: #333;
  text-decoration: none;
}

.entry-title a:hover {
  color: #555;
}

.more-link {
  position: absolute;
  left: 0;
  bottom: 0;
  display: block;
  width: 100%;
  padding: 8px;
  background: #555;
  color: #FFF;
  text-align: center;
  text-transform: uppercase;
  text-decoration: none;
  font-weight: bold;
  box-shadow: 0 0 10px #000;
}

.more-link:hover {
  background: #5E5E5E;
}

.more-link:after {
  content: "\2193";
  margin-left: 8px;
  font-size: .8em;
}

.more-link.open:after {
  content: "\2191";
}
</style>


      <c:forEach var="article" items="${articles}">
<div class="archive">
  <div id="content">

    <div class="post type-post status-publish format-standard hentry category-uncategorized entry">
      <div class="entry-content">
        <form method="get" enctype="multipart/form-data">
        <table border="0" align="center" width="350px">
          <tr>
            <td>&nbsp;작성자 : ${article.name}</td>
          </tr>
          <tr>
            <td>&nbsp;작성일 : ${article.createdDate}</td>
          </tr>
          
          <c:choose>
          <c:when test="${not empty article.photo}">
	          <tr>
	            <td height="30px">
	              <img src="../attachfile/${article.photo}" style="width:350px; height:auto">
	            </td>
	          </tr>
          </c:when>
          <c:otherwise>
            <tr></tr>
          </c:otherwise>
          
          </c:choose>
          <tr>
            <td>${article.content}</td>
          </tr>
        </table>
        <br><br>
        <p align="right">
            <a href='detail.do?email=${loginUser.email}&no=${article.no}' style="text-decoration: none; color: black;">수정</a>
            &nbsp;
            <a href="delete.do?no=${article.no}&email=${loginUser.email}" style="text-decoration: none; color: black;">삭제</a>
        </p>
        </form>
      </div><!-- end .entry-content -->
    </div><!-- end .entry -->
  </div>
</div><!-- end .archive -->
        </c:forEach> 
