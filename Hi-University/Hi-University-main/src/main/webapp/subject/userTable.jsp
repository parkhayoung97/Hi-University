<%@ page import="com.subject.dto.BasketDTO"%>
<%@ page import="com.subject.dto.SubjectDTO"%>
<%@ page import="com.subject.dao.SubjectDAO"%>
<%@ page import="java.util.Arrays"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
   HttpSession session2 = request.getSession();
   int id = Integer.parseInt(session2.getAttribute("id").toString());
   
   SubjectDAO sDao = SubjectDAO.getInstance();
   List<BasketDTO> sVoList = sDao.showBasket(id);
   BasketDTO sVo = new BasketDTO();
   
   String[] subject = new String[sVoList.size()];
   String[] professor = new String[sVoList.size()];
   String[] time1 = new String[sVoList.size()];
   String[] time2 = new String[sVoList.size()];
   String[] day1 = new String[sVoList.size()];
   String[] day2 = new String[sVoList.size()];
   
   for (int i = 0; i < sVoList.size(); i++) {
         sVo = sVoList.get(i);
         subject[i] = sVo.getSubject();
         professor[i] = sVo.getProfessor();
         day1[i] = sVo.getDay1();
         time1[i] = sVo.getTime1();
         day2[i] = sVo.getDay2();
         time2[i] = sVo.getTime2();
   }
        
   %>

