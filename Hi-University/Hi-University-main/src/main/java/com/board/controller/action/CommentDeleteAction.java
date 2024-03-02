package com.board.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.dao.BoardDAO;

import util.Action;

public class CommentDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int board_seq = Integer.parseInt(request.getParameter("board_seq"));
		String board_type = request.getParameter("board_type");
		int comment_seq = Integer.parseInt(request.getParameter("seq"));
		String url="BoardServlet?command=board_view&type=" + board_type + "&seq=" + board_seq;
		
		BoardDAO dao = BoardDAO.getInstance();
		dao.deleteComment(comment_seq);

		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);

	}

}
