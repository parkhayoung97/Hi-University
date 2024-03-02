<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/form.css">
<script src="https://code.jquery.com/jquery-1.12.0.min.js"></script>
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
		<aside id="sidebar">
		<h2>학생 정보</h2>
		<div id="box2">
			<li class="main2_1">학생 정보 관리
				<ul class="sub2_1" style="display: none">
					<li><a href="UserServlet?command=department_list">학과조회</a></li>
					<li><a href="UserServlet?command=student_list">학생정보조회</a></li>
					<li><a href="UserServlet?command=student_insert_form">학생정보등록</a></li>
				</ul>
			</li>
		</div>
		<script>
            $(".main2_1").css("cursor","pointer").click(function(){
                if($(".sub2_1").is(":visible")){
                    $(".sub2_1").slideUp();
                }
                else{
                    $(".sub2_1").slideDown();
                }
            })
        </script>
        <br>
        
		<div id="box2">
			<li class="main2_2">학생 성적 관리
				<ul class="sub2_2" style="display: none">
					<li><a href="SubjectServlet?command=grade_subject_list">성적조회</a></li>
					<li><a href="SubjectServlet?command=subject_list&check=grade">성적등록</a></li>
				</ul>
			</li>
		</div>
		<script>
            $(".main2_2").css("cursor","pointer").click(function(){
                if($(".sub2_2").is(":visible")){
                    $(".sub2_2").slideUp();
                }
                else{
                    $(".sub2_2").slideDown();
                }
            })
        </script>
		<br>
		
		<div id="box2">
			<li class="main2_3">수강 과목 관리
				<ul class="sub2_3" style="display: none">
					<li><a href="SubjectServlet?command=subject_list&check=subject">과목조회</a></li>
					<li><a href="SubjectServlet?command=subject_insert_form">과목등록</a></li>
				</ul>
			</li>
		</div>
		<script>
            $(".main2_3").css("cursor","pointer").click(function(){
                if($(".sub2_3").is(":visible")){
                    $(".sub2_3").slideUp();
                }
                else{
                    $(".sub2_3").slideDown();
                }
            })
        	</script>
	</aside>
	
		<!--콘텐츠부분-->
		<section id="content">
</body>
</html>