package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class test05 {

	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/java76db", "java76", "1111");
			
			stmt = con.createStatement();
			
			// update 실행
			stmt.executeUpdate(
					"update board set title='okok', context='okokxxxx' where bno=9");
			
			System.out.println("입력성공!");
			
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			try {stmt.close();} catch (Exception e) {}
			try {con.close();} catch (Exception e) {}
		}
	}

}
