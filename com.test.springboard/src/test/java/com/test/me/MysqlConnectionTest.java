package com.test.me;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.transaction.jta.SpringJtaSynchronizationAdapter;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.ContextConfiguration;



@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration( locations ={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class MysqlConnectionTest {
	
	@Inject 
	private DataSource ds;

	
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/sys?serverTimezone=Asia/Seoul";
	private String uid = "root";
	private String upw = "mysql";
	
	
	//DB 연결 테스트
		@Test
		public void connectTest() {
			Connection conn = null;
			
			try {
				Class.forName(driver);
				
				conn  = DriverManager.getConnection(url, uid, upw);
				System.out.println("DB커넥션 성공");
				System.out.println("conn: " + conn);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		}

	

}