<script>
      window.onload = function () {
         <%for(int i=0;i<sVoList.size();i++){
            //Mon
            if(day1[i].equals("Mon")&&time1[i].equals("09:00~11:00")){%>
            document.getElementById("mon1").innerText = "<%=subject[i]%>\n<%=professor[i]%>";
            document.getElementById("mon1").style.backgroundColor = "#F781F3";
            <%}%>
            <%if(day1[i].equals("Mon")&&time1[i].equals("11:00~13:00")){%>
            document.getElementById("mon2").innerText = "<%=subject[i]%>\n<%=professor[i]%>";
            document.getElementById("mon2").style.backgroundColor = "#A4A4A4";
            <%}%>
            <%if(day1[i].equals("Mon")&&time1[i].equals("13:00~15:00")){%>
            document.getElementById("mon3").innerText = "<%=subject[i]%>\n<%=professor[i]%>";
            document.getElementById("mon3").style.backgroundColor = "#58FAF4";
            <%}%>
            <%if(day1[i].equals("Mon")&&time1[i].equals("15:00~17:00")){%>
            document.getElementById("mon4").innerText = "<%=subject[i]%>\n<%=professor[i]%>";
            document.getElementById("mon4").style.backgroundColor = " ";
            <%}%>
            //Tue
            <%if(day1[i].equals("Tue")&&time1[i].equals("09:00~11:00")){%>
            document.getElementById("tue1").innerText = "<%=subject[i]%>\n<%=professor[i]%>";
            document.getElementById("tue1").style.backgroundColor = " ";
            <%}%>
            <%if(day1[i].equals("Tue")&&time1[i].equals("11:00~13:00")){%>
            document.getElementById("tue2").innerText = "<%=subject[i]%>\n<%=professor[i]%>";
            document.getElementById("tue2").style.backgroundColor = "#81F781";
            <%}%>
            <%if(day1[i].equals("Tue")&&time1[i].equals("13:00~15:00")){%>
            document.getElementById("tue3").innerText = "<%=subject[i]%>\n<%=professor[i]%>";
            document.getElementById("tue3").style.backgroundColor = "#FFFF00";
            <%}%>
            <%if(day1[i].equals("Tue")&&time1[i].equals("15:00~17:00")){%>
            document.getElementById("tue4").innerText = "<%=subject[i]%>\n<%=professor[i]%>";
            document.getElementById("tue4").style.backgroundColor = "#BE81F7";
            <%}%>
            //Wed            
            <%if(day1[i].equals("Wed")&&time1[i].equals("09:00~11:00")){%>
            document.getElementById("wed1").innerText = "<%=subject[i]%>\n<%=professor[i]%>";
            document.getElementById("wed1").style.backgroundColor = "#F781F3";
            <%}%>
            <%if(day1[i].equals("Wed")&&time1[i].equals("11:00~13:00")){%>
            document.getElementById("wed2").innerText = "<%=subject[i]%>\n<%=professor[i]%>";
            document.getElementById("wed2").style.backgroundColor = "";
            <%}%>
            <%if(day1[i].equals("Wed")&&time1[i].equals("13:00~15:00")){%>
            document.getElementById("wed3").innerText = "<%=subject[i]%>\n<%=professor[i]%>";
            document.getElementById("wed3").style.backgroundColor = "#81F781";
            <%}%>
            <%if(day1[i].equals("Wed")&&time1[i].equals("15:00~17:00")){%>
            document.getElementById("wed4").innerText = "<%=subject[i]%>\n<%=professor[i]%>";
            document.getElementById("wed4").style.backgroundColor = "#FFBF00";
            <%}%>
            //Thr
            <%if(day1[i].equals("Thr")&&time1[i].equals("09:00~11:00")){%>
            document.getElementById("thr1").innerText = "<%=subject[i]%>\n<%=professor[i]%>";
            document.getElementById("thr1").style.backgroundColor = "#FFBF00";
            <%}%>
            <%if(day1[i].equals("Thr")&&time1[i].equals("11:00~13:00")){%>
            document.getElementById("thr2").innerText = "<%=subject[i]%>\n<%=professor[i]%>";
            document.getElementById("thr2").style.backgroundColor = "#A4A4A4";
            <%}%>
            <%if(day1[i].equals("Thr")&&time1[i].equals("13:00~15:00")){%>
            document.getElementById("thr3").innerText = "<%=subject[i]%>\n<%=professor[i]%>";
            document.getElementById("thr3").style.backgroundColor = "#F78181";
            <%}%>
            <%if(day1[i].equals("Thr")&&time1[i].equals("15:00~17:00")){%>
            document.getElementById("thr4").innerText = "<%=subject[i]%>\n<%=professor[i]%>";
            document.getElementById("thr4").style.backgroundColor = "#58FAF4";
            <%}%>
            //Fri
            <%if(day1[i].equals("Fri")&&time1[i].equals("09:00~11:00")){%>
            document.getElementById("fri1").innerText = "<%=subject[i]%>\n<%=professor[i]%>";
            document.getElementById("fri1").style.backgroundColor = "#FFFF00";
            <%}%>
            <%if(day1[i].equals("Fri")&&time1[i].equals("11:00~13:00")){%>
            document.getElementById("fri2").innerText = "<%=subject[i]%>\n<%=professor[i]%>";
            document.getElementById("fri2").style.backgroundColor = "#BE81F7";
            <%}%>
            <%if(day1[i].equals("Fri")&&time1[i].equals("13:00~15:00")){%>
            document.getElementById("fri3").innerText = "<%=subject[i]%>\n<%=professor[i]%>";
            document.getElementById("fri3").style.backgroundColor = "#F78181";
            <%}%>
            <%if(day1[i].equals("Fri")&&time1[i].equals("15:00~17:00")){%>
            document.getElementById("fri4").innerText = "<%=subject[i]%>\n<%=professor[i]%>";
            document.getElementById("fri4").style.backgroundColor = "";
            <%}%>
            //////////////////////////////////////////////////////////
          //Mon
            <%if(day2[i].equals("Mon")&&time2[i].equals("09:00~11:00")){%>
            document.getElementById("mon1").innerText = "<%=subject[i]%>\n<%=professor[i]%>";
            document.getElementById("mon1").style.backgroundColor = "#F781F3";
            <%}%>
            <%if(day2[i].equals("Mon")&&time2[i].equals("11:00~13:00")){%>
            document.getElementById("mon2").innerText = "<%=subject[i]%>\n<%=professor[i]%>";
            document.getElementById("mon2").style.backgroundColor = "#A4A4A4";
            <%}%>
            <%if(day2[i].equals("Mon")&&time2[i].equals("13:00~15:00")){%>
            document.getElementById("mon3").innerText = "<%=subject[i]%>\n<%=professor[i]%>";
            document.getElementById("mon3").style.backgroundColor = "#58FAF4";
            <%}%>
            <%if(day2[i].equals("Mon")&&time2[i].equals("15:00~17:00")){%>
            document.getElementById("mon4").innerText = "<%=subject[i]%>\n<%=professor[i]%>";
            document.getElementById("mon4").style.backgroundColor = " ";
            <%}%>
            //Tue
            <%if(day2[i].equals("Tue")&&time2[i].equals("09:00~11:00")){%>
            document.getElementById("tue1").innerText = "<%=subject[i]%>\n<%=professor[i]%>";
            document.getElementById("tue1").style.backgroundColor = " ";
            <%}%>
            <%if(day2[i].equals("Tue")&&time2[i].equals("11:00~13:00")){%>
            document.getElementById("tue2").innerText = "<%=subject[i]%>\n<%=professor[i]%>";
            document.getElementById("tue2").style.backgroundColor = "#81F781";
            <%}%>
            <%if(day2[i].equals("Tue")&&time2[i].equals("13:00~15:00")){%>
            document.getElementById("tue3").innerText = "<%=subject[i]%>\n<%=professor[i]%>";
            document.getElementById("tue3").style.backgroundColor = "#FFFF00";
            <%}%>
            <%if(day2[i].equals("Tue")&&time2[i].equals("15:00~17:00")){%>
            document.getElementById("tue4").innerText = "<%=subject[i]%>\n<%=professor[i]%>";
            document.getElementById("tue4").style.backgroundColor = "#BE81F7";
            <%}%>
            //Wed            
            <%if(day2[i].equals("Wed")&&time2[i].equals("09:00~11:00")){%>
            document.getElementById("wed1").innerText = "<%=subject[i]%>\n<%=professor[i]%>";
            document.getElementById("wed1").style.backgroundColor = "#F781F3";
            <%}%>
            <%if(day2[i].equals("Wed")&&time2[i].equals("11:00~13:00")){%>
            document.getElementById("wed2").innerText = "<%=subject[i]%>\n<%=professor[i]%>";
            document.getElementById("wed2").style.backgroundColor = "";
            <%}%>
            <%if(day2[i].equals("Wed")&&time2[i].equals("13:00~15:00")){%>
            document.getElementById("wed3").innerText = "<%=subject[i]%>\n<%=professor[i]%>";
            document.getElementById("wed3").style.backgroundColor = "#81F781";
            <%}%>
            <%if(day2[i].equals("Wed")&&time2[i].equals("15:00~17:00")){%>
            document.getElementById("wed4").innerText = "<%=subject[i]%>\n<%=professor[i]%>";
            document.getElementById("wed4").style.backgroundColor = "#FFBF00";
            <%}%>
            //Thr
            <%if(day2[i].equals("Thr")&&time2[i].equals("09:00~11:00")){%>
            document.getElementById("thr1").innerText = "<%=subject[i]%>\n<%=professor[i]%>";
            document.getElementById("thr1").style.backgroundColor = "#FFBF00";
            <%}%>
            <%if(day2[i].equals("Thr")&&time2[i].equals("11:00~13:00")){%>
            document.getElementById("thr2").innerText = "<%=subject[i]%>\n<%=professor[i]%>";
            document.getElementById("thr2").style.backgroundColor = "#A4A4A4";
            <%}%>
            <%if(day2[i].equals("Thr")&&time2[i].equals("13:00~15:00")){%>
            document.getElementById("thr3").innerText = "<%=subject[i]%>\n<%=professor[i]%>";
            document.getElementById("thr3").style.backgroundColor = "#F78181";
            <%}%>
            <%if(day2[i].equals("Thr")&&time2[i].equals("15:00~17:00")){%>
            document.getElementById("thr4").innerText = "<%=subject[i]%>\n<%=professor[i]%>";
            document.getElementById("thr4").style.backgroundColor = "#58FAF4";
            <%}%>
            //Fri
            <%if(day2[i].equals("Fri")&&time2[i].equals("09:00~11:00")){%>
            document.getElementById("fri1").innerText = "<%=subject[i]%>\n<%=professor[i]%>";
            document.getElementById("fri1").style.backgroundColor = "#FFFF00";
            <%}%>
            <%if(day2[i].equals("Fri")&&time2[i].equals("11:00~13:00")){%>
            document.getElementById("fri2").innerText = "<%=subject[i]%>\n<%=professor[i]%>";
            document.getElementById("fri2").style.backgroundColor = "#BE81F7";
            <%}%>
            <%if(day2[i].equals("Fri")&&time2[i].equals("13:00~15:00")){%>
            document.getElementById("fri3").innerText = "<%=subject[i]%>\n<%=professor[i]%>";
            document.getElementById("fri3").style.backgroundColor = "#F78181";
            <%}%>
            <%if(day2[i].equals("Fri")&&time2[i].equals("15:00~17:00")){%>
            document.getElementById("fri4").innerText = "<%=subject[i]%>\n<%=professor[i]%>";
            document.getElementById("fri4").style.backgroundColor = "";
            <%}%>
      <%}%>
   };
