<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<jsp:include page="../base/adminHeader.jsp" />

	<div align="center">
		<form action="SubjectServlet" name="frm" method="post">
			<input type="hidden" name="command" value="grade_insert">

			<h1>게시글 리스트</h1>
			<table>
				<tr>
					<th>학번</th>
					<th>학생명</th>
					<th>성적 점수</th>
					<th>성적</th>
				</tr>

				<c:forEach var="grade" items="${first}">
					<input type="hidden" name="id" value="${grade.id}">
					<input type="hidden" name="subjectNum" value="${grade.subjectNum}">
					<tr class="record">

						<td>${grade.id}</td>
						<td>${grade.name}</td>
						<td><input type="text" name="gradeScore"></td>
						<td><select name="grade">
							<option value="A">A</option>
							<option value="B">B</option>
							<option value="C">C</option>
							<option value="D">D</option>
							<option value="F">F</option>
						</select></td>
					</tr>
				</c:forEach>
					<tr>
						<td><input type="submit" value="성적 수정"></td>
					</tr>
			</table>
		</form>
	</div>

	<jsp:include page="../base/footer.jsp" />


</body>
</html>