<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일 이미지</title>
</head>
<body>
	<h1>파일 이미지~</h1>

    이름 = ${files.name}<br>
    사진 = ${files.photo}<br>
		<img src="${files.photo}" style="width:300px;height: auto">
</body>
</html>