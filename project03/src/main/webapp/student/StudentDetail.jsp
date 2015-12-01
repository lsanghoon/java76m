<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<title>학생-상세정보</title>
</head>
<body>

<jsp:include page="/Header.jsp"/>

	<h1>학생 정보</h1>
	<c:if test="${not empty student}">
		<form id='form1' action='update' method='post' enctype="Multipart/form-data">
			<table border='1'>
				<tr>
					<th>번호</th>
					<td><input type='text' name='no' value='${student.no}' readonly></td>
					<td rowspan="5">
					 <img src="${student.photo}" style="height:120px; width:auto">
					</td>
				</tr>
				<tr>
					<th>이름</th>
					<td><input type='text' name='name' value='${student.name}'></td>
				</tr>
				<tr>
					<th>이메일</th>
					<td><input type='text' name='email' value='${student.email}'></td>
				</tr>
				<tr>
					<th>전화번호</th>
					<td><input type='text' name='tel' value='${student.tel}'></td>
				</tr>
				<tr>
					<th>기수</th>
					<td><input type='text' name='cid' value='${student.cid}'></td>
				</tr>
			</table>

			<p>
				<button name='update' type='submit'>변경</button>
				<button name='delete' type='submit' onClick='deleteStudent()'>삭제</button>
			  <input type="file" name="photo">
			</p>

		</form>
	</c:if>
	<c:if test="${empty project}">
		<p>해당 번호의 학생를 찾을수 없습니다.</p>
	</c:if>

	<script>
		function deleteStudent() {
			document.getElementById('form1').action = 'delete';
		}
	</script>
</body>
</html>