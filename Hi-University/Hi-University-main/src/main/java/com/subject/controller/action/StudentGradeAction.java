package com.subject.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.subject.dao.SubjectDAO;
import com.subject.dto.GradeDTO;

import util.Action;

public class StudentGradeAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = "subject/userGrade.jsp";
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		
		SubjectDAO dao = SubjectDAO.getInstance();
		List<GradeDTO> list = dao.selectGradeAllById(id);
		request.setAttribute("list", list);
		
		System.out.println("이동 페이지: " + url);
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);

	}

}
