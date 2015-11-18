/* 클라이언트로 출력하기
	 
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Servlet03 extends GenericServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {
		//1) 출력 스트림 객체를 얻는다.
		//response.getOutputStream()	// 이미지
		//				.getWriter()				// 텍스트
			PrintWriter out = response.getWriter();
			
			//2) 출력한다.
			out.println("Hello, World!");
			out.println("안녕함?");
			out.println("お元気げんきですか");
			out.println("구튼모르겐");

		
	}

}
