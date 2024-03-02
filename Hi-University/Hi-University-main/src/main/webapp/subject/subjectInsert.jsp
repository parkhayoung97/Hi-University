<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.subject.dto.SubjectDTO"%>
<%@page import="com.subject.dao.SubjectDAO"%>
<!DOCTYPE html>



<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="../base/adminHeader.jsp" />
	<form action="SubjectServlet" method="post">
		<input type="hidden" name="command" value="subject_insert">
		<h2 align="center">과목 등록</h2>
		<div>
			<table align="center">
				<tr>
					<th>대학</th>
					<td><select id="college">
							<option value="1">인문대학</option>
							<option value="2">공과대학</option>
							<option value="3">예체능대학</option>
							<option value="4">상경대학</option>
					</select></td>
				</tr>
				<tr>
					<th>학과</th>

					<td><select id="department">
							<option value="1">정치외교학과</option>
							<option value="2">행정학과</option>
							<option value="3">철학과</option>
							<option value="4">컴퓨터공학과</option>
							<option value="5">전자공학과</option>
							<option value="6">기계공학과</option>
							<option value="7">실용음악과</option>
							<option value="8">동양화과</option>
							<option value="9">사회체육학과</option>
							<option value="10">교양과</option>
					</select></td>
				</tr>
				<tr>
					<th>과목코드</th>
					<td><input type="text" name="subjectNum"></td>
				</tr>
				<tr>
					<th>과목명</th>
					<td><input type="text" name="subject"></td>
				</tr>
				<tr>
					<th>담당교수</th>
					<td><input type="text" name="professor"></td>
				</tr>
				<tr>
					<th>학점</th>
					<td><select id="score">
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
					</select></td>
				</tr>
				<tr>
					<th>요일</th>
					<td><select id="day1">
							<option value="1">월요일</option>
							<option value="2">화요일</option>
							<option value="3">수요일</option>
							<option value="4">목요일</option>
							<option value="5">금요일</option>
					</select></td>
					<td><select id="day2">
							<option value="1">월요일</option>
							<option value="2">화요일</option>
							<option value="3">수요일</option>
							<option value="4">목요일</option>
							<option value="5">금요일</option>
					</select></td>
				<tr>
					<th>시간</th>
					<td><select id="time1">
							<option value="1">09:00~11:00</option>
							<option value="2">11:00~13:00</option>
							<option value="3">13:00~15:00</option>
							<option value="4">15:00~17:00</option>
					</select></td>
					<td><select id="time2">
							<option value="1">09:00~11:00</option>
							<option value="2">11:00~13:00</option>
							<option value="3">13:00~15:00</option>
							<option value="4">15:00~17:00</option>
					</select></td>
				</tr>
				<tr align="center">
					<td></td>
					<td><input type="submit" value = "등록">
						<input type="reset" value = "취소"></td>
				<tr>
			</table>
		</div>
	</form>
	<jsp:include page="../base/footer.jsp" />
</body>
</html>