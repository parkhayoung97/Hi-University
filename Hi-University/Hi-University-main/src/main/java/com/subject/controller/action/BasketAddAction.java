package com.subject.controller.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import util.Action;

import com.subject.dao.SubjectDAO;
import com.subject.dto.BasketDTO;



public class BasketAddAction implements Action{
	
	//List<BasketDTO>list = new ArrayList<>();
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
		//String url = "/subject/subjectMainList.jsp";
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println(id);
		int subjectNum = Integer.parseInt(request.getParameter("subjectNum"));
		BasketDTO bVo = new BasketDTO();
		bVo.setSubjectNum(Integer.parseInt(request.getParameter("subjectNum")));
		bVo.setCollege(request.getParameter("college"));
		bVo.setDepartment(request.getParameter("department"));		
		bVo.setSubject(request.getParameter("subject"));
		bVo.setProfessor(request.getParameter("professor"));
		bVo.setScore(Integer.parseInt( request.getParameter("score")));
		bVo.setDay1(request.getParameter("day1"));
		bVo.setDay2(request.getParameter("day2"));
		bVo.setTime1(request.getParameter("time1"));
		bVo.setTime2(request.getParameter("time2"));
		bVo.setId(Integer.parseInt(request.getParameter("id")));
		
		SubjectDAO mDao = SubjectDAO.getInstance();		
		mDao.insertBasket(bVo);		
		mDao.deleteDuplicateData();
		
		// 아이디로 이름 불러오기
		String name = mDao.selectStudentNameByID(id);
		// 성적 컬럼 생성
		mDao.insertGrade(bVo, name);
		
		//List<BasketDTO>list = mDao.showBasket(id);
//		list.addAll(mDao.showBasket(subjectNum));
//		for(int i=0;i<list.size();i++) {
//			System.out.println(list.get(i));
//		}		
		//mDao.deleteDuplicateData(subjectNum);
		//request.setAttribute("show", list);
		//RequestDispatcher rd = request.getRequestDispatcher(url);
		//rd.forward(request, response);
		new SubjectListFormAction().execute(request, response);
		
	}

	

}
