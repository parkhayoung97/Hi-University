package com.subject.dto;

public class GradeDTO {
	
	private String id;
	private int subjectNum;
	private String college;
	private String department;
	private String subject;
	private String name;
	private String grade;	
	private double grade_score;
	
	public String getid() {
		return id;
	}
	public void setid(String id) {
		this.id = id;
	}
	public int getSubjectNum() {
		return subjectNum;
	}
	public void setSubjectNum(int subjectNum) {
		this.subjectNum = subjectNum;
	}
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public double getGrade_score() {
		return grade_score;
	}
	public void setGrade_score(Double grade_score) {
		this.grade_score = grade_score;
	}
	
	
}
