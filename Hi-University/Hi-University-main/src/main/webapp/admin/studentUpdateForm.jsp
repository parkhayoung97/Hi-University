<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<jsp:include page="../base/adminHeader.jsp"/>
				<h1 style="color: olive;">학생 정보 수정</h1>
				<form action="UserServlet" name="frm" method="post">
					<input type="hidden" name="command" value="student_update">
					<table style="width: 300px">
						<tr>
							<th>학번</th>
							<td><input type="text" name="student_id" value="${info.id}" readonly></td>
						</tr>
						<tr>
							<th>비밀번호</th>
							<td><input type="text" name="pwd" value="${info.pwd}"></td>
						</tr>
						<tr>
							<th>이름</th>
							<td><input type="text" name="name" value="${info.name}"></td>
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
							<td><input type="text" name="phone" value="${info.phone}"></td>
						</tr>
						<tr>
							<th>이메일</th>
							<td><input type="email" name="email" value="${info.email}"></td>
						</tr>
						<tr>
							<th>생년월일</th>
							<td><input type="text" name="birth" value="${info.birth}"></td>
						</tr>
						<tr>
							<th>주소</th>
							<td><input type="text" name="address" value="${info.address}"></td>
						</tr>
						<tr>
							<th>재학여부</th>
							<td>					
							<select name="status">
								<c:if test="${info.status == '1' }">
								<option value="1" selected>재학생</option>
								<option value="2">졸업생</option>
								</c:if>
								<c:if test="${info.status == '2' }">
								<option value="1">재학생</option>
								<option value="2" selected>졸업생</option>
								</c:if>
							</select>
							</td>
						</tr>
					</table>
				<br><br>
				<input type="submit" value="등 록" onclick="return InfoCheck()">
				<input type="reset" value="취 소">
				<input type="button" value="돌아가기" onclick="location.href='UserServlet?command=student_view&id=${info.id}'">
				</form>
	<jsp:include page="../base/footer.jsp"/>

</body>
</html>