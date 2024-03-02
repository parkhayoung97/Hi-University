/**
 * 
 */

 function writeCheck(type) {	// 게시글 작성 체크
	 var frmm = document.frm;
	 if(frmm.title.value.length == 0) {
		 alert("제목을 입력해주세요");
		 frmm.title.focus();	 
	 }else if(frmm.pass.value.length == 0) {
		 alert("비밀번호를 입력해주세요");
		 frmm.pass.focus();
	 }else if(frmm.pass.value.length != 4) {
		 alert("비밀번호는 4글자");
		 frmm.pass.value = "";
		 frmm.pass.focus();
	 }else{
		// BoardWriteAction
		frmm.action = "BoardServlet?command=board_write&type=" + type + "&tpage=1";
	 	frmm.submit();
	 }	 
 }
 
 function search(type) {	// 게시글 작성 체크
	var frmm = document.frm;
	// BoardWriteAction
	frmm.action = "BoardServlet?command=board_search&type=" + type + "&tpage=1";
	frmm.submit(); 
 }
 
 function open_win(url, name) {	// 게시글 수정 삭제 비밀번호 체크 새 창 페이지
	 window.open(url, name, "width=500, height=230");
 }
 
 function passCheck() {	// 게시글 수정/삭제 비밀번호 체크
	 if(document.frm.pass.value.length == 0) {
		 alert("비밀번호를 입력하세요");
		 return false;
	 }
	 return true;
  }
  
  function updateCheck(seq, type) {	// 게시글 수정 체크
	 var frmm = document.frm;
	 if(frmm.title.value.length == 0) {
		 alert("제목을 입력해주세요");
		 frmm.title.focus();	 
	 }else if(frmm.pass.value.length == 0) {
		 alert("비밀번호를 입력해주세요");
		 frmm.pass.focus();
	 }else if(frmm.pass.value.length != 4) {
		 alert("비밀번호는 4글자");
		 frmm.pass.value = "";
		 frmm.pass.focus();
	 }else{
		// BoardUpdateAction
		frmm.action = "BoardServlet?command=board_update&type=" + type +"&seq=" + seq
	 	frmm.submit();
	 }	 
 }
  
  function commentCheck() {	// 댓글 입력 체크
	  var frmm = document.frm;
	  if(frmm.comment.value.length == 0) {
		  alert("내용을 입력해주세요");
		  frmm.comment.focus();
		  return false;
	  }
	  return true;
  }
 
  