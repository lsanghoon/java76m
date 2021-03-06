package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class test09 {

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement stmt = null;
		try (
				Scanner scanner = new Scanner(System.in);
				)
		{
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());

			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/java76db", "java76", "1111");

			stmt = con.prepareStatement(
					"update board set title=?, context=? where bno=?");
			
			System.out.print("번호?");
			int no = Integer.parseInt(scanner.nextLine());
			
			System.out.print("제목?");
			String title = scanner.nextLine();

			System.out.print("내용?");
			String context = scanner.nextLine();
			
			stmt.setString(1, title);
			stmt.setString(2, context);
			stmt.setInt(3, no);
			
			// update 실행
			int count = stmt.executeUpdate();

			if (count > 0) 
				System.out.println("update 성공!");
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
