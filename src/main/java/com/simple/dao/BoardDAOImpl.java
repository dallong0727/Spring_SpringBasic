package com.simple.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.simple.command.BoardVO;
import com.simple.command.ScoreVO;

//class Test implements RowMapper<BoardVO> {
//	@Override
//	public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
//		BoardVO vo = new BoardVO();
//		vo.setNum(rs.getInt("num"));
//		vo.setName(rs.getString("name"));
//		vo.setTitle(rs.getString("title"));
//		vo.setContent(rs.getString("content"));
//		return vo;
//	}
//}

@Repository("boardDAO")
public class BoardDAOImpl implements BoardDAO{

	@Override
	public void boardRegister(BoardVO vo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<BoardVO> getList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void boardDelete(int num) {
		// TODO Auto-generated method stub
		
	}
//	private ArrayList<BoardVO> list = new ArrayList<>();
//	@Override
//	public void boardRegister(BoardVO vo) {
//		list.add(vo);
//	}
//	@Override
//	public ArrayList<BoardVO> getList() {
//		return null;
//	}
//	@Override
//	public void boardDelete(int num) {
//	}
	
///////////////////////DB연결////////////////////////////
//	@Autowired
//	private DataSource dataSource;
//	@Autowired
//	private JdbcTemplate jdbcTemplate;
//	
//	@Override
//	public void boardRegister(BoardVO vo) {
//	
//		String sql = "insert into board(num, name, title, content) values(board_seq.nextval,?,?,?)";
//
//		jdbcTemplate.update(sql, new Object[] {vo.getName(),vo.getTitle(),vo.getContent()});
//	}
//	@Override
//	public ArrayList<BoardVO> getList() {	
//		String sql = "select * from board";
////		jdbcTemplate.query(sql, new Object[] {}, new Test() );
//		List<BoardVO> list = jdbcTemplate.query(sql, new Object[] {}, new RowMapper<BoardVO>() {
//			@Override
//			public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
//				BoardVO vo = new BoardVO();
//				vo.setNum(rs.getInt("num"));
//				vo.setName(rs.getString("name"));
//				vo.setTitle(rs.getString("title"));
//				vo.setContent(rs.getString("content"));
//				return vo;
//			}
//		});
//		return (ArrayList<BoardVO>)list;
//	}
//
//	@Override
//	public void boardDelete(int num) {
//		String sql = "delete from board where num=?";
//		jdbcTemplate.update(sql,new Object[] {num});
//	}

}
