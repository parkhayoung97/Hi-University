<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.table table-striped {
	width: 600px;
	border: 1px solid silver;
	border-collapse: collapse;
	text-align: left;
	position: relative;
}

th, td {
	border-bottom: 1px solid silver;
	padding: 20px;
	text-align: left;
}

.table table-bordered {
	position: relative;
}
</style>

<script type="text/javascript" src="script/board.js"></script>
</head>

<body>
	<!-- 게시글 상세 조회 페이지 -->
	<jsp:include page="../base/boardHeader.jsp" />
	<div align="center">


				<!-- BoardListAction -->
				<c:choose>
					<c:when test="${command == 'board_view_my' }">
						<td><a
							href="BoardServlet?command=my_page&id=${sessionScope.id }">&lt;&lt;뒤로가기</a></td>
					</c:when>
					<c:otherwise>
						<td><a
							href="BoardServlet?command=board_list&type=${param.type }&tpage=1">&lt;&lt;뒤로가기</a></td>
					</c:otherwise>
				</c:choose>


	</div>

	<br>
	<table class="table table-striped" style="margin: auto;">

		<thead>
			<tr style="font-size: 26px;">
				<th>${boardOne.title }</th>
			</tr>
		</thead>

		<tbody>
			<tr>
				<td>작성자 : ${boardOne.nickname }</td>
			</tr>

			<tr>
				<td height="200px;">${boardOne.content }</td>
			</tr>
			<tr>
				<td><c:if test="${!empty boardOne.filename}">
						<img src="/test2/file/${boardOne.filename }">
					</c:if></td>
			</tr>
		</tbody>


		<!-- 자신의 글일때 -->
		<c:if test="${check == 1 }">
			<tr>
				<!-- 수정/삭제 버튼 -->
				<!-- BoardCheckPassFormAction -->
				<td><input type="button" value="수정"
					onclick="open_win('BoardServlet?command=board_check_pass_form&type=${param.type }&seq=${boardOne.seq}', 'update')">
					<input type="button" value="삭제"
					onclick="open_win('BoardServlet?command=board_check_pass_form&type=${param.type }&seq=${boardOne.seq}', 'delete')"></td>
			</tr>
		</c:if>
	</table>

	<!-- 댓글 입력 -->
	<c:if test="${sessionScope.status != 3 }">
		<form method="post" action="BoardServlet" name="frm">
			<input type="hidden" name="command" value="comment_write"> <input
				type="hidden" name="board_seq" value="${param.seq }"> <input
				type="hidden" name="board_type" value="${param.type }">
			<table class="table table-bordered"  style="margin: auto;">
				<tr>
					<td>
						<div>
							<div>
								<input class="form-control input-lg" type="text"
									placeholder="댓글쓰기" name="comment" style="width:600px; height: 50px;">
							</div>
							<div>
								<input type="submit" value="입력" onclick="return commentCheck()">
							</div>
						</div>
					</td>
				</tr>
			</table>
		</form>
	</c:if>

	<!-- 댓글 -->
	<div>
		<div>
			<c:forEach var="comment" items="${comments }">
				<table style="margin:auto; width:700px;">
					<tr>
						<td>${comment.nickname }<br> ${comment.writedate }
						</td>
						<div class="col-2">
							<td colspan="2">${comment.content }<br> <c:if
									test="${comment.id == sessionScope.id  }">
									<a onclick="return confirm('삭제하시겠습니까?')"
										href="BoardServlet?command=comment_delete&board_type=${param.type }&board_seq=${param.seq }&seq=${comment.comment_seq }"><button>삭제</button></a></td>
							</c:if>
							<c:if test="${sessionScope.status == 3 }">
								<a onclick="return confirm('삭제하시겠습니까?')"
									href="BoardServlet?command=comment_delete&board_type=${param.type }&board_seq=${param.seq }&seq=${comment.comment_seq }"><button>삭제</button></a>
								</td>
							</c:if>
						</div>
					</tr>
				</table>
			</c:forEach>
		</div>
	</div>
	<jsp:include page="../base/footer.jsp" />
</body>
</html>