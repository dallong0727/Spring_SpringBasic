package com.simple.basic;

import java.sql.Connection;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class) //스프링에서 테스트화
@ContextConfiguration("file:src/main/webapp/WEB-INF/config/root-context.xml") //해당파일을 스프링 설정파일로 적용
public class JDBCHikari {
	
	//커넥션풀 확인
	@Autowired
	DataSource dataSource;
	//스프링jdbc 확인
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Test
	public void test() {
		//데이터베이스 연결 확인
		String url = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
		String uid = "spring";
		String upw = "spring";
		
		try {
			Connection conn = dataSource.getConnection();
			System.out.println("결과확인 : " + conn);		
			System.out.println("스프링 결과확인 : " + jdbcTemplate);		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
