<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="script/user.js"></script>
</head> 
<body>
	<jsp:include page="../base/userHeader.jsp" />
	<!-- 별명 설정 페이지 -->
	<h2>별명 설정</h2>
	<!-- NickAction -->
	<form method="post" name="frm" action="UserServlet">
		<input type="hidden" name="command" value="nick">
		별명 <input type="text" name="nickname">
		<input type="hidden" name="re">
		<input type="button" value="중복체크" onclick="nickCheck()">
		<input type="submit" value="등록" onclick="return reCheck()">
	</form>
	<jsp:include page="../base/footer.jsp" />
</body>
</html>