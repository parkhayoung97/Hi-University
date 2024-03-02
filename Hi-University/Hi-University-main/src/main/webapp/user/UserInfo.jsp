<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
 <link rel="stylesheet" type="text/css" href="css/shopping.css">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="../base/userHeader.jsp"/>
	<div align="center">

		<h1>조회</h1>
			<table>
				<tr>
					<th>학번</th>
					<td>${user.id}</td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td>${user.pwd}</td>
				</tr>
				<tr>
					<th>이름</th>
					<td>${user.name}</td>
				</tr>
				<tr>
					<th>전공명</th>
					<td>${user.department}</td>
				</tr>
				<tr>
					<th>전화번호</th>
					<td>${user.phone}</td>
				</tr>
				<tr>
					<th>이메일</th>
					<td>${user.email}</td>
				</tr>
				<tr>
					<th>생년월일</th>
					<td>${user.birth}</td>
				</tr>
				<tr>
					<th>주소</th>
					<td>${user.address}</td>
				</tr>
			</table>
	</div>
	<jsp:include page="../base/footer.jsp"/>
</body>
</html>
