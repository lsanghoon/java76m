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

public class BoardUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		Board board = new Board();
		
		board.setNo(Integer.parseInt(request.getParameter("no")));
		board.setTitle(request.getParameter("title"));
		board.setContent(request.getParameter("content"));
		board.setCreatedDate(Date.valueOf(request.getParameter("createddate")));
		board.setPassword(request.getParameter("password"));

		PrintWriter out = response.getWriter();
		response.setContentType("text/plain;charset=UTF-8");

		BoardDao boardDao = ContextLoader.context.getBean(BoardDao.class);

		if (boardDao.update(board) > 0) {
			out.println("변경성공!");
		} else
			out.println("유효하지 않습니다.");
		
		response.setHeader("Refresh", "1;url=list");
	}


}
