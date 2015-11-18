/* HttpServletRequest 도구 사용법
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet02 extends GenericServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {
		//1) 공공연한 비밀
		//서블릿 컨테이너가 service()를 호출할 때 넘겨주는 값은 실제
		//HttpServletRequest와 HttpServletResponse이다.
		//그래서 이 타입으로 타입캐스팅 할 수있다.
		HttpServletRequest httpReq = (HttpServletRequest) request;
		HttpServletResponse httpResp = (HttpServletResponse) response;
		
		response.setContentType("text/plain;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.println("ServletRequest를 통해 뽑아내는 정보:");
		out.printf("클라이언트 IP = %s\n",request.getRemoteAddr());
		out.printf("클라이언트 이름(HOST) = %s\n",request.getRemoteHost());
		out.printf("클라이언트 포트 = %s\n",request.getRemotePort());
		out.printf("클라이언트 이름(프로토콜) = %s\n",request.getScheme());
		out.println();
		out.println("HttpServletRequest를 통해 뽑아내는 정보:");
		out.printf("웹 애플리케이션 경로 = %s\n", httpReq.getContextPath());
		out.printf("요청 방식 = %s\n", httpReq.getMethod());
		out.printf("요청 URL = %s\n", httpReq.getPathInfo());
		out.printf("쿼리 스트링 = %s\n", httpReq.getQueryString());
		out.printf("요청 URI = %s\n", httpReq.getRequestURI());
		out.printf("요청 URL = %s\n", httpReq.getRequestURL());
		out.printf("서블릿 경로 = %s\n", httpReq.getServletPath());
		out.printf("getHeader(User-Agent, args) = %s\n", httpReq.getHeader("User-Agent"));
		
		//요청 예)
		// http://192.168.0.31:8080/web01/step05/servlet02?name=aaa&tel=11111
		//
		//결과
		/*
				HttpServletRequest를 통해 뽑아내는 정보:
				웹 애플리케이션 경로 = /web01
				요청 방식 = GET
				요청 URL = null
				쿼리 스트링 = name=aaa&tel=11111
				요청 URI = /web01/step05/servlet02
				요청 URL = http://192.168.0.31:8080/web01/step05/servlet02
				서블릿 경로 = /step05/servlet02
		 */
		
		
		
	}

}
