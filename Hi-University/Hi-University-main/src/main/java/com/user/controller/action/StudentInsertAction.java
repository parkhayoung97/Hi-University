package com.user.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.user.dao.UserDAO;
import com.user.dto.UserDTO;

import util.Action;

public class StudentInsertAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		UserDTO dto = new UserDTO();
		dto.setId(request.getParameter("student_id"));
		dto.setPwd(request.getParameter("pwd"));
		dto.setName(request.getParameter("name"));
		dto.setDepartment(request.getParameter("department"));
		dto.setPhone(request.getParameter("phone"));
		dto.setEmail(request.getParameter("email"));
		dto.setBirth(request.getParameter("birth"));
		dto.setAddress(request.getParameter("address"));
		dto.setStatus(request.getParameter("status"));
		
		UserDAO dao = UserDAO.getInstance();
		dao.insertStudent(dto);
		new StudentListAction().execute(request, response);
	}

}
