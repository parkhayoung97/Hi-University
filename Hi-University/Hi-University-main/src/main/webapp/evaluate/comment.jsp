<%@page import="javax.print.attribute.HashPrintRequestAttributeSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="http://code.jquery.com/jquery-3.5.1.js"
	integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
	crossorigin="anonymous"></script>
<title>강의평가</title>
</head>
<body>
	<jsp:include page="../base/boardHeader.jsp" />
	
	<div align="center">
		<table>
			<thead>
				<tr>
					<th style="font-size: 20px" colspan="5">&nbsp;강의평가</th>
				</tr>

				<tr>
					<td><select name="searchField">
							<option value="subject">강의명</option>
							<option value="professor">내용</option>
					</select></td>
					<td><input type="text"
						placeholder="검색어 입력" name="search" maxlength="40"></td>
					<td><button type="submit">검색</button>
						<c:if test="${sessionScope.status != 3 }">
							<input type="button" value="글쓰기" onclick="location.href='BoardServlet?command=cmt_write_form'">
						</c:if></td>
				</tr>
			</thead>
		</table>
	</div>

	<c:forEach var="comment" items="${cmtlist}">
           ${comment.id }
           ${sessionScope.id }
		<div>
			<div>
				<div>
					<div>
						<div>${comment.subject}</div>
						<input type="hidden" name="subject" value="${comment.subject}">
						
						<div>
							종합 <span style="color: red;">${comment.totalScore}</span>
						</div>
					</div>
				</div>

				<div>
					<p>${comment.content}</p>
					
					<div>
						<div>
							성적 <span style="color: red;">${comment.score}</span> 강의 <span
								style="color: red;">${comment.lectureScore}</span>
						</div>

						<div>
							<br> <br>
							<c:choose>
								<c:when test="${sessionScope.status == 3 }">
									<a onclick="return confirm('삭제하시겠습니까?')"
										href="BoardServlet?command=cmt_delete&num=${comment.num}">삭제</a>
								</c:when>
								<c:otherwise>
									<c:if test="${comment.id == sessionScope.id }">
										<a href="BoardServlet?command=cmt_update_form&num=${comment.num}">수정</a>
										<a onclick="return confirm('삭제하시겠습니까?')"
											href="BoardServlet?command=cmt_delete&num=${comment.num}">삭제</a>
									</c:if>
								</c:otherwise>
							</c:choose>
						</div>
					</div>
				</div>
			</div>
		</div>
	</c:forEach>

	<jsp:include page="../base/footer.jsp" />

</body>

</html>