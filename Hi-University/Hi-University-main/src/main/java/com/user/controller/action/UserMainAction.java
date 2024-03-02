package com.user.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.user.dao.UserDAO;

import util.Action;

public class UserMainAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = "user/userMain.jsp";	// 유저 메인화면 페이지

		HttpSession session = request.getSession();		// 세션 생성
		String id = (String)session.getAttribute("id");	// 세션에 있는 아이디 값 불러오기
		
		UserDAO dao = UserDAO.getInstance();	
		String status = dao.status(id);		// 상태(1:재학생 2:졸업생 3:관리자) select
		System.out.println("상태: " + status);	
		session.setAttribute("status", status);		// 세션에 상태 값 저장
		
		if(id.length() == 7) {	//아이디 길이(6:학생 7:관리자)가 7
			url = "admin/adminMain.jsp";	// 관리자 메인화면 페이지로 이동
		}
		
		System.out.println("이동 페이지: " + url);
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}
}
