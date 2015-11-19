package java76.pms.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java76.pms.ContextLoader;
import java76.pms.dao.BoardDao;

public class BoardDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {


		int no = Integer.parseInt(request.getParameter("no"));

		BoardDao boardDao = ContextLoader.context.getBean(BoardDao.class);

		boardDao.delete(no);
		response.sendRedirect("list");
	}

}
