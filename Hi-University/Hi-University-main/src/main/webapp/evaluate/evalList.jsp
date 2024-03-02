<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>강의정보</title>
<style type="text/css">
details summary::marker {
	font-size: 0;
}
</style>

</head>
<body>
	<jsp:include page="../base/boardHeader.jsp" />
	<div align="center">
		<form method="post" action="BoardServlet">
			<table>
				<thead>
					<tr>
						<th style="font-size: 20px" colspan="5">강의정보</th>
					</tr>
					<tr>
						<td><select name="searchField">
								<option value="subject">강의명</option>
								<option value="professor">교수명</option>
						</select></td>
						<td><input type="text" placeholder="검색어 입력" name="search"
							maxlength="40"></td>
						<td><input type="submit" value="검색"> <input
							type="button" value="글쓰기"
							onclick="location.href='BoardServlet?command=cmt_write'">
						</td>
					</tr>
				</thead>
			</table>
		</form>
	</div>

	<table>
		<c:forEach var="evalList" items="${evalList}" varStatus="status">
			<div align="left"
				style="border: 1px solid silver; padding-left: 20px; margin-top: 20px;">
				<div id="accordionExample">
					<details>
						<summary>
							<h2>
								<div style="font-size: 20px">${evalList.subject}</div>
								&nbsp;<br> <br>
								<div style="font-size: 15px; color: gray">${evalList.professor}
									교수</div>
							</h2>
						</summary>
						<ul>
							<div align="left">
								<textarea cols="60" rows="7" disabled>${evalList.content}</textarea>
								<br> <br>
							</div>
						</ul>
					</details>
				</div>
			</div>
			
		</c:forEach>
	</table>
	<jsp:include page="../base/footer.jsp" />
</body>
</html>