package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class test14 {

	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());

			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/java76db", "java76", "1111");

			stmt = con.createStatement();

			for (int i = 0; i < 50; i++) {
				stmt.executeUpdate(
						"insert into book(title,authors,press,tag)"
								+ " values("
								+ "'na" + (int)(Math.random() * 30) + "me',"
									+ "'aaa" + (int)(Math.random() * 10) + ",bbb" + (int)(Math.random() * 10)	+ "',"
										+ "'ccc" + (int)(Math.random() * 50) +"',"
											+ "'java" + (int)(Math.random() * 100) + "')");
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
