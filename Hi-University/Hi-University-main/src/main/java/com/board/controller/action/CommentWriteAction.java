package com.board.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.board.dao.BoardDAO;
import com.board.dto.CommentsDTO;

import util.Action;

public class CommentWriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub		
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		String nickname = (String)session.getAttribute("nickname");
		int board_seq = Integer.parseInt(request.getParameter("board_seq"));
		String board_type = request.getParameter("board_type");
		String comment = request.getParameter("comment");
		String url="BoardServlet?command=board_view&type=" + board_type + "&seq=" + board_seq;
		
		CommentsDTO dto = new CommentsDTO();
		dto.setId(id);
		dto.setBoard_seq(board_seq);
		dto.setNickname(nickname);
		dto.setContent(comment);
		BoardDAO dao = BoardDAO.getInstance();
		dao.insertComment(dto);
		
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
		
//		new BoardViewAction().execute(request, response);
		
	}

}
