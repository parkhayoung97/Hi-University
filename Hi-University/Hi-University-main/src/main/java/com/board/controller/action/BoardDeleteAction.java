package com.board.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.dao.BoardDAO;

import util.Action;

public class BoardDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int seq = Integer.parseInt(request.getParameter("seq"));
		BoardDAO dao = BoardDAO.getInstance();
		dao.deleteBoard(seq);
		
		new BoardListAction().execute(request, response);
	}

}
