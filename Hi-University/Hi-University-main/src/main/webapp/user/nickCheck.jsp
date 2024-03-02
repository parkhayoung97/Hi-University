<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="script/user.js"></script>
</head>
<body>
	<!-- 별명 중복 체크 새 창 -->
	<h2>별명 중복 체크</h2>
	<!-- NickCheckAction -->
	<form action="UserServlet" method="get" name="frm">
		<input type="hidden" name="command" value="nick_check">
		별명 <input type="text" name="nickname" value=${nickname }>
		<input type="submit" value="중복 체크"><br>
		<c:if test="${result == 1 }">
			<script type="text/javascript">
				opener.document.frm.nickname.value = "";
			</script>
			${nickname }은 이미 사용중인 별명입니다.
		</c:if>
		<c:if test="${result == -1 }">
			<!-- 적용하고 새 창 닫기 -->
			${nickname }은 사용 가능한 별명입니다.
			<input type="button" value="사용" onclick="nickOk('${nickname }')">
		</c:if>
	</form>
</body>
</html>