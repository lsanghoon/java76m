package v07.command;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import v07.Student;

public class StudentAddCommand {
	public void execute(HashMap<String, Object> params) {
		ArrayList<Student> list = (ArrayList<Student>) params.get("list");
		Scanner scanner = (Scanner) params.get("scanner");

		Student student = new Student();

		System.out.print("이름? ");
		student.setName(scanner.nextLine());

		System.out.print("이메일? ");
		student.setEmail(scanner.nextLine());

		System.out.print("전화? ");
		student.setTel(scanner.nextLine());

		System.out.print("기수? ");
		student.setCid(scanner.nextLine());

		System.out.print("정말 저장하시겠습니까?(y/n)");
		String yesno = scanner.nextLine();
		if (yesno.toLowerCase().equals("y")) {
			list.add(student);
			System.out.println("저장되었습니다.");
		} 
		else {	
			System.out.println("취소하였습니다.");
		}
	}
}
