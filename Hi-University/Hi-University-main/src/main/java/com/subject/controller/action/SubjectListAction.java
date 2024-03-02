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

public class SubjectListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		String url = "subject/subjectList.jsp";
		String check = request.getParameter("check");
		SubjectDAO dao = SubjectDAO.getInstance();
		List<SubjectDTO> subjectList = dao.selectAll();
		request.setAttribute("subjectList", subjectList);
		request.setAttribute("check", check);
		
		System.out.println("이동 페이지: " + url);
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
