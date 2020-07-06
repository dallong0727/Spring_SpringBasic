package com.simple.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.simple.command.ScoreVO;

//@Service("scoreDAO")
//@Component
@Repository("scoreDAO")
public class ScoreDAOImpl implements ScoreDAO{
	/*
	 * //DB라고 가정 private ArrayList<ScoreVO> DB = new ArrayList<>();
	 * 
	 * @Override public void scoreRegist(ScoreVO vo) { DB.add(vo);
	 * System.out.println(DB.toString()); }
	 * 
	 * @Override public ArrayList<ScoreVO> scoreList() { return DB; }
	 * 
	 * @Override public void scoreDelete(int num) { DB.remove(num); }
	 */
	
///////////////////////////////DB연결////////////////////////////////////
//	@Autowired
//	private DataSource dataSource;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void scoreRegist(ScoreVO vo) {
//		try {
//			Connection conn = dataSource.getConnection();
//			PreparedStatement pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1,vo.getName());
//			pstmt.setString(2,vo.getName());
//			pstmt.setString(3,vo.getName());
//			int result = pstmt.executeUpdate();
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
			
		String sql = "insert into score(num, name, kor, eng, math) values(score_seq.nextval,?,?,?,?)";
//		String[] arr = new String[] {"1", "2", "3"};
		int result = jdbcTemplate.update(sql, new Object[] {vo.getName(),vo.getKor(),vo.getEng(),vo.getMath()});
		System.out.println("성공실패 : " + result);
	}
	
	@Override
	public ArrayList<ScoreVO> scoreList() {
		String sql = "select * from score";
		List<ScoreVO> list = jdbcTemplate.query(sql, new Object[] {}, new RowMapper<ScoreVO>() {

			@Override
			//rowNum 개수만큼 회전함(while과 동일)
			public ScoreVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				//제네릭에는 select구문을 처리할 vo가 들어갑니다.
				//mapRow메서드 안에서는 resultSet객체를 처리하는 구문이 들어갑니다.
				ScoreVO vo = new ScoreVO();
				vo.setNum(rs.getInt("num"));
				vo.setName(rs.getString("name"));
				vo.setKor(rs.getString("kor"));
				vo.setEng(rs.getString("eng"));
				vo.setMath(rs.getString("math"));
				return vo;
			}	
		});
		return (ArrayList<ScoreVO>)list;
	}
	
	@Override
	public void scoreDelete(int num) {
		String sql = "delete from socre where num=?";
		jdbcTemplate.update(sql,new Object[] {num});
	}
}
