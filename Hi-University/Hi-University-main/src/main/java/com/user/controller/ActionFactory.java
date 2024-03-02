package com.user.controller;

import com.user.controller.action.DepartmentListAction;
import com.user.controller.action.LoginAction;
import com.user.controller.action.LoginFormAction;
import com.user.controller.action.LogoutAction;
import com.user.controller.action.NickAction;
import com.user.controller.action.NickCheckAction;
import com.user.controller.action.StudentDeleteAction;
import com.user.controller.action.StudentInsertAction;
import com.user.controller.action.StudentInsertFormAction;
import com.user.controller.action.StudentListAction;
import com.user.controller.action.StudentUpdateAction;
import com.user.controller.action.StudentUpdateFormAction;
import com.user.controller.action.StudentViewAction;
import com.user.controller.action.UpdateInfoAction;
import com.user.controller.action.UpdateInfoFormAction;
import com.user.controller.action.UserInfoAction;
import com.user.controller.action.UserMainAction;

import util.Action;

public class ActionFactory {
	
	private ActionFactory() {
		// TODO Auto-generated constructor stub
	}
	
	private static ActionFactory instance = new ActionFactory();
	
	public static ActionFactory getInstance() {
		return instance;
	}
	
	public Action getAction(String command) {
		Action action = null;
		System.out.println("ActionFactory: " + command);
		
		if(command.equals("login_form")) {	// 로그인 창 이동
			action = new LoginFormAction();
		}else if(command.equals("login")) {	// 로그인 실행
			action = new LoginAction();
		}else if(command.equals("user_main")) {	// 메인페이지 이동
			action = new UserMainAction();
		}else if(command.equals("nick_check")) {	// 별명 중복 체크 페이지 이동
			action = new NickCheckAction();
		}else if(command.equals("nick")) {	// 별명 등록
			action = new NickAction();
		}else if(command.equals("logout")) {	// 로그아웃 실행
			action = new LogoutAction();
		}
		
		/* 학적 */
		else if(command.equals("user_info")) {	// 학생 정보 조회 페이지 이동
			action = new UserInfoAction();
		}else if(command.equals("update_info_form")) {	// 학생 정보 수정 페이지 이동
			action = new UpdateInfoFormAction();
		}else if(command.endsWith("update_info")) {	// 학생 정보 수정 실행
			action = new UpdateInfoAction();
		}
		
		/* 관리자 */
		// 학생
		else if(command.equals("student_list")) {	// 학생 목록 조회 페이지 이동
			action = new StudentListAction();
		}else if(command.equals("student_view")) {	// 학생 상세 조회 페이지 이동
			action = new StudentViewAction();
		}else if(command.equals("student_insert_form")) {	// 학생 추가 페이지 이동
			action = new StudentInsertFormAction();
		}else if(command.equals("student_insert")) {	// 학생 추가 실행
			action = new StudentInsertAction();
		}else if(command.equals("student_update_form")) {	// 학생 정보 수정 페이지 이동
			action = new StudentUpdateFormAction();
		}else if(command.equals("student_update")) {	// 학생 정보 수정 실행
			action = new StudentUpdateAction();
		}else if(command.equals("student_delete")) {	// 학생 삭제 실행
			action = new StudentDeleteAction();
		}
		
		// 학과
		else if(command.equals("department_list")) {
			action = new DepartmentListAction();
		}
		
		return action;
	}

}
