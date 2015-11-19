package java76.pms.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import java76.pms.ContextLoader;
import java76.pms.dao.StudentDao;
import java76.pms.domain.Student;

public class StudentListServlet extends GenericServlet {
	
	@Override
	public void service(ServletRequest request, ServletResponse response) 
			throws ServletException, IOException {
		// <-- 페이징 처리
		int pageNo = 1;
		int pageSize = 10;

		if (request.getParameter("pageNo") != null) {
			pageNo = Integer.parseInt(request.getParameter("pageNo"));
		}
		if (request.getParameter("pageSize") != null) {
			pageSize = Integer.parseInt(request.getParameter("pageSize"));
		}
		// -->

		// <-- 정렬 처리
		String keyword = "no";
		String align = "asc";

		if (request.getParameter("keyword") != null) {
			keyword = request.getParameter("keyword");
		}
		if (request.getParameter("align") != null) {
			align = request.getParameter("align");
		}
		// -->

		PrintWriter out = response.getWriter();

		out.printf("%-3s %-5s %-17s %-13s %-7s\n", 
				"No", "Name", "E-Mail", "Tel", "ClassID");

		StudentDao studentDao = ContextLoader.context.getBean(StudentDao.class);
		
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
