package com.board.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.dao.EvalDAO;
import com.board.dto.CmtDTO;

import util.Action;

public class CmtUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		CmtDTO dto = new CmtDTO();
//		System.out.println(request.getParameter("subject"));
		dto.setSubject(request.getParameter("subject"));
		dto.setContent(request.getParameter("content"));
		dto.setTotalScore(request.getParameter("totalScore"));
		dto.setScore(request.getParameter("score"));
		dto.setLectureScore(request.getParameter("lectureScore"));
		dto.setNum(Integer.parseInt(request.getParameter("num")));
		EvalDAO dao = EvalDAO.getInstance();
		dao.updateComment(dto);
		new CmtCommentAction().execute(request, response);
	}

}
