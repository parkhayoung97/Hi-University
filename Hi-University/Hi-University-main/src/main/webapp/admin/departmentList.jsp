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
	<div id="wrap">
	<c:forEach var="dept" items="${list }">
		<table>
			<tr>
				<td>${dept.college }</td>
				<td>${dept.department }</td>
			</tr>
		</table>
	</c:forEach>
	</div>
	
		<button>학과 추가</button>
		
	<jsp:include page="../base/footer.jsp"/>

</body>
</html>