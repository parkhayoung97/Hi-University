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
<title>평가 수정</title>

</head>
<body>
	<div align="center">
		<!-- 사이즈 조정은 나중에 하기! -->
		<table>
			<thead>
				<tr>
					<th style="font-size: 20px" colspan="5">&nbsp;강의 평가 수정</th>
				</tr>
			</thead>
		</table>
	</div>

	<div class="container">
		<form action="BoardServlet" method="post">
			<input type="hidden" name="num" value="${param.num}"> 
			<input type="hidden" name="command" value="cmt_update">
			<div class="form-group col-sm-6">
				<label>강의명</label> <input type="text" name="subject"
					value=${comment.subject } readonly>
			</div>

			<div>
				<label>내용</label>
				<textarea name="content" class="form-control" maxlength="2048" style="height: 180px;">${comment.content}</textarea>
			</div>

			<div>
				<label>종합</label><select name="totalScore">
					<option value="A">A</option>
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
					<option value="A">A</option>	
					<option value="B">B</option>	
					<option value="C">C</option>
					<option value="D">D</option>	
					<option value="F">F</option>
				</select>
			</div>
	<br>
	
	<div align="center">
		<input type="submit" value="수정" onclick="return confirm('수정하시겠습니까?')"> 
		<input type="reset" value="취소"> 
		<input type="button" value="목록" onclick="location.href='BoardServlet?command=comment'">
	</div>
	</form>
	</div>
	
</body>
</html>