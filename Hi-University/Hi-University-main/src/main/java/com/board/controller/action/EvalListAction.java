package com.board.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.dao.EvalDAO;
import com.board.dto.EvalDTO;

import util.Action;

public class EvalListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = "evaluate/evalList.jsp";
		EvalDAO eDao = EvalDAO.getInstance();
		List<EvalDTO> evalList = eDao.selectAllEvals();
		request.setAttribute("evalList", evalList);
		
		System.out.println("이동 페이지: " + url);
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);

	}

}
