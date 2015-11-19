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

public class StudentUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Student student = new Student();

			student.setName(request.getParameter("name"));
			student.setEmail(request.getParameter("email"));
			student.setTel(request.getParameter("tel"));
			student.setCid(request.getParameter("cid"));

			response.setContentType("text/plain;charset=UTF-8");
			PrintWriter out = response.getWriter();

			StudentDao studentDao = ContextLoader.context.getBean(StudentDao.class);

			studentDao.update(student);
			out.println("저장되었습니다.");
			response.setHeader("Refresh", "1;url=list");

		} catch (Exception e) {
			RequestDispatcher rd = request.getRequestDispatcher("/error");
			rd.forward(request, response);
		}
	}
}
