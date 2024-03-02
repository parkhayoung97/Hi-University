package com.user.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.user.dao.UserDAO;
import com.user.dto.UserDTO;

import util.Action;

public class StudentViewAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String url = "admin/studentView.jsp";
		String id = request.getParameter("id");
				
		UserDAO dao = UserDAO.getInstance();
		
		UserDTO dto = dao.selectOneInfoById(id);
		request.setAttribute("info", dto);
		
		System.out.println("이동 페이지: " + url);
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
