/* HttpServlet을 클래스를 이용하여
	 HttpServletRequest와 HttpServletResponse를 자동 형변환하기
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet04 extends javax.servlet.http.HttpServlet {

	private static final long serialVersionUID = 1L;

	/* HttpServlet으로 상속받은 메서드
	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {
		service((HttpServletRequest)request, (HttpServletResponse)response);
	}*/
	
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//다음과 같이 파라미터를 타입 캐스팅 할 필요가 없다.
		//HttpServletRequest httpReq = (HttpServletRequest) request;
		//HttpServletResponse httpResp = (HttpServletResponse) response;
		
		response.setContentType("text/plain;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.println("ServletRequest를 통해 뽑아내는 정보:");
		out.printf("클라이언트 IP = %s\n",request.getRemoteAddr());
		out.printf("클라이언트 이름(HOST) = %s\n",request.getRemoteHost());
		out.printf("클라이언트 포트 = %s\n",request.getRemotePort());
		out.printf("클라이언트 이름(프로토콜) = %s\n",request.getScheme());
		out.println();
		out.println("HttpServletRequest를 통해 뽑아내는 정보:");
		out.printf("웹 애플리케이션 경로 = %s\n", request.getContextPath());
		out.printf("요청 방식 = %s\n", request.getMethod());
		out.printf("요청 URL = %s\n", request.getPathInfo());
		out.printf("쿼리 스트링 = %s\n", request.getQueryString());
		out.printf("요청 URI = %s\n", request.getRequestURI());
		out.printf("요청 URL = %s\n", request.getRequestURL());
		out.printf("서블릿 경로 = %s\n", request.getServletPath());
		out.printf("getHeader(User-Agent, args) = %s\n", 
				request.getHeader("User-Agent"));
		
	}

}
