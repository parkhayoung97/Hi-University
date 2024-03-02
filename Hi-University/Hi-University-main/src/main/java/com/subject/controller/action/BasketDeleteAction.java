package com.subject.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.subject.dao.SubjectDAO;
import com.subject.dto.BasketDTO;

import util.Action;

public class BasketDeleteAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		int subjectNum = Integer.parseInt(request.getParameter("subjectNum"));
		SubjectDAO mDao = SubjectDAO.getInstance();		
		mDao.deleteBasket(subjectNum);	
		mDao.deleteGrade(id, subjectNum);		
		
		new SubjectListFormAction().execute(request, response);

	}

}
