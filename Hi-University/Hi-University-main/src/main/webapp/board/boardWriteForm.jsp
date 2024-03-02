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
	<!-- 게시글 작성 페이지 -->
	<jsp:include page="../base/boardHeader.jsp"/>
	<div align="center">
		<br>
		<form name="frm" method="post" action="boardServlet"  enctype="multipart/form-data">		
			<table>
				<thead>
					<tr>
						<th colspan="2" style="font-size: 20px">새 글 작성하기</th>
					</tr>
				</thead>
				<tr>
					<th>제목</th>
					<td><input type="text" name="title"> *필수 입력</td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="password" name="pass"> *4자리 필수 입력(수정/삭제 시 사용)</td>
				</tr>
				<tr>
					<th>내용</th>
					<td><textarea cols="90" rows="20" name="content"></textarea></td>
				</tr>
				<tr>	
					<th>파일</th>
					<td><input type="file" name="filename"></td>
				</tr>
				<tr>	
					<td colspan="2"><input type="checkbox" name="anony" value="익명"> 익명</td>
				</tr>
				<tr>
				<td colspan="2" style="border:white; text-align: right">
					<input type="button" class="btn btn-primary" value="게시글 등록" onclick="writeCheck('${param.type}')">
					<input type="reset" class="btn btn-danger" value="취소">
					<!-- BoardListAction -->
					<a href="BoardServlet?command=board_list&type=${param.type }&tpage=1"><input type="button" value="목록"></a>
				</td>
				</tr>
			</table>
		</form>
	</div>
	<jsp:include page="../base/footer.jsp"/>
</body>
</html>