package com.subject.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.subject.dao.SubjectDAO;
import com.subject.dto.BasketDTO;

import util.Action;

public class UserTableAction implements Action {

   @Override
   public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      HttpSession session = request.getSession();
      int id = Integer.parseInt(session.getAttribute("id").toString());
      //System.out.println(id);
      
      String url = "subject/userTable.jsp";
      
      SubjectDAO dao = SubjectDAO.getInstance();
      
      List<BasketDTO> allsub = dao.selectAllSub(id);
      request.setAttribute("all", allsub);
      
      System.out.println("이동 페이지: " + url);
      
      RequestDispatcher rd = request.getRequestDispatcher(url);
      rd.forward(request, response);

   }

}