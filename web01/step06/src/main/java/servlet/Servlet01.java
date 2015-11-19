/* Refresh 
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet01 extends javax.servlet.http.HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(
			HttpServletRequest request, HttpServletResponse response)
					throws IOException, ServletException {
		response.setContentType("text/plain;charset=UTF-8");
		PrintWriter out = response.getWriter();
		// 출력문을 호출하면, 데이터는 내부의 버퍼(8kb)에 보관된다.
		// 즉시 클라이언트로 출력되는 것이 아니다.
		// Service()의 호출이 끝나거나, 강제로 flush()를 호출하게 되면
		// 버퍼에 저장된 데이터가 클라이언트로 출력된다.
		out.println("결과를 출력한다.");
		out.println("그리고 3초 후에 daum.net 사이트를 요청하게 만든다.");
		
		// 응답 헤더에 refresh 정보를 추가한다.
		// 만약, 위에서와 같이 flush()를 호출하여 강제로 클라이언트에게 응답을 했다면,
		// 다음 메서드 호출은 무시된다.
		response.setHeader("Refresh", "3;url=http://www.daum.net");
	}

}
