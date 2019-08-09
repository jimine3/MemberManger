package co.yedam.membermanger.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import co.yedam.membermanger.common.DAO;
import co.yedam.membermanger.dto.BorderDto;

public class BorderDao {
	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;
	private BorderDto dto;
	
	public BorderDao() {
		conn = DAO.Conn();
	}
	
	public ArrayList<BorderDto> select(){ //게시판 전체 목록을 가져 오는 것
		ArrayList<BorderDto> list = new ArrayList<BorderDto>();
		String sql = "select bno, writer, subject, wdate, filename, hit from border";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				dto = new BorderDto();
				dto.setNo(rs.getInt(1));
				dto.setWriter(rs.getString(2));
				dto.setSubject(rs.getString(3));
				dto.setDate((rs.getDate(4)));
				dto.setFileName(rs.getString(5));
				dto.setHit(rs.getInt(6));
				list.add(dto);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		return list;
	}

	public int insert(BorderDto dto) {  //입력하기
		int n = 0;
		String sql = "insert into border(bno,writer,subject,contents,filename,userid) values(b_seq.nextval,?,?,?,?,?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getWriter());
			psmt.setString(2, dto.getSubject());
			psmt.setString(3, dto.getContents());
			psmt.setString(4,dto.getFileName());
			psmt.setString(5, dto.getUserId());
			n = psmt.executeUpdate();			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return n;
	}
	
	public int delete(int id) {   //글 삭제
		int n = 0;
		String sql = "delete from border where bno = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, id);
			n = psmt.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}		
		return n;
	}
	
	public BorderDto editSearch(int id) {   //수정을 위한 select
		String sql="select * from border where bno = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, id);
			rs = psmt.executeQuery();
			if(rs.next()) {
				dto = new BorderDto();
				dto.setNo(rs.getInt("bno"));
				dto.setWriter(rs.getString("writer"));
				dto.setSubject(rs.getString("subject"));
				dto.setContents(rs.getString("contents"));
				dto.setDate((rs.getDate("wdate")));
				dto.setHit(rs.getInt("hit"));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		return dto;
	}
	
	public BorderDto search(int id) {   //읽기를 위한 select
		String sql="select * from border where bno = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, id);
			rs = psmt.executeQuery();
			if(rs.next()) {
				dto = new BorderDto();
				dto.setNo(rs.getInt("bno"));
				dto.setWriter(rs.getString("writer"));
				dto.setSubject(rs.getString("subject"));
				dto.setContents(rs.getString("contents"));
				dto.setDate((rs.getDate("wdate")));
				dto.setHit(rs.getInt("hit"));
				dto.setFileName(rs.getString("filename"));
				dto.setUserId(rs.getString("userid"));
				hitUpate(id);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return dto;
	}
	
	public int update(BorderDto dto) {    //글 내용을 수정한다.
		int n=0;
		String sql = "update border set contents = ?, hit = 0 where bno = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getContents());
			psmt.setInt(2, dto.getNo());
			n = psmt.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return n;
	}
	
	private void hitUpate(int id) {
		String sql="update border set hit = hit+1 where bno = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, id);
			psmt.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}	
	}

	private void close() {
		try {
			if(rs != null) rs.close();
			if(psmt != null) psmt.close();
			if(conn != null) conn.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}		
	}
}
