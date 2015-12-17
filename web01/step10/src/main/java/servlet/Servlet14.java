package servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.MultipartHelper;

/*
 파일 업로드 - 멀티파트 데이터 처리
 */

@WebServlet("/file/upload4")
public class Servlet14 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		try {
			Map<String,String> paramMap = 
					MultipartHelper.parseMultipartDate(
							request, 
							this.getServletContext().getRealPath("/file"));

			request.setAttribute("files", paramMap);
			response.setContentType("text/html;charset=UTF-8");
			RequestDispatcher rd = 
					request.getRequestDispatcher("/file/ViewImage.jsp");
			rd.include(request, response);
			
		}catch (Exception e) {
			throw new ServletException(e);
		}
	}
}











