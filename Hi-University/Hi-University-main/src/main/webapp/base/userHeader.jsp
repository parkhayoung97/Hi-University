<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/form2.css">
<script src="https://code.jquery.com/jquery-1.12.0.min.js"></script>
</head>
<body>
	<header id="mainHeader">
		<h1 class="header1">
			<img alt=""> Hi University
		</h1>
	</header>

		<nav id="mainNav">
			<ul>
				<li style="margin-left: 400px"><a href="https://www.snu.ac.kr/">학교 홈페이지</a></li>
				<li><a href="UserServlet?command=user_main">학사</a></li>
				<li><a href="BoardServlet?command=board_main">커뮤니티</a></li>
				<li><a href="UserServlet?command=logout">로그아웃</a></li>
			</ul>
		</nav>
		<!-- 사이드 바 -->
		<aside id="sidebar">
			<h2>내 정보</h2>
			<div id="box1">
				<li class="main1_1">개인정보
					<ul class="sub1_1" style="display: none">
						<li><a href="UserServlet?command=user_info">개인정보조회</a></li>
						<li><a href="UserServlet?command=update_info_form">개인정보수정</a></li>
						<li><a href="#">학생증조회</a></li>
					</ul>
				</li>
			</div>
			<script>
				$(".main1_1").css("cursor", "pointer").click(function() {
					if ($(".sub1_1").is(":visible")) {
						$(".sub1_1").slideUp();
					} else {
						$(".sub1_1").slideDown();
					}
				})
			</script>
			<br>

			<div id="box1">
				<li class="main1_3">수강
					<ul class="sub1_3" style="display: none">
						<c:if test="${sessionScope.status == 1 }">
							<li><a href="SubjectServlet?command=subject_list_form">수강신청</a></li>
						</c:if>
						<li><a href="SubjectServlet?command=user_table">나의 강의실</a></li>
						<li><a href="SubjectServlet?command=time_table">학사 시간표</a></li>
					</ul>
				</li>
			</div>
			<script>
				$(".main1_3").css("cursor", "pointer").click(function() {
					if ($(".sub1_3").is(":visible")) {
						$(".sub1_3").slideUp();
					} else {
						$(".sub1_3").slideDown();
					}
				})
			</script>
			<br>

			<div id="box1">
				<li class="main1_4">성적
					<ul class="sub1_4" style="display: none">
						<li><a href="SubjectServlet?command=student_grade">성적조회</a></li>
					</ul>
				</li>
			</div>
			<script>
				$(".main1_4").css("cursor", "pointer").click(function() {
					if ($(".sub1_4").is(":visible")) {
						$(".sub1_4").slideUp();
					} else {
						$(".sub1_4").slideDown();
					}
				})
			</script>
		</aside>
		<div id="container">

</body>
</html>