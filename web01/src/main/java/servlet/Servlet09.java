package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 로그인 처리
 */

@WebServlet("/auth/login")
public class Servlet09 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String saveEmail = request.getParameter("saveEmail");
		
		Cookie emailCookie = null;
		if (saveEmail != null) {	// 이메일 저장 체크박스를 체크함
			emailCookie = new Cookie("email",email);
			emailCookie.setMaxAge(60 * 60 * 24 * 15);
			
		} else {
			emailCookie = new Cookie("email", "");
			emailCookie.setMaxAge(0);	// 웹 브라우저에게 email 쿠키 삭제를 명령한다.
			
		}
		response.addCookie(emailCookie);
		
		response.setContentType("text/plain;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("로그인 처리!");
		
	}
}










