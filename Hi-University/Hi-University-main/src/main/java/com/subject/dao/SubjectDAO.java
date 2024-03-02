package com.subject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.subject.dto.BasketDTO;
import com.subject.dto.GradeDTO;
import com.subject.dto.SubjectDTO;

import util.DBManager;

public class SubjectDAO {

	private SubjectDAO() {
		// TODO Auto-generated constructor stub
	}

	private static SubjectDAO instance = new SubjectDAO();

	public static SubjectDAO getInstance() {
		return instance;
	}

	/* 수강신청 */
	// 모든 수업 조회
	public List<SubjectDTO> selectAll() {
		String sql = "select * from subject";
		List<SubjectDTO> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				System.out.println(sql);
				SubjectDTO dto = new SubjectDTO();
				dto.setSubjectNum(rs.getInt("subjectNum"));
				dto.setCollege(rs.getString("college"));
				dto.setDepartment(rs.getString("department"));
				dto.setSubject(rs.getString("subject"));
				dto.setProfessor(rs.getString("professor"));
				dto.setScore(rs.getInt("score"));
				dto.setDay1(rs.getString("day1"));
				dto.setDay2(rs.getString("day2"));
				dto.setTime1(rs.getString("time1"));
				dto.setTime2(rs.getString("time2"));
				list.add(dto);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}

