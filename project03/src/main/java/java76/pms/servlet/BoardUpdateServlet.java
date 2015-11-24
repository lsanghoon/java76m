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

	// GET 요청이 들어옫나면 해당 게시물의 상세 정보를 출력한다.
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("  <meta charset='UTF-8'>");
		out.println("  <title>게시판-상세정보</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>게시물 정보</h1>");
		out.println("<table border='1'>");
		out.println("<tr>");
		out.println("  <th>번호</th>");
		out.println("  <th>1</th>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("  <th>제목</th>");
		out.println("  <th>1</th>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("  <th>내용</th>");
		out.println("  <th>1</th>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("  <th>조회수</th>");
		out.println("  <th>1</th>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("  <th>등록일</th>");
		out.println("  <th>1</th>");
		out.println("</tr>");
		out.println("</body>");
		out.println("</html>");
	}
	
	// POST 요청이 들어오면 해당 게시물을 입력한 값으로 변경한다.
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
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
