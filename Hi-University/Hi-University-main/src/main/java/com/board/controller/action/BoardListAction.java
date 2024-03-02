package com.board.controller.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.dao.BoardDAO;
import com.board.dto.BoardDTO;

import util.Action;

public class BoardListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = "board/board.jsp";	// 게시판 페이지로 이동
		int type = Integer.parseInt(request.getParameter("type"));
		int tpage = Integer.parseInt(request.getParameter("tpage"));
		int view_rows = 5;
		System.out.println(type);
		List<BoardDTO> list = new ArrayList<>();	
		BoardDAO dao = BoardDAO.getInstance();
		list = dao.selectAll(type, tpage, view_rows);		// 게시글 전체 조회 후 리스트 저장
		
		// 페이지
		int count = dao.selectCount(type);
		request.setAttribute("count", count);
		
//		request.setAttribute("type", type);
		request.setAttribute("list", list);
		
		
		System.out.println("이동 페이지: " + url);
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
