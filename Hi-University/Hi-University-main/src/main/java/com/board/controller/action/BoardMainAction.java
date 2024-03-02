package com.board.controller.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.board.dao.BoardDAO;
import com.board.dto.BoardDTO;
import com.user.dao.UserDAO;

import util.Action;

public class BoardMainAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();		// 세션 생성
		String student_id = (String) session.getAttribute("id");	// 세션에서 아이디 값 받기
		UserDAO dao = UserDAO.getInstance();
		String url = "user/nickname.jsp";	// 별명이 없는 학생은 별명 등록 페이지로 이동
		
		String status = (String) session.getAttribute("status");	// 세션에서 상태 값 받기
		if (status.equals("3")) {	// 관리자일 경우
			url = "board/boardMain.jsp";	// 보드 메인 페이지로 이동
		}else {	// 학생일 경우
			String nickname = dao.checkNick(student_id);	// 아이디 값으로 별명 검색
			if (nickname != null) {	// 별명이 있는 경우
				url = "board/boardMain.jsp";	// 보드 메인 페이지로 이동
				session.setAttribute("nickname", nickname);		// 세션에 닉네임 값 저장
			}
		}
		
		BoardDAO bDao = BoardDAO.getInstance();
		List<BoardDTO> free, anony = new ArrayList<>();	// 게시판 리스트 생성
		// 게시글 상위 5개 조회
		free = bDao.selectAll5(1);
		anony = bDao.selectAll5(2);
		
		request.setAttribute("free", free);
		request.setAttribute("anony", anony);
		
		System.out.println("이동 페이지: " + url);
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
