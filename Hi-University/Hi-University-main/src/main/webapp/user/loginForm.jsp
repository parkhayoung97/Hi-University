<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
<link rel="stylesheet" type="text/css" href="css/table.css">
<script type="text/javascript" src="script/user.js"></script>
</head>
<body>
   <!-- 로그인 -->
   <header id="mainHeader">
      <h1 class="header1">
         <img alt=""> Hi University
      </h1>
   </header>
   <div id="login" align="center">
      <!-- LoginAction -->
      <div id=loginform>
         <form name="frm" method="post" action="UserServlet">         
	<input type="hidden" name = "command" value="login">
            <h1>Login Form</h1>
            <table style="width: 70%">
               <tr>
                  <td>ID</td>
                  <td><input type="text" name="id" style="width:300px; height:30px; font-size:20px;"></td>
               </tr>
               <tr>
                  <td>Password</td>
                  <td><input type="password" name="pwd" style="width:300px; height:30px; font-size:20px;"></td>
               </tr>
            </table>

            <!-- 버튼 -->
            <br><br><br><br><br> <input type="submit" value="로그인"
               onclick="return idCheck()" style="width:70px; height:30px;">&nbsp;&nbsp;&nbsp; <input type="reset" value="취 소" style="width:70px; height:30px;">
            <div>${message}</div>
         </form>
      </div>
   </div>

</body>
</html>