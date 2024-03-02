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
	<jsp:include page="../base/adminHeader.jsp" />
	<h1 align="center">학생 정보 조회</h1>
	<table align="center">
		<tr>
			<th style="width: 60px">아이디</th>
			<td>${info.id}</td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td>${info.pwd}</td>
		</tr>
		<tr>
			<th>이름</th>
			<td>${info.name}</td>
		</tr>
		<tr>
			<th>전공</th>
			<td>${info.department}</td>
		</tr>
		<tr>
			<th>전화번호</th>
			<td>${info.phone}</td>
		</tr>
		<tr>
			<th>이메일</th>
			<td>${info.email}</td>
		</tr>
		<tr>
			<th>생년월일</th>
			<td>${info.birth}</td>
		</tr>
		<tr>
			<th>주소</th>
			<td>${info.address}</td>
		</tr>
		<tr>
			<th>재학여부</th>
			<td><c:choose>
					<c:when test='${info.status=="1"}'>재학생</c:when>
					<c:when test='${info.status=="2"}'>졸업생</c:when>
					<c:otherwise>교직원</c:otherwise>
				</c:choose></td>
		</tr>

		<br>
		<tr align="center">
			<td></td>
			<td><input type="button" value="수 정"
				onclick="location.href='UserServlet?command=student_update_form&id=${info.id}'">
				<input type="button" value="삭 제"
				onclick="location.href='UserServlet?command=student_delete&id=${info.id}'">
				<input type="button" value="돌아가기"
				onclick="location.href='UserServlet?command=student_list'"></td>
		<tr>
	</table>
</body>

</html>