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
 웹 브라우저가 쿠키를 보내는 조건
 => 쿠키를 보낸 서블릿의 경로와 다르다면 쿠키를 보내지 않는다.
 */

@WebServlet("/otherpath/servlet04")
public class Servlet04 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		response.setContentType("text/plain;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		Cookie[] cookies = request.getCookies();
		
		if (cookies == null) {
			out.println("웹 브라우저가 보낸 쿠키가 한 개도 없습니다.");
			return;
		}
		
		for (Cookie cookie : cookies) {
			out.printf("%s=%s\n", cookie.getName(), cookie.getValue());
		}
	}
}

/*

GET /web01/step10/servlet02 HTTP/1.1
Host: localhost:8080
Connection: keep-alive
Accept: text/html,application/xhtml+xml,application/....
Upgrade-Insecure-Requests: 1
User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_1....
Accept-Encoding: gzip, deflate, sdch
Accept-Language: ko-KR,ko;q=0.8,en-US;q=0.6,en;q=0.4
Cookie: name=hong; age=20; JSESSIONID=88DF3CCB12438091D9BC1225D847184B
Name

 */









