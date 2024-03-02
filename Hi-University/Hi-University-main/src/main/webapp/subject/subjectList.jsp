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
	<h1 align="center">게시글 리스트</h1>
	<div align="center" style="height:750px; overflow: auto">
		
		<table class="list" style="width: 1000px">
			<tr>
				<th>대학</th>
				<th>학과</th>
				<th>과목코드</th>
				<th>과목명</th>
				<th>학년</th>
				<th>시간</th>
				<th></th>
			</tr>
			<c:forEach var="subject" items="${subjectList}">
				<tr class="record">
					<td>${subject.college}</td>
					<td>${subject.department}</td>
					<td>${subject.subjectNum}</td>
					<td>${subject.subject}</td>
					<td>${subject.score }</td>
					<td>${subject.day1 }, ${subject.day2 }, ${subject.time1 }, ${subject.time2 }</td>
					<c:if test="${check == 'subject' }">
					<td><button onclick="location.href='SubjectServlet?command=update_subject&subjectNum=${subject.subjectNum}'">과목 수정</button>
						<button onclick="location.href='SubjectServlet?command=delete_subject&subjectNum=${subject.subjectNum}'">과목 삭제</button>
					</td>
					</c:if>
					<c:if test="${check == 'grade' }">
					<td>
					<button onclick="location.href='SubjectServlet?command=first_grade_student_list&subjectNum=${subject.subjectNum}'">성적 등록</button>
					</td>
					</c:if>
				</tr>
			</c:forEach>
		</table>
	</div>
	<jsp:include page="../base/footer.jsp" />

</body>
</html>