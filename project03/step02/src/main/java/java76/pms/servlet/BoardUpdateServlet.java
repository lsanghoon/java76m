package java76.pms.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;

import java76.pms.dao.BoardDao;
import java76.pms.domain.Board;

public class BoardUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		try {
			Board board = new Board();

			board.setNo(Integer.parseInt(request.getParameter("no")));
			board.setTitle(request.getParameter("title"));
			board.setContent(request.getParameter("content"));
			board.setCreatedDate(Date.valueOf(request.getParameter("createddate")));
			board.setPassword(request.getParameter("password"));

			response.setContentType("text/plain;charset=UTF-8");
			PrintWriter out = response.getWriter();

			ApplicationContext iocContainer= 
					(ApplicationContext) this.getServletContext()
																	 .getAttribute("iocContainer");
			
			BoardDao boardDao = iocContainer.getBean(BoardDao.class);

			boardDao.update(board);
			response.setHeader("Refresh", "1;url=list");
			out.println("변경성공!");
			
			RequestDispatcher rd = request.getRequestDispatcher("/copyright");
			rd.include(request, response);

		} catch (Exception e) {
			RequestDispatcher rd = request.getRequestDispatcher("/error");
			rd.forward(request, response);
		}
	}


}