	// 강의 등록 메소드
	public void insertSubject(SubjectDTO bVo) {
		String sql = "insert into basket values(?,?,?,?,?,?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bVo.getCollege());
			pstmt.setString(2, bVo.getDepartment());
			pstmt.setInt(3, bVo.getSubjectNum());
			pstmt.setString(4, bVo.getSubject());
			pstmt.setString(5, bVo.getProfessor());
			pstmt.setInt(6, bVo.getScore());
			pstmt.setString(7, bVo.getDay1());
			pstmt.setString(8, bVo.getTime1());
			pstmt.setString(9, bVo.getDay2());
			pstmt.setString(10, bVo.getTime2());
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	// 중복 삭제 메소드
	public void deleteDuplicateData() {
		String sql = "DELETE FROM basket WHERE ROWID IN (SELECT ROWID FROM (SELECT * FROM (SELECT ROW_NUMBER() OVER(PARTITION BY subjectNum ORDER BY subjectNum) AS num FROM basket) WHERE num > 1))";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			// pstmt.setInt(1, subjectNum);
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	/* 성적 */
	// 유저의 성적 조회
	public List<GradeDTO> selectGradeAllById(String id) {
		String sql = "select * from grade where id = ? and grade is not null";
		List<GradeDTO> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				GradeDTO dto = new GradeDTO();
				dto.setid(rs.getString("id"));
				dto.setSubjectNum(rs.getInt("subjectNum"));
				dto.setName(rs.getString("name"));
				dto.setDepartment(rs.getString("department"));
				dto.setSubject(rs.getString("subject"));
				dto.setGrade(rs.getString("grade"));
				dto.setGrade_score(rs.getDouble("grade_score"));

				list.add(dto);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {

			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}

	// 과목을 듣는 학생 성적 조회 - 성적 있음
	public List<GradeDTO> selectAllid(int subjectNum) {
		String sql = "select id, name, grade, grade_score, subjectNum from grade where subjectNum = ? and grade is not null";
		List<GradeDTO> idList = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, subjectNum);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				GradeDTO dto = new GradeDTO();
				dto.setid(rs.getString("id"));
				dto.setName(rs.getString("name"));
				dto.setGrade(rs.getString("grade"));
				dto.setGrade_score(rs.getDouble("grade_score"));
				dto.setSubjectNum(rs.getInt("subjectNum"));
				idList.add(dto);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {

			DBManager.close(conn, pstmt, rs);
		}
		return idList;
	}

	// 과목을 듣는 학생 성적 조회 - 성적 없음
	public List<GradeDTO> selectAllFirstid(int subjectNum) {
		String sql = "select id, name, subjectNum from grade where subjectNum = ? and grade is null";
		List<GradeDTO> idList = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, subjectNum);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				GradeDTO dto = new GradeDTO();
				dto.setid(rs.getString("id"));
				dto.setName(rs.getString("name"));
				dto.setSubjectNum(rs.getInt("subjectNum"));
				idList.add(dto);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {

			DBManager.close(conn, pstmt, rs);
		}
		return idList;
	}

	// 성적 입력 메소드
	public void updateGrade(GradeDTO dto) {
		String sql = "update grade set grade=?, grade_score=? where id=? and subjectNum=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getGrade());
			pstmt.setDouble(2, dto.getGrade_score());
			pstmt.setString(3, dto.getid());
			pstmt.setInt(4, dto.getSubjectNum());
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	// 수강신청 메소드
	public void insertBasket(BasketDTO bVo) {
		String sql = "insert into basket values(?,?,?,?,?,?,?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		System.out.println(bVo.getDay1());
		System.out.println(bVo.getTime1());
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bVo.getCollege());
			pstmt.setString(2, bVo.getDepartment());
			pstmt.setInt(3, bVo.getSubjectNum());
			pstmt.setString(4, bVo.getSubject());
			pstmt.setString(5, bVo.getProfessor());
			pstmt.setInt(6, bVo.getScore());
			pstmt.setString(7, bVo.getDay1());
			pstmt.setString(8, bVo.getTime1());
			pstmt.setString(9, bVo.getDay2());
			pstmt.setString(10, bVo.getTime2());
			pstmt.setInt(11, bVo.getId());
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	// 수강신청 삭제 메소드
	public void deleteBasket(int subjectNum) {
		String sql = "delete from basket where subjectNum=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, subjectNum);

			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	// 수강신청 후 리스트 메소드
	public List<BasketDTO> showBasket(int id) {
		String sql = "select DISTINCT * from basket where id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<BasketDTO> list = new ArrayList<>();
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				BasketDTO bVo = new BasketDTO();
				bVo.setSubjectNum(rs.getInt("subjectNum"));
				bVo.setCollege(rs.getString("college"));
				bVo.setDepartment(rs.getString("department"));
				bVo.setSubject(rs.getString("subject"));
				bVo.setProfessor(rs.getString("professor"));
				bVo.setScore(rs.getInt("score"));
				bVo.setDay1(rs.getString("day1"));
				bVo.setDay2(rs.getString("day2"));
				bVo.setTime1(rs.getString("time1"));
				bVo.setTime2(rs.getString("time2"));
				bVo.setId(rs.getInt("id"));
				list.add(bVo);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}

	// 수강신청 후 리스트 메소드
	public BasketDTO showBasket2(int subjectNum) {
		String sql = "select DISTINCT * from basket where subjectNum=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BasketDTO bVo = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, subjectNum);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				bVo = new BasketDTO();
				bVo.setSubjectNum(rs.getInt("subjectNum"));
				bVo.setCollege(rs.getString("college"));
				bVo.setDepartment(rs.getString("department"));
				bVo.setSubject(rs.getString("subject"));
				bVo.setProfessor(rs.getString("professor"));
				bVo.setScore(rs.getInt("score"));
				bVo.setDay1(rs.getString("day1"));
				bVo.setDay2(rs.getString("day2"));
				bVo.setTime1(rs.getString("time1"));
				bVo.setTime2(rs.getString("time2"));
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return bVo;
	}

	// 해당 전공 수업만 가져오기
	public List<SubjectDTO> selectSubjectByDepartment(String department) {
		String sql = "select * from subject where department=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<SubjectDTO> list = new ArrayList<>();
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, department);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				SubjectDTO bVo = new SubjectDTO();
				bVo.setSubjectNum(rs.getInt("subjectNum"));
				bVo.setCollege(rs.getString("college"));
				bVo.setDepartment(rs.getString("department"));
				bVo.setSubject(rs.getString("subject"));
				bVo.setProfessor(rs.getString("professor"));
				bVo.setScore(rs.getInt("score"));
				bVo.setDay1(rs.getString("day1"));
				bVo.setDay2(rs.getString("day2"));
				bVo.setTime1(rs.getString("time1"));
				bVo.setTime2(rs.getString("time2"));

				list.add(bVo);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}

	// id로 학생 이름 가져오기('수강신청 OO님 수강신청입니다'에 활용)
	public String selectStudentNameByID(int id) {
		String sql = "select name from student_info where id =?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String name = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				name = rs.getString("name");

			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return name;
	}

	// id로 전공 이름 가져오기(본인 전공만 불러오는 용도로 활용)
	public String selectDepartmentByID(int id) {
		String sql = "select department from student_info where id =?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String department = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {

				department = rs.getString("department");

			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return department;
	}

	// 장바구니에 있는 모든 값 받아오기
	public List<BasketDTO> selectAllSub(int id) {
		String sql = "select * from basket where id=?";
		ArrayList<BasketDTO> blist = new ArrayList<>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				BasketDTO dto = new BasketDTO();
				dto.setSubjectNum(rs.getInt("subjectNum"));
				dto.setCollege(rs.getString("college"));
				dto.setDepartment(rs.getString("department"));
				dto.setSubject(rs.getString("subject"));
				dto.setProfessor(rs.getString("professor"));
				dto.setScore(rs.getInt("score"));
				dto.setDay1(rs.getString("day1"));
				dto.setDay2(rs.getString("day2"));
				dto.setTime1(rs.getString("time1"));
				dto.setTime2(rs.getString("time2"));
				blist.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return blist;
	}

	// 수강신청 할때 성적 컬럼 생성
	public void insertGrade(BasketDTO bVo, String name) {
		String sql = "insert into grade(id,subjectNum,college,department,subject,name) values(?,?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bVo.getId());
			pstmt.setInt(2, bVo.getSubjectNum());
			pstmt.setString(3, bVo.getCollege());
			pstmt.setString(4, bVo.getDepartment());
			pstmt.setString(5, bVo.getSubject());
			pstmt.setString(6, name);
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		System.out.println("성적생성");
	}

	// 수강신청 삭제할때 성적 칼럼 삭제
	public void deleteGrade(int id, int subjectNum) {
		String sql = "delete from grade where id=? and subjectNum=?";
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.setInt(2, subjectNum);
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		System.out.println("성적삭제");
	}

}
