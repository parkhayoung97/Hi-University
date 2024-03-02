package com.board.controller;

import com.board.controller.action.BoardCheckPassAction;
import com.board.controller.action.BoardCheckPassFormAction;
import com.board.controller.action.BoardDeleteAction;
import com.board.controller.action.BoardListAction;
import com.board.controller.action.BoardMainAction;
import com.board.controller.action.BoardSearchAction;
import com.board.controller.action.BoardUpdateAction;
import com.board.controller.action.BoardUpdateFormAction;
import com.board.controller.action.BoardViewAction;
import com.board.controller.action.BoardWriteAction;
import com.board.controller.action.BoardWriteFormAction;
import com.board.controller.action.CmtCommentAction;
import com.board.controller.action.CmtDeleteAction;
import com.board.controller.action.CmtUpdateAction;
import com.board.controller.action.CmtUpdateFormAction;
import com.board.controller.action.CmtWriteAction;
import com.board.controller.action.CmtWriteFormAction;
import com.board.controller.action.CommentDeleteAction;
import com.board.controller.action.CommentWriteAction;
import com.board.controller.action.EvalListAction;
import com.board.controller.action.MyPageAction;
import com.board.dto.BoardDTO;

import util.Action;
import util.DBManager;

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
		
		/* 게시판 */
		if(command.equals("board_list")) {	// 게시판 전체 조회
			action = new BoardListAction();
		}else if(command.equals("board_view")) {	// 게시글 상세 조회
			action = new BoardViewAction();
		}else if(command.equals("board_write_form")) {	// 게시글 작성 폼 이동
			action = new BoardWriteFormAction();
		}else if(command.equals("board_write")) {	// 게시글 작성
			action = new BoardWriteAction();
		}else if(command.equals("board_main")) {	// 게시판 메인 화면 이동
			action = new BoardMainAction();
		}else if(command.equals("board_check_pass_form")) {	 // 게시글 수정/삭제 비밀번호 확인 페이지 이동
			action = new BoardCheckPassFormAction();
		}else if(command.equals("board_check_pass")) {	// 게시글 수정/삭제 비밀번호 확인
			action = new BoardCheckPassAction();
		}else if(command.equals("board_update_form")) {	// 게시글 수정 페이지 이동
			action = new BoardUpdateFormAction();
		}else if(command.equals("board_update")) {	// 게시글 수정
			action = new BoardUpdateAction();
		}else if(command.equals("board_delete")) {	// 게시글 삭제
			action = new BoardDeleteAction();
		}else if(command.equals("board_search")) {	// 게시글 검색
			action = new BoardSearchAction();
		}
		
		/* 댓글 */
		else if(command.equals("comment_write")) {	// 댓글 입력
			action = new CommentWriteAction();
		}else if(command.equals("comment_delete")) {	// 댓글 삭제
			action = new CommentDeleteAction();
		}
		
		/* 강의정보 */
		else if(command.equals("eval_list")) {	// 강의 정보 페이지 이동
			action = new EvalListAction();
		}
		
		/* 강의평가 */
		else if(command.equals("comment")) {	// 강의 평가 페이지 이동
			action = new CmtCommentAction();
		}else if(command.equals("cmt_write_form")) {	// 강의 평가 작성 페이지 이동
			action = new CmtWriteFormAction();
		}else if(command.equals("cmt_Write")) {	// 강의 평가 작성 실행
			action = new CmtWriteAction();
		}else if(command.equals("cmt_update_form")) {	// 강의 평가 수정 페이지 이동
			action = new CmtUpdateFormAction();
		}else if(command.equals("cmt_update")) {	// 강의 평가 수정 실행
			action = new CmtUpdateAction();
		}else if(command.equals("cmt_delete")) {	// 강의 평가 삭제 실행
			action = new CmtDeleteAction();
		}
		
		/* 마이페이지 */
		else if(command.equals("my_page")) {
			action = new MyPageAction();
		}else if(command.equals("board_view_my")) {
			action = new BoardViewAction();
		}
		
		return action;
	}

}
