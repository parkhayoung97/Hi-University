<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
 <link rel="stylesheet" type="text/css" href="css/shopping.css">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="../base/userHeader.jsp"/>
	<div id="wrap" align="center">

		<h1>마이페이지 수정</h1>
		<form action="UserServlet" method="post" name="frm">
			<input type="hidden" name="command" value="update_info">
			<table>
				<tr>
					<th>학번</th>
					<td><input type="text" size="12" name="student_ID"
						value="${info.id}" readonly></td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="password" size="12" name="pwd"
						value="${info.pwd}">*필수</td>
				</tr>
				<tr>
					<th>이름</th>
					<td><input size="12" name="name" value="${info.name}" readonly></td>
				</tr>
				<tr>
					<th>전공</th>
					<td><input size="12" name="department"
						value="${info.department}" readonly></td>
				</tr>
				<tr>
					<th>전화번호</th>
					<td><input type="text" size="15" name="phone"
						value="${info.phone}"></td>
				</tr>
				<tr>
					<th>이메일</th>
					<td><input type="text" size="25" maxlength="50" name="email"
						value="${info.email}"></td>
				</tr>
				<tr>
					<th>생년월일</th>
					<td><input size="20" name="birth" value="${info.birth}" readonly></td>
				</tr>
				<tr>
					<th>주소</th>
					<td><input type="text" size="60" name="address"
						value="${info.address}"></td>
				</tr>
			</table>
			<br> <br> <input type="submit" value="등록">
			&nbsp;&nbsp;
			<input type="reset" value="다시 작성">
		</form>
	</div>
	<jsp:include page="../base/footer.jsp"/>

</body>
</html>