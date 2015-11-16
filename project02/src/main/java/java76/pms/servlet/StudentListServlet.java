package java76.pms.servlet;

import java.io.PrintStream;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java76.pms.dao.StudentDao;
import java76.pms.domain.Student;

@Component("/student/list")
public class StudentListServlet implements Servlet {
	@Autowired
	StudentDao studentDao;

	@Override
	public void service(HashMap<String, Object> params) {
		// <-- 페이징 처리
		int pageNo = 1;
		int pageSize = 10;

		if (params.get("pageNo") != null) {
			pageNo = Integer.parseInt((String)params.get("pageNo"));
		}
		if (params.get("pageSize") != null) {
			pageSize = Integer.parseInt((String)params.get("pageSize"));
		}
		// -->

		// <-- 정렬 처리
		String keyword = "no";
		String align = "asc";

		if (params.get("keyword") != null) {
			keyword = (String)params.get("keyword");
		}
		if (params.get("align") != null) {
			align = (String)params.get("align");
		}
		// -->

		PrintStream out = (PrintStream)params.get("out");

		out.printf("%-3s %-5s %-17s %-13s %-7s\n", 
				"No", "Name", "E-Mail", "Tel", "ClassID");

		for (Student student : studentDao.selectList(pageNo, pageSize, keyword, align)) {
			out.printf("%3d %-5s %-17s %-13s %7s\n",
					student.getNo(), 
					student.getName(),
					student.getEmail(),
					student.getTel(),
					student.getCid());
		}
	}	
}
