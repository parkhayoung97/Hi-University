package com.board.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.dao.BoardDAO;
import com.board.dto.BoardDTO;

import util.Action;

public class BoardSearchAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("UTF-8");
		String searchType = request.getParameter("searchType");
		String search = request.getParameter("sear");
		int type = Integer.parseInt(request.getParameter("type"));
		int tpage = Integer.parseInt(request.getParameter("tpage"));
		String url = "board/board.jsp";	// 게시판 페이지
		
		BoardDAO dao = BoardDAO.getInstance();
		List<BoardDTO> list = dao.searchBoard(searchType, search, type, tpage);	// 키워드가 맞는 게시글 검색 후 리스트 저장
		int count = dao.searchCount(searchType, search, type);
		
		request.setAttribute("list", list);
		request.setAttribute("count", count);
		request.setAttribute("searchType", searchType);
		request.setAttribute("search", search);
		
		System.out.println("이동 페이지: " + url);
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
