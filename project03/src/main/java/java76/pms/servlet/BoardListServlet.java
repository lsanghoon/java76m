package java76.pms.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;

import java76.pms.dao.BoardDao;
import java76.pms.domain.Board;

public class BoardListServlet extends HttpServlet {
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

			out.printf("%-3s %-13s %-18s %-13s %s\n", 
					"No", "Title", "Content", "view", "CreatedDate"); 

			ApplicationContext iocContainer= 
					(ApplicationContext) this.getServletContext()
																	 .getAttribute("iocContainer");
			
			BoardDao boardDao = iocContainer.getBean(BoardDao.class);

			for (Board board : boardDao.selectList(pageNo, pageSize, keyword, align)) {
				out.printf("%3d %-13s %-18s %-13s %s\n", 
						board.getNo(), 
						board.getTitle(),
						board.getContent(),
						board.getViews(),
						board.getCreatedDate());
			}
			
			RequestDispatcher rd = request.getRequestDispatcher("/copyright");
			rd.include(request, response);
			
		} catch (Exception e) {
			RequestDispatcher rd = request.getRequestDispatcher("/error");
			rd.forward(request, response);
		}
		// URL -> CalculatorServlet(request,response) -> BoardListServlet
		//CalculatorServlet에서 request와 response를 그대로 받아 쓸수있다.
		//out.println(request.getParameter("v1"));	
		//http://localhost:8080/project03/calc?op=%&v1=10&v2=20
	}
}
