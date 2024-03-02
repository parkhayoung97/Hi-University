package com.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.board.dto.CmtDTO;
import com.board.dto.EvalDTO;

import util.DBManager;

public class EvalDAO {
	
	private EvalDAO() {
		// TODO Auto-generated constructor stub
	}
	
	private static EvalDAO instance = new EvalDAO();
	
	public static EvalDAO getInstance() {
		return instance;
	}
	
	// 강의 정보 전체 조회
	public List<EvalDTO> selectAllEvals(){
		String sql = "select * from eval_list order by subject";
		List<EvalDTO> list = new ArrayList<>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				EvalDTO dto = new EvalDTO();
				dto.setSubject(rs.getString("subject"));
				dto.setProfessor(rs.getString("professor"));
				dto.setContent(rs.getString("content"));
				list.add(dto);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, stmt, rs);
		}return list;
	}
	
	// 강의 평가 목록 보기
		public List<CmtDTO> selectAllComments(){
			String sql = "select * from eval_score order by subject";
			List<CmtDTO> list = new ArrayList<CmtDTO>();
			Connection conn = null;
			Statement stmt = null;
			ResultSet rs = null;
			try {
				conn = DBManager.getConnection();
				stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
				while(rs.next()) {
					CmtDTO dto = new CmtDTO();
					dto.setNum(rs.getInt("num"));
					dto.setSubject(rs.getString("subject"));
					dto.setContent(rs.getString("content"));
					dto.setId(rs.getString("id"));
					dto.setTotalScore(rs.getString("totalScore"));
					dto.setScore(rs.getString("score"));
					dto.setLectureScore(rs.getString("lectureScore"));				
					list.add(dto);
				}
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				DBManager.close(conn, stmt, rs);
			}return list;
			
		}
		
		// 강의평가 등록
		public void insertComment(CmtDTO dto) {
			String sql = "insert into eval_score values(eval_seq.nextval,?,?,?,?,?,?)";
			Connection conn = null;
			PreparedStatement pstmt = null;
			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, dto.getSubject());
				pstmt.setString(2, dto.getId());
				pstmt.setString(3, dto.getContent());
				pstmt.setString(4, dto.getTotalScore());
				pstmt.setString(5, dto.getScore());
				pstmt.setString(6, dto.getLectureScore());
				pstmt.executeUpdate();
			}catch (SQLException e) {
				e.printStackTrace();
			}finally {
				DBManager.close(conn, pstmt);
			}
		}
		
		// 강의 평가 상세 조회
		public CmtDTO selectOneEval(int num) {
			String sql = "select * from eval_score where num=?";
			CmtDTO dto = null;
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, num);// 이 부분 고치기
				rs = pstmt.executeQuery();
				if(rs.next()) {
					dto = new CmtDTO();
					dto.setNum(rs.getInt("num"));
					dto.setSubject(rs.getString("subject"));
					dto.setContent(rs.getString("content"));
					dto.setTotalScore(rs.getString("totalScore"));
					dto.setScore(rs.getString("score"));
					dto.setLectureScore(rs.getString("lectureScore"));
				}
			}catch (SQLException e) {
				e.printStackTrace();
			}finally {
				DBManager.close(conn, pstmt, rs);
			}return dto;
		}
		
		// 강의 평가 수정
		public void updateComment(CmtDTO dto) {
			String sql = "update eval_score set content=?, totalScore=?, score=?, lectureScore=? where num=?";
			Connection conn = null;
			PreparedStatement pstmt = null;
			try {
				conn =DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, dto.getContent());
				pstmt.setString(2, dto.getTotalScore());
				pstmt.setString(3, dto.getScore());
				pstmt.setString(4, dto.getLectureScore());
				pstmt.setInt(5, dto.getNum());
				pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
	}
		
	// 강의 평가 삭제
	public void deleteComment(int num) {
		String sql = "delete eval_score where num=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn= DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			
			pstmt.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
	}

}
