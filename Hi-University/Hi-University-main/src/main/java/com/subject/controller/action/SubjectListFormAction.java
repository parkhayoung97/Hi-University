package com.subject.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.subject.dao.SubjectDAO;
import com.subject.dto.SubjectDTO;

import util.Action;

public class SubjectListFormAction implements Action {

	// 수강신청 페이지
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//HttpSession session = request.getSession();
		//int id = Integer.parseInt(session.getAttribute("id").toString());		
		String url = "subject/subjectMainList.jsp";
		//int id = Integer.parseInt(request.getParameter("id"));
		//SubjectDAO dao = SubjectDAO.getInstance();
		//String department = dao.selectDepartmentByID(id);
		//List<SubjectDTO> allSub = dao.selectSubjectByDepartment(department);
		//request.setAttribute("all", allSub);
		
		System.out.println("이동 페이지: " + url);
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
