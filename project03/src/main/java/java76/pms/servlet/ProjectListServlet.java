package java76.pms.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java76.pms.ContextLoader;
import java76.pms.dao.ProjectDao;
import java76.pms.domain.Project;

public class ProjectListServlet extends HttpServlet {
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
			String align = "desc";

			if (request.getParameter("keyword") != null) {
				keyword = request.getParameter("keyword");
			}
			if (request.getParameter("align") != null) {
				align = request.getParameter("align");
			}
			// -->

			response.setContentType("text/plain;charset=UTF-8");
			PrintWriter out = response.getWriter();

			out.printf("%-3s %-13s %-11s %-11s %-40s\n", 
					"No", "ProjectName", "StartDay", "EndDay", "Member");

			ProjectDao projectDao = ContextLoader.context.getBean(ProjectDao.class);

			for (Project project : projectDao.selectList(pageNo, pageSize, keyword, align)) {
				out.printf("%3d %-13s %3$-11s %4$-11s %5$-40s\n", 
						project.getNo(), 
						project.getTitle(),
						project.getStartDate(),
						project.getEndDate(),
						project.getMember());
			}
			
			RequestDispatcher rd = request.getRequestDispatcher("/copyright");
			rd.include(request, response);
			
		} catch (Exception e) {
			RequestDispatcher rd = request.getRequestDispatcher("/error");
			rd.forward(request, response);
		}
	}
}
