package java76.pms.servlet;

import java.io.PrintStream;
import java.util.HashMap;

import java76.pms.annotation.Component;
import java76.pms.dao.StudentDao;

@Component("/student/delete")
public class StudentDeleteServlet implements Servlet {
	StudentDao studentDao;

	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	public void service(HashMap<String,Object> params) {
		int no = Integer.parseInt((String)params.get("no"));
		
		PrintStream out = (PrintStream)params.get("out");
		
		if(studentDao.delete(no) > 0) {
      out.println("삭제하였습니다.");
    } else
      out.println("유효하지 않습니다.");
	}

}
