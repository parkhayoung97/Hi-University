package com.board.dto;

import java.sql.Timestamp;

public class CommentsDTO {

	private int board_seq;
	private int comment_seq;
	private String id;
	private String nickname;
	private String content;
	private Timestamp writedate;
	
	public int getBoard_seq() {
		return board_seq;
	}
	public void setBoard_seq(int board_seq) {
		this.board_seq = board_seq;
	}
	public int getComment_seq() {
		return comment_seq;
	}
	public void setComment_seq(int comment_seq) {
		this.comment_seq = comment_seq;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Timestamp getWritedate() {
		return writedate;
	}
	public void setWritedate(Timestamp writedate) {
		this.writedate = writedate;
	}
	
	@Override
	public String toString() {
		return "CommentDTO [board_seq=" + board_seq + ", comment_seq=" + comment_seq + ", id=" + id + ", nickname="
				+ nickname + ", content=" + content + ", writedate=" + writedate + "]";
	}

}

