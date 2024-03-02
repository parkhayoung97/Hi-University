package com.user.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.user.dao.UserDAO;
import com.user.dto.UserDTO;

import util.Action;

public class UpdateInfoFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		
		String url = "user/userUpdateForm.jsp";
		UserDAO dao = UserDAO.getInstance();
		UserDTO dto = dao.selectOneInfoById(id);
		
		request.setAttribute("info", dto);
		
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

}