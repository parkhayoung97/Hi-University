package com.subject.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.subject.dao.SubjectDAO;
import com.subject.dto.SubjectDTO;

import util.Action;

public class GradeSubjectListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String url = "subject/gradeSubjectList.jsp";
		SubjectDAO dao = SubjectDAO.getInstance();
		List<SubjectDTO> subjectList = dao.selectAll();
		request.setAttribute("subjectList", subjectList);
		
		System.out.println("이동 페이지: " + url);
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);

	}

}
