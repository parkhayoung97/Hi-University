package com.user.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.user.dao.UserDAO;

import util.Action;

public class NickAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = "user/nickname.jsp";	// 별명 등록 페이지
		request.setCharacterEncoding("UTF-8");
		String nickname = request.getParameter("nickname");
		
		HttpSession session = request.getSession();		// 세션 생성
		String id = (String)session.getAttribute("id");	// 세션에서 아이디 값 받기
		
		UserDAO dao = UserDAO.getInstance();
		dao.updateNickname(nickname, id);	// 별명 등록
		session.setAttribute("nickname", nickname);	// 세션에 별명 값 등록
		url = "BoardServlet?command=board_main";	// 등록이 되면 게시판 메인 페이지로 이동
		
		System.out.println("이동 페이지: " + url);
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
		
	}

}
