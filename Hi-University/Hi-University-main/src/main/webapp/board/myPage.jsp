<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.my{
width: 1080px;
border: 1px solid green;
border-collapse: collapse;

}
th, td{
border: 1px solid gray;
padding: 10px;
}
a:visited {
   color: green;
}

</style>

</head>
<body>

	<jsp:include page="../base/boardHeader.jsp"/>
	<h1>mypage</h1>
	<table class="my" style="align: center;"><thead>
   <tr><th>별명</th><th>내가 쓴 글</th><th>-</th>
   </tr>
   
   </thead>
   <tbody>
   <tr align="center">
   <td><br>${sessionScope.nickname }<br><br>
   <button onclick="location.href='#'">별명 변경하기</button></td>

	<!-- 내가 쓴 게시글 -->
	<td><br>
	<a href="BoardServlet?command=board_list&type=1&tpage=1">내가 쓴 게시글</a>
		<table>
		<c:forEach var="board" items="${list }">
			<tr>
				<!-- BoardViewAction -->
				<td
					onclick="location.href='BoardServlet?command=board_view_my&type=${board.type }&seq=${board.seq}'"
					style="cursor: pointer; width: 300px;">
					<div style="font-size: 20px">${board.title }</div>
					<div style="font-size: 15px; color: gray">${board.content }</div>
					<c:if test="${board.type == 1 }">
						<div>자유 게시판</div>
					</c:if>
					<c:if test="${board.type == 2 }">
						<div>익명 게시판</div>
					</c:if>
					${board.writedate } | ${board.nickname }
				</td>
			</tr>
		</c:forEach>
	</table><br><br>
	<button>전체 보기<br></button></td>
	
	<!-- 내가 쓴 강의평가 -->
	<td><a href="BoardServlet?command=comment" style="font-size: 20px; font-weight: bold;">강의평가</a>
	</td>
   </tr></tbody></table>
		
	<!-- 내가 쓴 댓글 -->
	
	<jsp:include page="../base/footer.jsp"/>
</body>
</html>