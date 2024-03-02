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

public class UserInfoAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = "user/UserInfo.jsp";
		
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		
		UserDAO dao = UserDAO.getInstance();
		UserDTO dto = dao.selectOneInfoById(id);
		request.setAttribute("user", dto);
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);

	}

}
