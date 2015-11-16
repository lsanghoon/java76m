package v08.command;

import java.util.ArrayList;
import java.util.HashMap;

import v08.dao.StudentDao;
import v08.domain.Student;

public class StudentListCommand implements Command {
	StudentDao studentDao;
	
	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}


	public void execute(HashMap<String, Object> params) {
		ArrayList<Student> list = studentDao.selectList();
		
		System.out.printf("%-3s %-5s %-17s %-13s %-7s\n", 
				"No", "Name", "E-Mail", "Tel", "ClassID");
		
		Student student = null;
		for (int i = 0; i < list.size(); i++) {
			student = list.get(i); // 제네릭을 적용했기 때문에 타입캐스팅 할 필요가 없다.
			if (student == null)
				continue;
			System.out.printf("%3d %-5s %-17s %-13s %7s\n"
					, i
					, student.getName()
					, student.getEmail()
					, student.getTel()
					, student.getCid());
		}
	}
}
