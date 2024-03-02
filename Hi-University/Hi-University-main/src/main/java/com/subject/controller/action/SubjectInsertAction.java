package com.subject.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.subject.dao.SubjectDAO;
import com.subject.dto.SubjectDTO;

import util.Action;

public class SubjectInsertAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String college = request.getParameter("college");
		String department = request.getParameter("department");
		String subject = request.getParameter("subject");
		String professor = request.getParameter("professor");
		int subjectNum = Integer.parseInt(request.getParameter("subjectNum"));
		int score = Integer.parseInt(request.getParameter("score"));
		String day1 = request.getParameter("day1");
		String time1 = request.getParameter("time1");
		String day2 = request.getParameter("day2");
		String time2 = request.getParameter("time2");
		SubjectDAO sDao = SubjectDAO.getInstance();
		SubjectDTO sVo = new SubjectDTO();
		sVo.setCollege(college);
		sVo.setDepartment(department);
		sVo.setSubject(subject);
		sVo.setSubjectNum(subjectNum);
		sVo.setProfessor(professor);
		sVo.setScore(score);
		sVo.setDay1(day1);
		sVo.setTime1(time1);
		sVo.setDay2(day2);
		sVo.setTime2(time2);
		sDao.insertSubject(sVo);
		new SubjectListAction().execute(request, response);
		
		
	}

}
