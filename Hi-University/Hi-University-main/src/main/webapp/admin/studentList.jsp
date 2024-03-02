<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <link rel="stylesheet" type="text/css" href="css/shopping.css">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<jsp:include page="../base/adminHeader.jsp" />
				<h1 align="center">학생 정보 리스트</h1>
				<div align="center" style="height:750px; overflow: auto">
				<table class="table" border="1" align= "center" >
					<tr class="record" align="center">
						<th>학번</th>
						<th>이름</th>
						<th>전공</th>
						<th>재학여부</th>
					</tr>
					<c:forEach items="${iList}" var="info">
						<tr class="record" align="center">
							<td><a href="UserServlet?command=student_view&id=${info.id}">${info.id}</a></td>
							<td>${info.name}</td>
							<td>${info.department}</td>
							<td>
								<c:choose>
									<c:when test="${info.status=='1'}">재학생</c:when>
									<c:when test="${info.status=='2'}">졸업생</c:when>
									<c:otherwise>교직원</c:otherwise>
								</c:choose>
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
	<jsp:include page="../base/footer.jsp" />
</body>
</html>