package com.board.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.board.dao.EvalDAO;
import com.board.dto.CmtDTO;

import util.Action;

public class CmtWriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		CmtDTO dto = new CmtDTO();
		HttpSession session = request.getSession();
		dto.setId((String)session.getAttribute("id"));
		dto.setSubject(request.getParameter("subject"));
		dto.setContent(request.getParameter("content"));
		dto.setTotalScore(request.getParameter("totalScore"));
		dto.setScore(request.getParameter("score"));
		dto.setLectureScore(request.getParameter("lectureScore"));
		EvalDAO dao = EvalDAO.getInstance();
		dao.insertComment(dto);
		new CmtCommentAction().execute(request, response);

	}

}
