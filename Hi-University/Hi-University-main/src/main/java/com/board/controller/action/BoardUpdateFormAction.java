package com.board.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.dao.BoardDAO;
import com.board.dto.BoardDTO;

import util.Action;

public class BoardUpdateFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = "board/boardUpdateForm.jsp";	// 수정 폼 페이지
		int seq = Integer.parseInt(request.getParameter("seq"));
		BoardDAO dao = BoardDAO.getInstance();
		BoardDTO dto = dao.selectOne(seq);	// 글번호로 특정 게시글 값 dto에 저장
		
		request.setAttribute("boardOne", dto);
		
		System.out.println("이동 페이지: " + url);
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
		
	}

}
