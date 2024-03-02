package com.subject.controller;


import com.subject.controller.action.BasketAddAction;
import com.subject.controller.action.BasketDeleteAction;
import com.subject.controller.action.FirstGradeStudentListAction;
import com.subject.controller.action.GradeInsertAction;
import com.subject.controller.action.GradeSubjectListAction;
import com.subject.controller.action.GradeSubjectViewAction;
import com.subject.controller.action.StudentGradeAction;
import com.subject.controller.action.SubjectInsertAction;
import com.subject.controller.action.SubjectInsertFormAction;
import com.subject.controller.action.SubjectListAction;
import com.subject.controller.action.SubjectListFormAction;
import com.subject.controller.action.UserTableAction;
import com.subject.controller.action.UserTimeTableAction;

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
		
		/* 수강 신청 */
		if(command.equals("subject_list_form")) {	// 게시판 전체 조회
			action = new SubjectListFormAction();
		}
		
		/* 시간표 */
		else if(command.equals("user_table")) {
			action = new UserTableAction();         // 나의 시간표
		}
		else if(command.equals("time_table")) {
			action = new UserTimeTableAction();         // 전체 강의 시간표
		}
		
		
		/* 과목 */
		else if(command.equals("subject_list")) {	// 과목 조회 페이지 이동
			action = new SubjectListAction();
		}else if(command.equals("basket_add")) {	// 수강신청 페이지 이동
			action = new BasketAddAction();
		}else if(command.equals("basket_delete")) {
			action = new BasketDeleteAction();
		}else if(command.equals("subject_insert_form")) { //과목 등록 페이지 이동
			action = new SubjectInsertFormAction();
		}
		else if(command.equals("subject_insert")) { //과목 등록
			action = new SubjectInsertAction();
		}
		
		/* 성적 */
		else if(command.equals("grade_subject_list")) { // 성적 입력 가능한 과목 조회 페이지 이동
			action = new GradeSubjectListAction();
		}else if(command.equals("grade_subject_view")) {	// 성적 입력 가능한 과목 상세 조회 페이지 이동
			action = new GradeSubjectViewAction();
		}else if(command.equals("first_grade_student_list")) {	// 처음 성적 등록 페이지 이동
			action = new FirstGradeStudentListAction();
		}else if(command.equals("grade_insert")) {	// 성적 등록
			action = new GradeInsertAction();
		}else if(command.equals("student_grade")) {	// 유저 성적 조회 페이지 이동
			action = new StudentGradeAction();
		}
		
		return action;
	}

}
