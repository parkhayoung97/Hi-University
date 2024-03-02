<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Bootstrap demo</title>
<script type="text/javascript" src="script/board.js"></script>
</head>
<body>
	<!-- 게시글 수정 폼 페이지 -->
	<jsp:include page="../base/boardHeader.jsp"/>
	<div align="center">
		<br>
		<form name="frm" method="post" action="boardServlet"  enctype="multipart/form-data">
			<table class="table" style="width: 70%">
				<thead>
					<tr>
						<th colspan="2" class="table-primary" style="font-size: 20px">새 글 작성하기</th>
					</tr>
				</thead>
				<tr>
					<th>제목</th>
					<td><input type="text" name="title" value="${boardOne.title }"> *필수 입력</td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="password" name="pass"> *필수 입력(수정/삭제 시 사용)</td>
				</tr>
				<tr>
					<th>내용</th>
					<td><textarea cols="90" rows="20" name="content">${boardOne.content }</textarea></td>
				</tr>
				<tr>	
					<th>파일</th>
					<td><input type="file" name="filename" value="${boardOne.filename }"></td>
				</tr>
				<tr>
				<td colspan="2" style="border:white; text-align: right">
					<input type="button" class="btn btn-primary" value="게시글 등록" onclick="updateCheck('${boardOne.seq }','${param.type }')">
					<input type="reset" class="btn btn-danger" value="취소">
					<!-- BoardViewAction -->
					<a href="BoardServlet?command=board_view&type=${param.type }&seq=${boardOne.seq }"><input type="button" value="목록"></a>
				</td>
				</tr>
			</table>
		</form>
	</div>
	
	<jsp:include page="../base/footer.jsp"/>
</body>
</html>