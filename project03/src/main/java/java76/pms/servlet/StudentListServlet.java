package java76.pms.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java76.pms.ContextLoader;
import java76.pms.dao.StudentDao;
import java76.pms.domain.Student;

public class StudentListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
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

			response.setContentType("text/plain;charset=UTF-8");
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
			
		} catch (Exception e) {
			RequestDispatcher rd = request.getRequestDispatcher("/error");
			rd.forward(request, response);
		}
	}	
}
