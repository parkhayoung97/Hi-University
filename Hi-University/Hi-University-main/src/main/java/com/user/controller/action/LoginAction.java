package com.user.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.user.dao.UserDAO;

import util.Action;

public class LoginAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = "user/loginForm.jsp";	// 로그인 폼 페이지

		String id = request.getParameter("id");	
		String pwd = request.getParameter("pwd");
		String message = "";
		HttpSession session = request.getSession();		// 세션 생성
		
		UserDAO dao = UserDAO.getInstance();
		int result = dao.login(id, pwd);	// 로그인 결과 저장
		if(result == 1) {	// 로그인 성공
			url = "UserServlet?command=user_main";	// 로그인에 성공하면 UserMainAction으로 이동
			session.setAttribute("id", id);		// 세션에 아이디 저장
		}else if(result == 0) {	// 비밀번호가 틀림
			message = "비밀번호가 다름";
		}else {	// 아이디가 없음
			message = "계정이 존재하지 않음";		
		}
		
		request.setAttribute("message", message);
		System.out.println("이동 페이지: " +url);
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
