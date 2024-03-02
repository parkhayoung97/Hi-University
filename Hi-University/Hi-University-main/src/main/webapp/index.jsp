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

	<!-- 아이디 세션 체크 -->
	<c:choose>
		<c:when test="${empty sessionScope.id }">
			<% response.sendRedirect("UserServlet?command=login_form"); %>	
		</c:when>
		<c:otherwise>
			<% response.sendRedirect("UserServlet?command=user_main"); %>
		</c:otherwise>
	</c:choose>
	
	

</body>
</html>