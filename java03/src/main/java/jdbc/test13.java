package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class test13 {

	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());

			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/java76db", "java76", "1111");

			stmt = con.createStatement();

			for (int i = 0; i < 100; i++) {
				stmt.executeUpdate(
						"insert into project(title,sdt,edt,member)"
								+ " values('프로잭트',now(),now()+1,'java76')");
			}
			System.out.println("입력성공!");


		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {stmt.close();} catch (Exception e) {}
			try {con.close();} catch (Exception e) {}
		}
	}

}
