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

	<jsp:include page="../base/userHeader.jsp"/>
	학번 : ${sessionScope.id }
	<table>
		<tr>
			<th>학과</th>
			<th>강의번호</th>
			<th>강의</th>
			<th>점수</th>
			<th>등급</th>
		</tr>
	<c:forEach var="user" items="${list }">
		<tr>
			<td>${user.department }</td>
			<td>${user.subjectNum }</td>
			<td>${user.subject }</td>
			<td>${user.grade }</td>
			<td>${user.grade_score }</td>
		</tr>
	</c:forEach>
	</table>
	<jsp:include page="../base/footer.jsp"/>

</body>
</html>