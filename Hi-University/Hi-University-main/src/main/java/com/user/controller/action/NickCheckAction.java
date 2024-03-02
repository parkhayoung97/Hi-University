package com.user.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.user.dao.UserDAO;

import util.Action;

public class NickCheckAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = "user/nickCheck.jsp";	// 별명 중복체크 새 창으로 이동
		request.setCharacterEncoding("UTF-8");
		String nickname = request.getParameter("nickname");

		UserDAO dao = UserDAO.getInstance();
		int result = dao.confirmNick(nickname);	// 별명 중복체크 결과 저장
		request.setAttribute("nickname", nickname);
		request.setAttribute("result", result);
		
		System.out.println("이동 페이지: " + url);
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
