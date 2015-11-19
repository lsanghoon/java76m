package java76.pms.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java76.pms.ContextLoader;
import java76.pms.dao.BoardDao;
import java76.pms.domain.Board;

public class BoardAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		Board board = new Board();
		
		
		board.setTitle(request.getParameter("title"));
		board.setContent(request.getParameter("content"));
		board.setCreatedDate(Date.valueOf(request.getParameter("createddate")));
		board.setPassword(request.getParameter("password"));
			
		PrintWriter out = response.getWriter();
		response.setContentType("text/plain;charset=UTF-8");

		BoardDao boardDao = ContextLoader.context.getBean(BoardDao.class);
		boardDao.insert(board);
		
		out.println("등록성공!");
		response.setHeader("Refresh", "1;url=list");
	}


}
