/**
 * 
 */

 function idCheck() {	// 로그인 체크
	 
	 if(document.frm.id.value.length == 0) {
		 alert("아이디 입력");
		 document.frm.id.focus();
		 return false;
	 }
	 if(isNaN(document.frm.id.value)) {
		 alert("숫자만 입력");
		 document.frm.id.focus();
		 return false;
	 }
	 if(document.frm.pwd.value.length == 0) {
		 alert("비밀번호 입력");
		 document.frm.pwd.focus();
		 return false;
	 }
	 return true;
}

function nickCheck() {	// 별명 중복 체크
	if(document.frm.nickname.value.length == 0) {
		alert("아이디를 입력해주세요");
		document.frm.nickname.focus();
	}else {
		var url = "UserServlet?command=nick_check&nickname=" + document.frm.nickname.value;
		// 새 창으로 NickCheckAction 실행
		window.open(url, "_blank_1", "toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=450, height=200");
	}
}

function reCheck() {	// 별명 등록 확인
	if(document.frm.nickname.value.length == 0){
		alert("아이디를 입력해주세요");
		return false;
	}
	if(document.frm.re.value.length == 0) {
		alert("중복체크");
		return false;
	}
	if(document.frm.nickname.value != document.frm.re.value){
		alert("다시 중복체크")
		return false;
	}
	return true;
}

function nickOk(nickname) {	// 별명 중복 체크 후 적용
	// 기존 창에 새 창 값 적용
	opener.frm.nickname.value = document.frm.nickname.value;
	opener.frm.re.value = document.frm.nickname.value;
	self.close();	// 새 창 닫기
}

function InfoCheck() {
	if (document.frm.student_id.value.length==0) {
		alert("학번을 입력하세요.");
		return false;
	}
	if (isNaN(document.frm.student_id.value)) {
		alert("학번은 숫자만 입력하세요.");
		return false;
	}
	if (document.frm.pwd.value.length==0) {
		alert("비밀번호를 입력하세요.");
		return false;
	}
	if (document.frm.department.value==0) {
		alert("전공을 입력하세요.");
		return false;
	}
	if (document.frm.birth.value.length==0) {
		alert("생년월일을 입력하세요.");
		return false;
	}
	if (isNaN(document.frm.birth.value)) {
		alert("생년월일은 숫자만 입력하세요.");
		return false;
	}
	alert("등록이 완료되었습니다.");
	return true;
}