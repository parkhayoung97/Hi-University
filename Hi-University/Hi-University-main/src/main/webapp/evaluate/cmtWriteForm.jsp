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
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<title>평가 글쓰기</title>
</head>
<body>
	<div align="center">
		<table>
			<thead>
				<tr>
					<th class="table-primary" style="font-size: 20px" colspan="5">&nbsp;강의평가등록</th>
				</tr>
			</thead>
		</table>
	</div>

	<div class="container">
		<form action="BoardServlet" method="post">
			<input type="hidden" name="command" value="cmt_Write">
			<div>
				<div>
					<label>강의명</label> <select name="subject">
						<option value="0" selected>선택</option>
						<c:forEach var="list" items="${list }">
							<option value="${list.subject }">${list.subject }-${list.professor }</option>
						</c:forEach>
					</select>
				</div>
			</div>

			<div>
				<label>내용</label>
				<textarea name="content"></textarea>
			</div>

			<div>
				<div>
					<label>종합</label> <select name="totalScore">
						<option value="A" selected>A</option>
						<option value="B">B</option>
						<option value="C">C</option>
						<option value="D">D</option>
						<option value="F">F</option>
					</select>
				</div>
				
				<div>
					<label>성적</label> <select name="score">
						<option value="A" selected>A</option>
						<option value="B">B</option>
						<option value="C">C</option>
						<option value="D">D</option>
						<option value="F">F</option>
					</select>
				</div>
				
				<div>
					<label>강의</label> <select name="lectureScore">
						<option value="A" selected>A</option>
						<option value="B">B</option>
						<option value="C">C</option>
						<option value="D">D</option>
						<option value="F">F</option>
					</select>
				</div>
			</div>

			<br>
			<br>
			<div align="center">
				<input type="submit" value="등록"> 
				<input type="reset" value="다시 작성"> 
				<input type="button" value="목록" onclick="location.href='BoardServlet?command=comment'">
			</div>
		</form>
	</div>

</body>
</html>