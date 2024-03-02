package com.board.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.board.dao.BoardDAO;
import com.board.dto.BoardDTO;
import com.board.dto.CommentsDTO;

import util.Action;

public class BoardViewAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = "board/boardView.jsp";	// 게시글 상세 페이지
		int seq = Integer.parseInt(request.getParameter("seq"));	// 글번호 받기
		String command = request.getParameter("command");
		
		// 게시판
		BoardDTO dto = new BoardDTO();
		BoardDAO dao = BoardDAO.getInstance();
		dto = dao.selectOne(seq);	// 글번호로 특정 게시글 조회 후 dto에 저장
		
		HttpSession session = request.getSession();	// 세션 생성
		String id = (String)session.getAttribute("id");	// 세션의 아이디 값 받기
		int check = -1;		// 내 글x
		if(dto.getId().equals(id)) {	// 아이디로 내 글 확인
			check = 1;		// 내 글o
		}
		request.setAttribute("boardOne", dto);
		request.setAttribute("check", check);
		request.setAttribute("command", command);
		// 댓글
		List<CommentsDTO> list = dao.commentList(seq);
		request.setAttribute("comments", list);

		System.out.println("이동 페이지: " + url);
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
