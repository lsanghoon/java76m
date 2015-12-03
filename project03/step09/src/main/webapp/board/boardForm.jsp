<%@page import="java76.pms.domain.Board"%>
<%@page import="java.util.List"%>
<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<title>게시판-새글</title>
</head>
<body>
  <h1>게시물 새글</h1>
  <form action='add.do' method='post' enctype="multipart/form-data">
    <table border='1'>
      <tr>
        <th>제목</th>
        <td><input type='text' name='title' placeholder="제목을 넣으세요"></td>
      </tr>
      <tr>
        <th>내용</th>
        <td><textarea rows='10' cols='60' name='content'
            placeholder="내용을 넣으세요"></textarea></td>
      </tr>
      <tr>
        <th>암호</th>
        <td><input type='password' name='password'></td>
      </tr>
      <tr>
        <th>첨부파일</th>
        <td><input type="file" name="attachFile"></td>
      </tr>
    </table>

    <p>
      <button type='submit'>등록</button>
    </p>

  </form>

<jsp:include page="/Copyright.jsp"/>
<%-- <jsp:include page="/byebye.jsp"/> --%>
</body>
</html>
    