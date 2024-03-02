package com.user.dto;

public class DepartmentDTO {
	
	private String college;
	private String department;
	
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
	
	@Override
	public String toString() {
		return "DepartmentDTO [college=" + college + ", department=" + department + "]";
	}

}
