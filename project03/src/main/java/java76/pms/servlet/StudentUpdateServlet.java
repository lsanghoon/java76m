package java76.pms.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;

import java76.pms.dao.StudentDao;
import java76.pms.domain.Student;
import java76.pms.util.MultipartHelper;

public class StudentUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int no = Integer.parseInt(request.getParameter("no"));

		ApplicationContext iocContainer = 
				(ApplicationContext) this.getServletContext()
				.getAttribute("iocContainer");

		StudentDao studentDao = iocContainer.getBean(StudentDao.class);
		Student student = studentDao.selectOne(no);

		request.setAttribute("student", student);
		response.setContentType("text/html;charset=UTF-8");
		RequestDispatcher rd = 
				request.getRequestDispatcher("/student/StudentDetail.jsp");
		rd.include(request, response);

	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Map<String,String> paramMap = 
					MultipartHelper.parseMultiDate(
							request,
							this.getServletContext().getRealPath("/student"));

			Student student = new Student();
			student.setNo(Integer.parseInt(paramMap.get("no")));
			student.setName(paramMap.get("name"));
			student.setEmail(paramMap.get("email"));
			student.setTel(paramMap.get("tel"));
			student.setCid(paramMap.get("cid"));
			student.setPhoto(paramMap.get("photo"));

			ApplicationContext iocContainer= 
					(ApplicationContext) this.getServletContext()
					.getAttribute("iocContainer");
			StudentDao studentDao = iocContainer.getBean(StudentDao.class);

			if (studentDao.update(student) > 0) {
				response.sendRedirect("list");
				return;
			}

			request.setAttribute("errorCode", "401");
			response.setContentType("text/html;charset=UTF-8");
			RequestDispatcher rd = 
					request.getRequestDispatcher("/student/StudentAuthError.jsp");
			rd.include(request, response);


		} catch (Exception e) {
			RequestDispatcher rd = request.getRequestDispatcher("/error");
			request.setAttribute("error", e);
			rd.forward(request, response);
		}
	}
}
