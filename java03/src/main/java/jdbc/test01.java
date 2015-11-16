package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class test01 {

	public static void main(String[] args) {
		//1) java.sql.Driver 구현체를 드라이버 관리자에 등록한다.
		// => java.sql.Driver 인터페이스의 구현체 --> com.mysql.jdbc.Driver
		Connection con = null;
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			//DriverManager.registerDriver(new org.mariadb.jdbc.Driver());
			//DriverManager.registerDriver(new org.postgresql.Driver());
			
			//2) DriverManager에게 Connection 객체를 요구한다.
			// => JDBC URL을 통해 사용할 Driver를 선택한다.
			// => 그 드라이버 객체를 이용하여 DBMS에 연결한다.
			// => 드라이버가 생성해 준 연결 객체를 리턴한다. 
			con = DriverManager.getConnection(
					"jdbc:mysql://192.168.0.42:3306/java76db", "java76", "1111");
			
			System.out.println("DBMS 연결성공");
			
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			try {con.close();} catch (Exception e) {}
		}
	}

}
