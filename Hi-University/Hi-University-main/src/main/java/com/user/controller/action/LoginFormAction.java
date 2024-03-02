package com.user.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.Action;

public class LoginFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String url = "user/loginForm.jsp";
		
		System.out.println("이동 페이지: " +url);
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
		
		

	}

}
