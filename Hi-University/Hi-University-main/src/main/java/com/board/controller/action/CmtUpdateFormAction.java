package com.board.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.dao.EvalDAO;
import com.board.dto.CmtDTO;

import util.Action;

public class CmtUpdateFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String url= "evaluate/cmtUpdateForm.jsp";
		int num = Integer.parseInt(request.getParameter("num"));
		EvalDAO dao = EvalDAO.getInstance();
		CmtDTO dto = dao.selectOneEval(num);
		request.setAttribute("comment", dto);
		
		System.out.println("이동 페이지: " + url);
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);

	}

}
