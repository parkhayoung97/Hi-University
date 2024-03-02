<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="script/user.js"></script>
</head>
<body>
	<jsp:include page="../base/adminHeader.jsp"/>
	<div align="center">
				<h1 style="color: olive;">학생 정보 등록</h1>
				<form action="UserServlet" name="frm">
					<input type="hidden" name="command" value="student_insert">
					<table style="width: 500px">
						<tr>
							<th>학번</th>
							<td><input type="text" name="student_id" size="40"></td>
						</tr>
						<tr>
							<th>비밀번호</th>
							<td><input type="password" name="pwd" size="40"></td>
						</tr>
						<tr>
							<th>이름</th>
							<td><input type="text" name="name" size="40"></td>
						</tr>
						<tr>
							<th>전공</th>
							<td>
							<select name="department">
							<c:forEach var="dept" items="${list }">								
									<option value="${dept.department }">${dept.department }</option>
							</c:forEach>
							</select>
							</td>
						</tr>
						<tr>
							<th>전화번호</th>
							<td><input type="text" name="phone" size="40"></td>
						</tr>
						<tr>
							<th>이메일</th>
							<td><input type="email" name="email" size="40"></td>
						</tr>
						<tr>
							<th>생년월일</th>
							<td><input type="text" name="birth" size="40"></td>
						</tr>
						<tr>
							<th>주소</th>
							<td><input type="text" name="address" size="40"></td>
						</tr>
						<tr>
							<th>재학여부</th>
							<td><select name="status">
									<option value="1">재학생</option>
									<option value="2">졸업생</option>
									<option value="3">교직원</option>
							</select></td>
						</tr>
					</table>
				<br><br>
				<input type="submit" value="등 록" onclick="return InfoCheck()">
				<input type="reset" value="취 소">
				</form>
			</div>
	<jsp:include page="../base/footer.jsp"/>
</body>
</html>