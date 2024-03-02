<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="script/board.js"></script>
</head>
<body>
	<jsp:include page="../base/adminHeader.jsp" />
	
	<div align="center">
		<form action="SubjectServlet" name="frm" method="post">
			<input type="hidden" name="command" value="grade_update">

			<h1>게시글 리스트</h1>
			<table>
				<tr>
					<th>학번</th>
					<th>학생명</th>
					<th>성적 점수</th>
					<th>성적</th>
					<th>성적 점수입력</th>
				</tr>

				<c:forEach var="grade" items="${idList}">
					<input type="hidden" name="student_id" value="${grade.id}">
					<input type="hidden" name="subjectNum" value="${grade.subjectNum}">
					<tr class="record">

						<td>${grade.id}</td>
						<td>${grade.name}</td>
						<td>${grade.grade}</td>
						<td>${grade.grade_score}</td>
						<td><button>성적 수정</button></td>
					</tr>
				</c:forEach>
			</table>
		</form>
	</div>
	
	<jsp:include page="../base/footer.jsp" />
</body>
</html>