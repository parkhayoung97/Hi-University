package com.subject.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.subject.dao.SubjectDAO;
import com.subject.dto.GradeDTO;

import util.Action;

public class FirstGradeStudentListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url ="subject/gradeInsert.jsp";
		int subjectNum=Integer.parseInt(request.getParameter("subjectNum"));
		SubjectDAO dao = SubjectDAO.getInstance();
		List<GradeDTO> first =dao.selectAllFirstid(subjectNum);
		request.setAttribute("first", first);
		
//		GradeDTO dto = new GradeDTO();
//		dto.setGrade(request.getParameter("grade"));

		System.out.println("이동 페이지: " + url);
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
