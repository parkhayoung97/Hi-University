<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="script/board.js"></script>
</head>
<body>
	<!-- 글 수정/삭제 비밀번호 체크 페이지 -->
		<h1>비밀번호 확인</h1>
		<!-- BoardCheckPassAction -->
		<form action="BoardServlet" name="frm" method="get">
			<input type="hidden" name="command" value="board_check_pass">
			<input type="hidden" name="type" value="${param.type }">
			<input type="hidden" name="seq" value="${param.seq }">
			<table>
				<tr>
					<th>비밀번호</th>
					<td><input type="password" name="pass" size="20"></td>
				</tr>
			</table>
			<br>
			<input type="submit" value="확인" onclick="return passCheck()">
			<br><br>${message }			
		</form>

</body>
</html>