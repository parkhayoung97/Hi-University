package com.subject.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.subject.dao.SubjectDAO;
import com.subject.dto.GradeDTO;

import util.Action;

public class GradeInsertAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		int subjectNum = Integer.parseInt(request.getParameter("subjectNum"));
		double gradeScore = Double.parseDouble(request.getParameter("gradeScore"));
		String grade = request.getParameter("grade");
		GradeDTO dto = new GradeDTO();
		dto.setid(id);
		dto.setSubjectNum(subjectNum);
		dto.setGrade(grade);
		dto.setGrade_score(gradeScore);
		
		SubjectDAO dao = SubjectDAO.getInstance();
		dao.updateGrade(dto);
		
		String url = "SubjectServlet?command=grade_subject_view&subjectNum="+subjectNum;
		RequestDispatcher rd  = request.getRequestDispatcher(url);
		rd.forward(request, response);
		
		
	}

}
