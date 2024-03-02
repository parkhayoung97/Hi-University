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

import util.Action;

public class MyPageAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String url = "board/myPage.jsp";
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		BoardDAO dao = BoardDAO.getInstance();
		
		// id가 쓴 게시글
		List<BoardDTO> list = dao.selectAllById(id);
		request.setAttribute("list", list);

		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
