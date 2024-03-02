<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>커뮤니티 메인</title>
<style type="text/css">
.board1{
border: 1px solid silver;
margin: 20px;
width: 480px;
height: 300px;
padding: 20px;
position: relative;
top: -85px;
}
.board2{
border: 1px solid silver;
margin: 20px;
width: 480px;
height: 300px;
padding: 20px;
position: relative;
top: -450px;
left: 550px;
}
.board3{
border: 1px solid silver;
margin: 20px;
width: 480px;
height: 150px;
padding: 20px;
position: relative;
top: -446px;
}
.board4{
border: 1px solid silver;
margin: 20px;
width: 480px;
height: 150px;
padding: 20px;
position: relative;
left: 550px;
top: -658px;
}
.mypage{
border: 1px solid silver;
font-size: 20px;
font-weight: bold;
position: relative;
left: 1173px;
top: -110px;
width: 200px;
height: 30px;
text-align: center;
padding: 20px;
}
a:visited {
   color: black;
}
#sidebar1{
float: right;
position: relative;
margin-right: 50px;
top: -1240px;
}
#side{
float: right;
position: relative;
margin-right: 255px;
top: -440px;
border: 1px solid silver;
}

</style>

</head>
<body>

	<jsp:include page="../base/boardHeader.jsp"/>

		<div>
         <a href="https://www.youtube.com/watch?v=Gjn6UEpSuB0"><img
            src="board/hiu1.png" style="height: 100px; width: 600px; margin: 30px; ">
         </a>
      </div>

	<div class="mypage">
		<c:if test="${sessionScope.status != 3 }">
			<a href="BoardServlet?command=my_page">마이페이지</a>
		</c:if>
	</div>

	<div>		
		<div class="board1">			
			<!-- BoardListAction -->
			<!-- 자유 게시판 -->
			<h2><a href="BoardServlet?command=board_list&type=1&tpage=1"
				style="text-decoration: none; color: rgba(50,128,50);">자유 게시판</a></h2><hr>
			<table>
				<c:forEach var="freeList" items="${free }">
					<tr>
						<!-- BoardViewAction -->
						<td
							onclick="location.href='BoardServlet?command=board_view&type=1&seq=${freeList.seq}'"
							style="cursor: pointer">
							<div style="font-size: 16px">${freeList.title }</div>
							<div style="font-size: 14px; color: gray;">${freeList.writedate }
								| ${freeList.nickname }</div>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		
		<div class="board2">
			<!-- 익명 게시판 -->
			<h2><a href="BoardServlet?command=board_list&type=2&tpage=1"
				style="text-decoration: none; color: rgba(50,128,50);">익명 게시판</a></h2><hr>

			<table>
				<c:forEach var="anonyList" items="${anony }">
					<tr>
						<td
							onclick="location.href='BoardServlet?command=board_view&type=2&seq=${anonyList.seq}'"
							style="cursor: pointer">
							<div style="font-size: 16px">${anonyList.title }</div>
							<div style="font-size: 14px; color: gray">${anonyList.writedate }
								| (익명) </div>
						</td>
					</tr>

				</c:forEach>
			</table>
		</div>

		<div class="board3">
			<!-- 강의정보 -->
			<h2><a href="BoardServlet?command=eval_list"
				style="text-decoration: none; color: rgba(50,128,50);">강의 정보</a></h2><hr>
			<p>강의 정보 게시판</p>
		</div>

		<div class="board4">
			<!-- 강의평가 -->
			<h2><a href="BoardServlet?command=comment" 
				style="text-decoration: none; color: rgba(50,128,50);">강의 평가</a></h2><hr>
			<p>강의 평가 게시판</p>
		</div>
	</div>

	<div id="sidebar1">
		<h3>학사일정</h3>
		<iframe
			src="https://calendar.google.com/calendar/embed?src=402bddf1222ce219e23563fb03fb67583b67a94fbfcd5eef9b3683894b3d9614%40group.calendar.google.com&ctz=Asia%2FSeoul"
			style="border: solid 1px #777" width="250" height="350"
			frameborder="0" scrolling="no"></iframe>
	</div>
	<div>
		<jsp:include page="../base/footer.jsp"/>
	</div>

	<div id="side">
		<a href="https://people.snu.ac.kr/?vol=71/">
		<img src="board/hiu2.png" style="height: 140px; width: 250px;"></a>
	</div>

</body>
</html>