</script>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <%@include file="../base/userHeader.jsp"%>
<h1 align="center">시간표</h1>
   <table border="1" width="900px" align="center">
      <tr align="center">
         <th width="50px" height="70px"></th>
         <th width="150px">월요일</th>
         <th width="150px">화요일</th>
         <th width="150px">수요일</th>
         <th width="150px">목요일</th>
         <th width="150px">금요일</th>
      </tr>
      <tr align="center">
         <td height="120px">09:00<br>~<br>11:00</td>
         <td id="mon1"></td>
         <td id="tue1"></td>
         <td id="wed1"></td>
         <td id="thr1"></td>
         <td id="fri1"></td>
      </tr>
      <tr align="center">
         <td height="120px">11:00<br>~<br>13:00</td>
         <td id="mon2"></td>
         <td id="tue2"></td>
         <td id="wed2"></td>
         <td id="thr2"></td>
         <td id="fri2"></td>
      </tr>
      <tr align="center">
         <td height="120px">13:00<br>~<br>15:00</td>
         <td id="mon3"></td>
         <td id="tue3"></td>
         <td id="wed3"></td>
         <td id="thr3"></td>
         <td id="fri3"></td>
      </tr>
      <tr align="center">
         <td height="120px">15:00<br>~<br>17:00</td>
         <td id="mon4"></td>
         <td id="tue4"></td>
         <td id="wed4"></td>
         <td id="thr4"></td>
         <td id="fri4"></td>
      </tr>
   </table>

   <%@include file="../base/footer.jsp"%>
</body>
</html>