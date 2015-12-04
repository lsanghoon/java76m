<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<title>학생-상세정보</title>
<link rel="stylesheet" type="text/css" href="../css/common.css">
</head>
<body>

	<jsp:include page="/Header.jsp" />

	<h1>학생 정보</h1>
	<c:if test="${not empty student}">
		<form id='form1' action='update.do' method='post'
			enctype="Multipart/form-data">
			<table border='1'>
				<tr>
					<th>번호</th>
					<td><input type='text' name='no' value='${student.no}' size="40" readonly></td>
				</tr>
				<tr>
					<th>이름</th>
					<td><input type='text' name='name' value='${student.name}' size="40"></td>
				</tr>
				<tr>
					<th>이메일</th>
					<td><input type='text' name='email' value='${student.email}' size="40"></td>
				</tr>
				<tr>
					<th>전화번호</th>
					<td><input type='text' name='tel' value='${student.tel}' size="40"></td>
				</tr>
				<tr>
					<th>기수</th>
					<td><input type='text' name='cid' value='${student.cid}' size="40"></td>
				</tr>
				<tr>
				<th colspan="2">프로필 사진</th>
				</tr>
				<tr>
					<td colspan="2">
					  <img src="../file/${(empty student.photo) ? 'default.jpg' : student.photo}"
						     style="width: 313px; heigth: auto"> 
						<input type='hidden' name='photoFile' value='${student.photo}'>
					</td>
				</tr>
			</table>

			<p>
				<input type="file" name="photo"> <br><br>
				<button name='update' type='submit' class='button1'>변경</button>
				<a href='delete.do?no=${student.no}' class='button2'>삭제</a>
			</p>

		</form>
	</c:if>
	<c:if test="${empty project}">
		<p>해당 번호의 학생를 찾을수 없습니다.</p>
	</c:if>

</body>
</html>