
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

   <hr size=1><br>  
   <div align=center>
    
   <%
   int type = Integer.parseInt(request.getParameter("type"));
   int tpage = Integer.parseInt(request.getParameter("tpage"));
   String command = request.getParameter("command");

    // 페이지 설정을 위한 변수
   int view_rows = 5;
   int total_pages = 1;      // 전체 페이지 (default 1)
//   int tpage = 1;            // 현재 페이지 (default 1
	int last = 0;
   String url = "BoardServlet?command="+command+"&type="+type+"&tpage=";
   
   
   int count = (Integer) request.getAttribute("count");
         
         if(count != 0){
            if((count % view_rows) == 0)
               total_pages = count / view_rows;
            else
               total_pages = (count / view_rows) + 1;
         }
         
         int start_page = 1;
         int end_page = 2;
         
         if(tpage < 1)
            tpage = 1;	// 현재 페이지가 1 이하이면 1로 변경
         
            if(tpage % 10 == 0){	// 현재 페이지를 10으로 나눴을때 나머지가 0면
               start_page = tpage - 9;
               end_page = tpage;
            }else{
               start_page = tpage - (tpage % 10) + 1;
               end_page = start_page + 9;
            }
            
            if(end_page > total_pages)
               end_page = total_pages;
               
   %>
   			<a href="<%=(url+"1") %>">◀◀</a>
   <%
                  
               for(int i=start_page; i<=end_page; i++){
                  if(i == tpage){
    %>            	  
                	  <font color=red>[<%=tpage %>]</font>&nbsp;
   <%
                  }else{
                	  
   					if(command.equals("board_search")){
   						String sear = request.getParameter("sear");
   						String searchType =request.getParameter("searchType");
   	%>
   						<a href="<%=(url+Integer.toString(i)+"&sear="+sear+"&searchType="+searchType) %>"><%=i %>&nbsp;</a>
   	<%
   					}else {
   	%>
   						 <a href="<%=(url+Integer.toString(i)) %>"><%=i %>&nbsp;</a>
   	
   	<%
   					}
                  }
               }
   
   				if(count%view_rows > 0){
   					last = (count/view_rows)+1;
   				}else{
   					last = (count/view_rows);
   				}
   
   %>

                  <a href="<%=(url+last) %>">▶▶</a>
                  &nbsp;
                  </div>

</body>
</html>
