package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class test10 {

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement stmt = null;
		try (
				Scanner scanner = new Scanner(System.in);
				)
		{
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());

			con = DriverManager.getConnection(
					"jdbc:mysql://192.168.0.37:3306/java76db", "java76", "1111");

			stmt = con.prepareStatement(
					"delete from board where bno=?");
			
			System.out.print("번호?");
			int no = Integer.parseInt(scanner.nextLine());
			
			stmt.setInt(1, no);
			
			// update 실행
			int count = stmt.executeUpdate();

			if (count > 0) 
				System.out.println("delete 성공!");
			else
				System.out.println("실패");
			
			System.out.println("입력성공!");


		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {stmt.close();} catch (Exception e) {}
			try {con.close();} catch (Exception e) {}
		}
	}

}
