<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/form.css">
</head>
<body>

	<div id="container">
		<!-- 상단 내비게이션 -->
		
		<nav id="mainNav">
			<ul>
				<li style="margin-left: -230px"><header id="mainHeader">
						<h1 class="header1">
							<img alt=""> Hi University
						</h1>
					</header></li>
				<li style="margin-left: 400px"><a href="https://www.snu.ac.kr/">학교 홈페이지</a></li>
				<li><a href="UserServlet?command=user_main">학사</a></li>
				<li><a href="BoardServlet?command=board_main">커뮤니티</a></li>
				<li><a href="UserServlet?command=logout">로그아웃</a></li>
			</ul>
		</nav>

		<!-- 본문 -->
		<section id="boardContent">
</body>
</html>