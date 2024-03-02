package com.user.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.user.dao.UserDAO;
import com.user.dto.DepartmentDTO;

import util.Action;

public class DepartmentListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String url = "admin/departmentList.jsp";
		
		UserDAO dao = UserDAO.getInstance();
		List<DepartmentDTO> list = dao.selectAllDept();
		
		request.setAttribute("list", list);
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);

	}

}
