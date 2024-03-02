<%@page import="com.subject.dto.BasketDTO"%>
<%@page import="com.subject.dto.SubjectDTO"%>
<%@page import="com.subject.dao.SubjectDAO"%>
<%@page import="java.awt.Button"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page
	import="org.eclipse.jdt.internal.compiler.ast.AllocationExpression"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%
HttpSession session2 = request.getSession();
int id = Integer.parseInt(session2.getAttribute("id").toString());

SubjectDAO sDao = SubjectDAO.getInstance();
String departmentX = sDao.selectDepartmentByID(id);
String name = sDao.selectStudentNameByID(id);
List<SubjectDTO> sVoList = sDao.selectSubjectByDepartment(departmentX);
SubjectDTO sVo = new SubjectDTO();

int[] subjectNum = new int[sVoList.size()];
String[] college = new String[sVoList.size()];
String[] department = new String[sVoList.size()];
String[] subject = new String[sVoList.size()];
String[] professor = new String[sVoList.size()];
int[] score = new int[sVoList.size()];
String[] day1 = new String[sVoList.size()];
String[] day2 = new String[sVoList.size()];
String[] time1 = new String[sVoList.size()];
String[] time2 = new String[sVoList.size()];

for (int i = 0; i < sVoList.size(); i++) {
	sVo = sVoList.get(i);
	subjectNum[i] = sVo.getSubjectNum();
	college[i] = sVo.getCollege();
	department[i] = sVo.getDepartment();
	subject[i] = sVo.getSubject();
	professor[i] = sVo.getProfessor();
	score[i] = sVo.getScore();
	day1[i] = sVo.getDay1();
	day2[i] = sVo.getDay2();
	time1[i] = sVo.getTime1();
	time2[i] = sVo.getTime2();
}
%>


<!DOCTYPE html>
<html>
 <link rel="stylesheet" type="text/css" href="css/shopping.css">
<head>

<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

</head>
<body>

	<jsp:include page="../base/userHeader.jsp" />
	<h2 align="center">교과목 리스트</h2>
	<h2><%=name%>님 수강신청 화면입니다.
	</h2>


	<div>
		<table align="center" style="width: 800px">
			<tr>
				<th width="100">선택</th>
				<th width="200">강의분류번호</th>
				<th width="300">해당대학</th>
				<th width="300">해당학과</th>
				<th width="500">강의명</th>
				<th width="200">담당교수</th>
				<th width="100">학점</th>
				<th width="500">강의시간</th>
			</tr>

			<%
			for (int i = 0; i < subjectNum.length; i++) {
			%>
			<tr>
				<td><input type="button" value="선택" id="button<%=i%>"
					onclick="location.href='SubjectServlet?command=basket_add&subjectNum=<%=subjectNum[i]%>&college=<%=college[i]%>&department=<%=department[i]%>&subject=<%=subject[i]%>&professor=<%=professor[i]%>&score=<%=score[i]%>&day1=<%=day1[i]%>&day2=<%=day2[i]%>&time1=<%=time1[i]%>&time2=<%=time2[i]%>&id=<%=id%>'"></td>

				<td><%=subjectNum[i]%></td>
				<td><%=college[i]%></td>
				<td><%=department[i]%></td>
				<td><%=subject[i]%></td>
				<td><%=professor[i]%></td>
				<td><%=score[i]%></td>
				<td><%=day1[i]%>,<%=day2[i]%>,<%=time1[i]%>,<%=time2[i]%></td>

				<%
				}
				%>

			</tr>
		</table>
	</div>
<br><br>
<h2>수강 신청 완료 내역</h2>
	<div>
		<%
		List<BasketDTO> bVoList = sDao.showBasket(id);
		int[] subjectNum2 = new int[bVoList.size()];
		String[] college2 = new String[bVoList.size()];
		String[] department2 = new String[bVoList.size()];
		String[] subject2 = new String[bVoList.size()];
		String[] professor2 = new String[bVoList.size()];
		int[] score2 = new int[bVoList.size()];
		String[] day1_2 = new String[bVoList.size()];
		String[] day2_2 = new String[bVoList.size()];
		String[] time1_2 = new String[bVoList.size()];
		String[] time2_2 = new String[bVoList.size()];
		for (int i = 0; i < bVoList.size(); i++) {
			BasketDTO bVo = bVoList.get(i);
			subjectNum2[i] = bVo.getSubjectNum();
			college2[i] = bVo.getCollege();
			department2[i] = bVo.getDepartment();
			subject2[i] = bVo.getSubject();
			professor2[i] = bVo.getProfessor();
			score2[i] = bVo.getScore();
			day1_2[i] = bVo.getDay1();
			day2_2[i] = bVo.getDay2();
			time1_2[i] = bVo.getTime1();
			time2_2[i] = bVo.getTime2();
		}
		%>

		<table align="center" style="width: 800px">
			<tr>
				<th width="100">삭제</th>
				<th width="100">강의분류번호</th>
				<th width="200">해당대학</th>
				<th width="200">해당학과</th>
				<th width="250">강의명</th>
				<th width="200">담당교수</th>
				<th width="100">학점</th>
				<th width="300">강의시간</th>
			</tr>

			<%
			for (int i = 0; i < subjectNum2.length; i++) {
			%>
			<tr>
				<td><input type="button" value="삭제"
					onclick="location.href='SubjectServlet?command=basket_delete&subjectNum=<%=subjectNum2[i]%>&id=<%=id%>'"></td>
				<td><%=subjectNum2[i]%></td>
				<td><%=college2[i]%></td>
				<td><%=department2[i]%></td>
				<td><%=subject2[i]%></td>
				<td><%=professor2[i]%></td>
				<td><%=score2[i]%></td>
				<td><%=day1_2[i]%>,<%=day2_2[i]%>,<%=time1_2[i]%>,<%=time2_2[i]%></td>

				<%
				}
				%>

			</tr>
		</table>
	</div>
	<jsp:include page="../base/footer.jsp"/>
</body>
</html>
