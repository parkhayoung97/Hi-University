<%@page import="com.board.dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>커뮤니티메인</title>
<script type="text/javascript" src="script/board.js"></script>

</head>
<body>
	<jsp:include page="../base/boardHeader.jsp"/>
	
		<div align="center" style="margin-bottom: 20px;">
      	<table style="margin-top: 20px; border-collapse: collapse; width: 800px;">

			<thead>
				<tr>
					<c:if test="${param.type == 1 }">
					<th style="font-size: 30px" colspan="2" align="left">자유게시판</th>
					</c:if>
					<c:if test="${param.type == 2 }">
					<th style="font-size: 30px" colspan="2" align="left">익명게시판</th>
					</c:if>
				</tr>
				<c:if test="${sessionScope.status != 3 }">
				<!-- 게시글 작성 페이지 이동 -->
				<tr>
					<td colspan="2"><input type="text" class="form-control"
						placeholder="새 글 작성하기" readonly
						onclick="location.href='BoardServlet?command=board_write_form&type=${param.type}'"
						style="cursor: pointer;"></td>
				</tr>
				</c:if>
			</thead>
			
			<c:choose>
				<c:when test="${empty list }">
				<tr><td><div style="font-size: 20px">게시글 없음</div></td></tr>
				</c:when>
				<c:otherwise>
			<!-- 게시글 목록 -->
			<c:forEach var="boardList" items="${list }">
				<tr>
					<td
						onclick="location.href='BoardServlet?command=board_view&type=${param.type }&seq=${boardList.seq}'"
						style="cursor: pointer; text-align: left; border: 1px solid silver; padding:20px;">
						<div style="font-size: 20px; font-weight: 600;">${boardList.title }</div>
						<div style="font-size: 15px; color: gray">${boardList.content }</div>
						${boardList.writedate } | ${boardList.nickname }
					</td>
					<c:if test="${sessionScope.status == '3' }">
						<td>
							<button onclick="location.href='BoardServlet?command=board_delete&type=${param.type }&seq=${boardList.seq}&tpage=1'">삭제</button>
						</td>
					</c:if>
				</tr>
			</c:forEach>
			</c:otherwise>
			</c:choose>
		</table></div>

		<!-- 페이지 --> 
		<jsp:include page="../page/pageCount.jsp"/>

		<div align="center" style="margin-top: 20px;">
		<!-- 게시글 검색 -->
		<!-- BoardSearchAction -->
		<form name="frm" method="post" action="boardServlet">
			<input type="hidden" name="type" value="${param.type }">
			<table>
				<tr>
					<td><select name="searchType" required>
						<c:choose>
							<c:when test="${searchType == 'title' }">
							<option value="">선택</option>
							<option value="title" selected>제목</option>
							<option value="nickname">작성자</option>
							</c:when>
							<c:when test="${searchType == 'nickname' }">
							<option value="">선택</option>
							<option value="title">제목</option>
							<option value="nickname" selected>작성자</option>
							</c:when>
							<c:otherwise>
							<option value="" selected>선택</option>
							<option value="title">제목</option>
							<option value="nickname">작성자</option>
							</c:otherwise>
						</c:choose>			
					</select></td>
					
					<td><input type="text"
						placeholder="검색어 입력" name="sear" maxlength="100" value="${search }"></td>
					<td><input type="submit" value="검색" onclick=" search('${param.type}')"></td>
				</tr>
			</table>
		</form>
		</div>
		<jsp:include page="../base/footer.jsp"/>
</body>
</html>