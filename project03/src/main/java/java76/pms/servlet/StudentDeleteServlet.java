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
import java76.pms.util.MultipartHelper;

public class StudentDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Map<String,String> paramMap = 
					MultipartHelper.parseMultiDate(
							request,
							this.getServletContext().getRealPath("/student"));
			int no = Integer.parseInt(paramMap.get("no"));

			ApplicationContext iocContainer= 
					(ApplicationContext) this.getServletContext()
					.getAttribute("iocContainer");

			StudentDao studentDao = iocContainer.getBean(StudentDao.class);

			if(studentDao.delete(no) > 0) {
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
