package com.board.controller.action;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.dao.BoardDAO;
import com.board.dto.BoardDTO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import util.Action;

public class BoardUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int seq = Integer.parseInt(request.getParameter("seq"));

		request.setCharacterEncoding("UTF-8");
		// 파일
		ServletContext context = request.getServletContext();
		String path = context.getRealPath("file");
		String encType = "UTF-8";
		int sizeLimit = 20 * 1024 * 1024;
		System.out.println(path);
		MultipartRequest multi = new MultipartRequest(request, path, sizeLimit, encType, new DefaultFileRenamePolicy());

		String title = multi.getParameter("title");
		String pass = multi.getParameter("pass");
		String content = multi.getParameter("content");
		String filename = multi.getFilesystemName("filename");
		BoardDTO dto = new BoardDTO();
		dto.setSeq(seq);
		dto.setTitle(title);
		dto.setPass(pass);
		dto.setContent(content);
		dto.setFilename(filename);
		BoardDAO dao = BoardDAO.getInstance();
		dao.updateBoard(dto);	// 게시글 수정
		
		new BoardViewAction().execute(request, response);
	}

}
