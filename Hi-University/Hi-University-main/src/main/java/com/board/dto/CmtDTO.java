package com.board.dto;

public class CmtDTO {
	
	private int num;
	private String subject;
	private String id;
	private String content;
	private String totalScore;
	private String score;
	private String lectureScore;

	public int getNum() {
		return num;
	}


	public void setNum(int num) {
		this.num = num;
	}


	public String getSubject() {
		return subject;
	}


	public void setSubject(String subject) {
		this.subject = subject;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public String getTotalScore() {
		return totalScore;
	}


	public void setTotalScore(String totalScore) {
		this.totalScore = totalScore;
	}


	public String getScore() {
		return score;
	}


	public void setScore(String score) {
		this.score = score;
	}


	public String getLectureScore() {
		return lectureScore;
	}


	public void setLectureScore(String lectureScore) {
		this.lectureScore = lectureScore;
	}
	
	@Override
	public String toString() {
		return "CmtDTO [num=" + num + ", subject=" + subject + ", id=" + id + ", content=" + content + ", totalScore="
				+ totalScore + ", score=" + score + ", lectureScore=" + lectureScore + "]";
	}

}
