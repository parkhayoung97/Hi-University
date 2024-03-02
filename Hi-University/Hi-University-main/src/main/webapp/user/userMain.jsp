<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width">
<script src="https://code.jquery.com/jquery-1.12.0.min.js"></script>
<title>Main Form</title>
</head>
<body>
	<jsp:include page="../base/userHeader.jsp" />

	<h1 style="margin-left: 50px;">재학생 페이지입니다.</h1>

	<div id="cal1">
		<iframe
			src="https://calendar.google.com/calendar/embed?src=402bddf1222ce219e23563fb03fb67583b67a94fbfcd5eef9b3683894b3d9614%40group.calendar.google.com&ctz=Asia%2FSeoul"
			style="border: solid 1px #777" width="500" height="340"
			frameborder="0" scrolling="no"></iframe>
	</div>
	
	<div class="idd">
		<article>
			<h3>4월 7일</h3>
			<p>학기 1/3선</p>
		</article>

		<article>
			<h3>4월 20 ~ 26일</h3>
			<p>중간 고사</p>
		</article>

		<article>
			<h3>4월 27일 ~ 5월 1일</h3>
			<p>수강 철회</p>
		</article>

		<article>
			<h3>5월 10일</h3>
			<p>은퇴 교수의 날</p>
		</article>

		<article>
			<h3>5월 13일</h3>
			<p>창립 기념일</p>
		</article>

		<article>
			<h3>6월 8 ~ 14일</h3>
			<p>보충 수업 기간</p>
		</article>

		<article>
			<h3>7월 17일</h3>
			<p>여름 계절제 수업종료</p>
		</article>

		<article>
			<h3>7월 20일</h3>
			<p>하이미디어 종강</p>
		</article>
	</div>

	<div id=notice>
	<h2>공지사항</h2>
	<table>
		<tr>
			<th>전체공지</th>
			<td>이번학기 등록금 전원 면제</td>
		</tr>
		<tr>
			<td>학과공지</td>
			<td>실용음악과 학생들...</td>
		</tr>
		<tr>
			<td>자유게시판</td>
			<td>욕설 및 비방글 삭제합니다.</td>
		</tr>
	</table>
	</div>
	<jsp:include page="../base/footer.jsp"/>
</body>
</html>