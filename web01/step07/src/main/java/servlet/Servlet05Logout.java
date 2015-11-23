/* HttpSession 강제 무효화시키기

 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Servlet05Logout extends javax.servlet.http.HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(
			HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		HttpSession session = request.getSession();
		
		// 세션을 강제로 무효화 시킨다.
		session.invalidate();
		
		response.setContentType("text/plain;charset=UTF-8");
		PrintWriter out = response.getWriter();

		if (request.getAttribute("level") != null)
			out.printf("관리자 아이디/암호가 일치하지 않습니다.");
		else
			out.printf("로그아웃 하셧습니다.");

	}

}
