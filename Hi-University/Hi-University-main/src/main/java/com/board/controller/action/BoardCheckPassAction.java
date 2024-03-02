package com.board.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.dao.BoardDAO;
import com.board.dto.BoardDTO;

import util.Action;

public class BoardCheckPassAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String url = null;
		int seq = Integer.parseInt(request.getParameter("seq"));
		String pass = request.getParameter("pass");
		
		BoardDAO dao = BoardDAO.getInstance();
		BoardDTO dto = dao.selectOne(seq);
		System.out.println("글비밀번호: " + dto.getPass());

		if(dto.getPass().equals(pass)) {	// 글비밀번호 일치
			url = "board/checkSuccess.jsp";	// 체크 성공 페이지
			System.out.println("1");
		}else {	// 글비밀번호 불일치
			url = "board/boardCheckPassForm.jsp";
			request.setAttribute("message", "비밀번호가 틀렸습니다");
		}
		System.out.println("이동 페이지: " + url);
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
