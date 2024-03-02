<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
  <link rel="stylesheet" type="text/css" href="css/shopping.css">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="../base/adminHeader.jsp" />
	<h1 align="center">게시글 리스트</h1>
<div align="center" style="height:750px; overflow: auto">
		
		<table class="list" style="width: 800px">
			<tr>
				<th>대학</th>
				<th>학과</th>
				<th>과목코드</th>
				<th>과목명</th>
				<th></th>
			</tr>
			<c:forEach var="subject" items="${subjectList}">
				<tr class="record">
					<td>${subject.college}</td>
					<td>${subject.department}</td>
					<td>${subject.subjectNum}</td>
					<td>${subject.subject}</td>
					<td><button onclick="location.href='SubjectServlet?command=grade_subject_view&subjectNum=${subject.subjectNum}'">성적조회</button>
				</tr>
			</c:forEach>
		</table>
	</div>
	<jsp:include page="../base/footer.jsp" />
</body>
</html>