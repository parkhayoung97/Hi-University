package com.board.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.dao.EvalDAO;
import com.board.dto.CmtDTO;

import util.Action;

public class CmtCommentAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = "evaluate/comment.jsp";
		EvalDAO dao = EvalDAO.getInstance();
		List<CmtDTO> comment = dao.selectAllComments();
		request.setAttribute("cmtlist", comment);
		
		System.out.println("이동페이지: " + url);
		RequestDispatcher dispatcher= request.getRequestDispatcher(url);
		dispatcher.forward(request, response);

	}

}
