package com.user.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.user.dao.UserDAO;
import com.user.dto.UserDTO;

import util.Action;

public class UpdateInfoAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		String pwd = request.getParameter("pwd");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		
		UserDTO dto = new UserDTO();
		dto.setId(id);
		dto.setPwd(pwd);
		dto.setPhone(phone);
		dto.setEmail(email);
		dto.setAddress(address);
		
		UserDAO dao = UserDAO.getInstance();
		dao.updateUser(dto);
		
		new UserInfoAction().execute(request, response);
	}

}
