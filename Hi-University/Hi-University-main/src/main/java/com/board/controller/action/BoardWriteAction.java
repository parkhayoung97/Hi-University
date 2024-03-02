package com.board.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.board.dao.BoardDAO;
import com.board.dto.BoardDTO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import util.Action;

public class BoardWriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();	// 세션 생성

		request.setCharacterEncoding("UTF-8");
		// 파일
		ServletContext context = request.getServletContext();
		String path = context.getRealPath("file");
		String encType = "UTF-8";
		int sizeLimit = 20 * 1024 * 1024;
		System.out.println(path);
		MultipartRequest multi = new MultipartRequest(request, path, sizeLimit, encType, new DefaultFileRenamePolicy());

		int type = Integer.parseInt(request.getParameter("type"));
		String nickname = (String) session.getAttribute("nickname");
		String id = (String)session.getAttribute("id");
		String title = multi.getParameter("title");
		String pass = multi.getParameter("pass");
		System.out.println(pass);
		String content = multi.getParameter("content");
		String filename = multi.getFilesystemName("filename");
		String anony = multi.getParameter("anony");
		
		String url = "BoardServlet?command=board_list&type="+type+"&tpage=1";
		BoardDTO dto = new BoardDTO();
		dto.setType(type);
		dto.setId(id);
		dto.setTitle(title);
		dto.setPass(pass);
		dto.setContent(content);
		dto.setFilename(filename);
		if(anony != null) {
			dto.setNickname(anony);
		}else {
			dto.setNickname(nickname);
		}
		
		BoardDAO dao = BoardDAO.getInstance();
		dao.insertBoard(dto);	// 게시글 작성
		System.out.println(dto.getPass());

		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);

	}

}
