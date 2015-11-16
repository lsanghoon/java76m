package v05.command;

import java.util.ArrayList;
import java.util.HashMap;

import v05.Student;

public class StudentListCommand {
	public void execute(HashMap<String, Object> params) {
		ArrayList<Student> list = (ArrayList<Student>) params.get("list");
		
		Student student = null;
		for (int i = 0; i < list.size(); i++) {
			student = list.get(i); // 제네릭을 적용했기 때문에 타입캐스팅 할 필요가 없다.
			if (student == null)
				continue;
			System.out.printf("%d %s %s %s %s\n"
					, i
					, student.getName()
					, student.getEmail()
					, student.getTel()
					, student.getCid());
		}
	}
}
