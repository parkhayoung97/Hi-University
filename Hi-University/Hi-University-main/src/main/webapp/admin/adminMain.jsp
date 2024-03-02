<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width">
<title>Main Form</title>
</head>
<body>
	<jsp:include page="../base/adminHeader.jsp"/>

	<h1>관리자 페이지</h1>
	<h2>공지사항</h2>
	<article>
		<h3>교직원 연수</h3>
		<p>교직원 연수시간 : 23/04/20~23/04/22</p>
		<h3>교직원 특강</h3>
		<p>교직원 특강시간 : 23/04/24~23/04/27</p>
	</article>

	<jsp:include page="../base/footer.jsp"/>
</body>
</html>