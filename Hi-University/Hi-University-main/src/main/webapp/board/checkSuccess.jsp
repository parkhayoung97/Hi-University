<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	if(window.name == 'update') {	// 수정
		// BoardUpdateFormAction
		window.opener.parent.location.href="BoardServlet?command=board_update_form&type=${param.type}&seq=${param.seq}";
	}else if(window.name == 'delete') {	// 삭제
		alert('삭제되었습니다');
		// BoardDeleteAction
		window.opener.parent.location.href="BoardServlet?command=board_delete&type=${param.type}&seq=${param.seq}&tpage=1";
	}
	window.close();
</script>
</head>
<body>
	
</body>
</html>