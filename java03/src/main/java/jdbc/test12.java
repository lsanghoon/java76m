package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class test12 {

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
						"insert into student(name,email,tel,cid)"
								+ " values('name" + (int)(Math.random() * 10)
								+ "','xxx" + i + "@xxxx.xxx','111-1111-1111','java76')");
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
