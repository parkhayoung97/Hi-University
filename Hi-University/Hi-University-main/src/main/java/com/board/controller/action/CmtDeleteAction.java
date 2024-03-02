package com.board.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.dao.EvalDAO;

import util.Action;

public class CmtDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int num = Integer.parseInt(request.getParameter("num"));
		EvalDAO dao = EvalDAO.getInstance();
		dao.deleteComment(num);
		new CmtCommentAction().execute(request, response);

	}

}
