package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class test02 {

	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/java76db", "java76", "1111");
			System.out.println("DBMS 연결 성공!");
			
			//3) Connection 객체를 통해 DBMS에 SQL을 전달할 객체를 얻는다.
			stmt = con.createStatement();
			System.out.println("SQL 실행 객체 준비 완료!");
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			try {stmt.close();} catch (Exception e) {}
			try {con.close();} catch (Exception e) {}
		}
	}

}
