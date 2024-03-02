package com.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.user.dto.DepartmentDTO;
import com.user.dto.UserDTO;

import util.DBManager;

public class UserDAO {
	
	private UserDAO() {
		// TODO Auto-generated constructor stub
	}
	
	private static UserDAO instance = new UserDAO();
	
	public static UserDAO getInstance() {
		return instance;
	}

	// 로그인
	public int login(String id, String pwd) {
		String sql = "select pwd from student_info where id =?";
		if(id.length() == 7) {	// 관리자
			sql = "select pwd from admin where id=?";
		}
		System.out.println(sql);
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = -1;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				if(pwd.equals(rs.getString("pwd"))) {
					result = 1;
				}else {
					result = 0;
				}
			}else {
				result = -1;
			}
			System.out.println(result);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return result;
	}
	
	// 상태
	public String status(String id) {
		String sql = "select status from student_info where id =?";
		String status = null;
		if(id.length() == 7) {	// 관리자
			sql = "select status from admin where id=?";
		}
		System.out.println(sql);
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				status = rs.getString("status");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return status;
	}
	
	// 정보 수정
		public void updateUser(UserDTO dto) {
			String sql = "update student_info set pwd=?, phone=?, email=?, address=? where id=?";
			Connection conn = null;
			PreparedStatement pstmt = null;
			
			try {
				
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				System.out.println(sql);
				pstmt.setString(1, dto.getPwd());
				pstmt.setString(2, dto.getPhone());
				pstmt.setString(3, dto.getEmail());
				pstmt.setString(4, dto.getAddress());
				pstmt.setString(5, dto.getId());
				pstmt.executeUpdate();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			finally {
				DBManager.close(conn, pstmt);;
			}
		}
	
	// 별명 검색
	public String checkNick(String id) {
		String sql = "select nickname from student_info where id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String nickname = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				nickname = rs.getString("nickname");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return nickname;
	}
	
	// 별명 중복 체크
	public int confirmNick(String nick) {
		String sql = "select nickname from student_info where nickname=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = -1;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, nick);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = 1;	// 별명 있음
			}else {
				result = -1;	// 별명 없음
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return result;
	}
	
	// 별명 추가
	public void updateNickname(String nickname, String id) {
		String sql = "update student_info set nickname=? where id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, nickname);
			pstmt.setString(2, id);
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	/* 관리자 */
	// 학생 정보 리스트 조회
	public List<UserDTO> selectAllStudent() {
		String url = "select * from student_info order by id asc";
		List<UserDTO> list = new ArrayList<>();
			
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
			
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(url);
			rs = pstmt.executeQuery(url);
				
			while(rs.next()) {
				UserDTO dto = new UserDTO();
				dto.setId(rs.getString("id"));
				dto.setName(rs.getString("name"));
				dto.setStatus(rs.getString("status"));
				dto.setDepartment(rs.getString("department"));
//				dto.setPhone(rs.getString("phone"));
//				dto.setEmail(rs.getString("email"));
//				dto.setBirth(rs.getInt("birth"));
//				dto.setAddress(rs.getString("address"));			
				list.add(dto);
			}
				
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}	
	
	// 학생 정보 상세 조회
	public UserDTO selectOneInfoById(String id) {
		String url = "select * from student_info where id=?";
		
		UserDTO dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(url);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dto = new UserDTO();
				dto.setId(rs.getString("id"));
				dto.setPwd(rs.getString("pwd"));
				dto.setName(rs.getString("name"));
				dto.setDepartment(rs.getString("department"));
				dto.setPhone(rs.getString("phone"));
				dto.setEmail(rs.getString("email"));
				dto.setBirth(rs.getString("birth"));
				dto.setAddress(rs.getString("address"));
				dto.setStatus(rs.getString("status"));
			}	
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			DBManager.close(conn, pstmt, rs);;
		}
		return dto;
	}
	
	// 학생 추가
	public void insertStudent(UserDTO dto) {
		String sql = "insert into student_info(id,pwd,name,status,department,phone,email,birth,address) values(?,?,?,?,?,?,?,?,?)";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPwd());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.getStatus());
			pstmt.setString(5, dto.getDepartment());
			pstmt.setString(6, dto.getPhone());
			pstmt.setString(7, dto.getEmail());
			pstmt.setString(8, dto.getBirth());
			pstmt.setString(9, dto.getAddress());
			
			pstmt.executeUpdate();	
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	// 학생 수정
	public void updateStudent(UserDTO dto) {
		String sql = "update student_info set pwd=?, name=?, department=?, phone=?, email=?, birth=?, address=?, status=? where id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			System.out.println(sql);
			pstmt.setString(1, dto.getPwd());
			pstmt.setString(2, dto.getName());
			pstmt.setString(3, dto.getDepartment());
			pstmt.setString(4, dto.getPhone());
			pstmt.setString(5, dto.getEmail());
			pstmt.setString(6, dto.getBirth());
			pstmt.setString(7, dto.getAddress());
			pstmt.setString(8, dto.getStatus());
			pstmt.setString(9,  dto.getId());
			pstmt.executeUpdate();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			DBManager.close(conn, pstmt);;
		}
	}
	
	// 학생 삭제
	public void deleteStudent(String id) {
		String sql = "delete from student_info where id=?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			DBManager.close(conn, pstmt);
		}
		
	}
	
	// 학과 전체 조회
	public List<DepartmentDTO> selectAllDept() {
		String url = "select * from department_list";
		List<DepartmentDTO> list = new ArrayList<>();
			
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
			
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(url);
			rs = pstmt.executeQuery(url);
				
			while(rs.next()) {
				DepartmentDTO dto = new DepartmentDTO();
				dto.setCollege(rs.getString("college"));
				dto.setDepartment(rs.getString("department"));		
				list.add(dto);
			}		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}	
	
}
