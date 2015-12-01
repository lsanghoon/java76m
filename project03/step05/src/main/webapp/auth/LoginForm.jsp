<%@ page language="java" 
  contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
  <h1>로그인~</h1>
  <form id="form1" action="login" method="post">
    <table>
      <tr>
        <th align=right>이메일:</th>
        <td><input type="text" name="email" value="${cookie.email.value}"></td>
      </tr>
      <tr>
        <th align=right>암호:</th>
        <td><input type="password" name="password">
      </tr>
      <tr>
    </table>
    <input type="submit" value="로그인">  
    <input type="checkbox" name="saveEmail" 
      ${(empty cookie.email)?"":"checked"}>이메일 저장<br>
      
  </form>
</body>
</html>