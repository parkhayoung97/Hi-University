package com.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.board.dto.BoardDTO;
import com.board.dto.CommentsDTO;

import util.DBManager;

public class BoardDAO {

	private BoardDAO() {
		// TODO Auto-generated constructor stub
	}

	private static BoardDAO instance = new BoardDAO();

	public static BoardDAO getInstance() {
		return instance;
	}

	// 게시글 전체 조회 - 페이징
	public List<BoardDTO> selectAll(int type, int tpage, int view_rows) {
		String sql = "select seq,nickname,title,content,writedate " + 
					 "from " + 
					 "(" + 
					 "select " + 
					 "rownum as rnum " + 
					 ",A.seq, A.nickname, A.title, A.content, A.writedate " + 
					 "from (" + "select seq,nickname,title,content, writedate " + 
					 "from board " + "where type = ? " + 
					 "order by seq desc " + 
					 ") A " + 
					 " ) " + 
					 "where rnum > "
					 + ((tpage - 1) * view_rows) + 
					 " and rnum <= " + (tpage * view_rows);
//		String sql = "select * from board where type=? order by seq desc";
		System.out.println(sql);
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<BoardDTO> list = new ArrayList<>();
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, type);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				BoardDTO dto = new BoardDTO();
				dto.setSeq(rs.getInt("seq"));
				dto.setNickname(rs.getString("nickname"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setWritedate(rs.getTimestamp("writedate"));
				list.add(dto);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}

	// 전체 게시글 수 - 페이징
	public int selectCount(int type) {
		String sql = "select count(1) from board where type=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int count = 0;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, type);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return count;
	}

	// 게시글 3번째 글까지 조회
	public List<BoardDTO> selectAll5(int type) {
		String sql = "select * from (select rownum rnum, board1.* from(select * from board where type=" + type
				+ " order by seq desc)board1) where rnum <= 2";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<BoardDTO> list = new ArrayList<>();
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			// pstmt.setInt(1, type);
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				BoardDTO dto = new BoardDTO();
				dto.setSeq(rs.getInt("seq"));
				dto.setNickname(rs.getString("nickname"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setWritedate(rs.getTimestamp("writedate"));
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		return list;
	}

	// 게시글 검색 조회
	public List<BoardDTO> searchBoard(String searchType, String search, int type, int tpage) {
		int view_rows = 4;
//		String sql = "select * from board where type=? and " + searchType + " like '%" + search + "%'";
		String sql = "select seq,nickname,title,content,writedate " + "from " + "(" + "select " + "rownum as rnum "
				+ ",A.seq, A.nickname, A.title, A.content, A.writedate " + "from (" + "select seq,nickname,title,content,writedate "
				+ "from board " + "where type = ? " + "and " + searchType + " like '%" + search + "%' "
				+ "order by seq desc " + ") A " + " ) " + "where rnum > " + ((tpage - 1) * view_rows) + " and rnum <= "
				+ (tpage * view_rows);
		System.out.println(sql);
		System.out.println("test");
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<BoardDTO> list = new ArrayList<>();
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, type);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				BoardDTO dto = new BoardDTO();
				dto.setSeq(rs.getInt("seq"));
				dto.setNickname(rs.getString("nickname"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setWritedate(rs.getTimestamp("writedate"));
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}

	// 게시글 검색 조회 개수
	public int searchCount(String searchType, String search, int type) {
		String sql = "select count(1) from board where type=? and " + searchType + " like '%" + search + "%'";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, type);
			rs = pstmt.executeQuery();
			System.out.println(sql);
			if (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return count;
	}

	// 게시글 하나 조회
	public BoardDTO selectOne(int seq) {
		String sql = "select * from board where seq=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BoardDTO dto = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, seq);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				dto = new BoardDTO();
				dto.setSeq(rs.getInt("seq"));
				dto.setId(rs.getString("id"));
				dto.setNickname(rs.getString("nickname"));
				dto.setTitle(rs.getString("title"));
				dto.setPass(rs.getString("pass"));
				dto.setContent(rs.getString("content"));
				dto.setFilename(rs.getString("filename"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return dto;
	}

	// 게시글 등록
	public void insertBoard(BoardDTO dto) {
		String sql = "insert into board values(board_seq.nextval,?,?,?,?,?,?,sysdate,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			pstmt.setInt(2, dto.getType());
			pstmt.setString(3, dto.getNickname());
			pstmt.setString(4, dto.getTitle());
			pstmt.setString(5, dto.getPass());
			pstmt.setString(6, dto.getContent());
			pstmt.setString(7, dto.getFilename());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	// 게시글 수정
	public void updateBoard(BoardDTO dto) {
		String sql = "update board set title=?, pass=?, content=?, filename=? where seq=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getPass());
			pstmt.setString(3, dto.getContent());
			pstmt.setString(4, dto.getFilename());
			pstmt.setInt(5, dto.getSeq());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	// 게시글 삭제
	public void deleteBoard(int seq) {
		String sql = "delete from board where seq=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, seq);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	/* 댓글 */
	// 댓글 조회
	public List<CommentsDTO> commentList(int board_seq) {
		String sql = "select * from comments where board_seq=? order by writedate desc";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<CommentsDTO> list = new ArrayList<>();
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, board_seq);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				CommentsDTO dto = new CommentsDTO();
				dto.setBoard_seq(rs.getInt("board_seq"));
				dto.setComment_seq(rs.getInt("comment_seq"));
				dto.setId(rs.getString("id"));
				dto.setNickname(rs.getString("nickname"));
				dto.setWritedate(rs.getTimestamp("writedate"));
				dto.setContent(rs.getString("content"));
				list.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
	
	// 댓글 작성
	public void insertComment(CommentsDTO dto) {
		String sql = "insert into comments values(comment_seq.nextval,?,?,?,sysdate,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getBoard_seq());
			pstmt.setString(2, dto.getId());
			pstmt.setString(3, dto.getNickname());
			pstmt.setString(4, dto.getContent());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	// 댓글 삭제
	public void deleteComment(int seq) {
		String sql = "delete from comments where comment_seq=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, seq);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	// 마이페이지 게시글 상위 3개 조회
	public List<BoardDTO> selectAllById(String id) {
		String sql ="select * from (select rownum rnum, board1.* from(select * from board where id=? "
				+ " order by seq desc)board1) where rnum <= 3";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<BoardDTO> list = new ArrayList<>();
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				BoardDTO dto = new BoardDTO();
				dto.setSeq(rs.getInt("seq"));
				dto.setType(rs.getInt("type"));
				dto.setNickname(rs.getString("nickname"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setWritedate(rs.getTimestamp("writedate"));
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}

}
