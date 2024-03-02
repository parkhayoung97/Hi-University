package com.user.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.user.dao.UserDAO;
import com.user.dto.UserDTO;

import util.Action;

public class StudentUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UserDTO dto = new UserDTO();
		System.out.println(request.getParameter("name"));
		String id = request.getParameter("student_id");
		dto.setId(id);
		dto.setPwd(request.getParameter("pwd"));
		dto.setName(request.getParameter("name"));
		dto.setDepartment(request.getParameter("department"));
		dto.setBirth(request.getParameter("birth"));
		dto.setPhone(request.getParameter("phone"));
		dto.setEmail(request.getParameter("email"));
		dto.setAddress(request.getParameter("address"));
		dto.setStatus(request.getParameter("status"));
		
		UserDAO dao = UserDAO.getInstance();
		dao.updateStudent(dto);
		
		String url = "UserServlet?command=student_view&id=" + id;
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
