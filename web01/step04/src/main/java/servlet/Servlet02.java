/* 서블릿 만들기2
=> Servlet 인터페이스를 구현하려면 5개의 메서드를 모두 정의 해야한다.
	 하지만, 실제 서블릿을 작성하는 대부분의 시간은 service()를 작성하는데 보낸다.
	 나머지 네 개의 메서드는 자주 작성하지 않는다.
=> 자주 작성하지 않는 네 개의 메서드를 미리 구현한 클래스를 상속 받으면,
	 서블릿을 만들기가 더 쉽다.
=> GenericServlet을 상속 받아서 서블릿을 구현하자
	 
	 
 */
package servlet;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Servlet02 extends GenericServlet {
	private static final long serialVersionUID = 1L;
	
	public Servlet02() {
		System.out.println("Servlet02()");
	}

	@Override
	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {
		System.out.println("service()");

		/* ServletRequest 파라미터?
		 * => 요청 정보를 다룰 때 사용하는 도구
		 * => 클라이언트가 보낸 값을 꺼낼 수 있다.
		 * => 요청한 클라이언트의 IP 주소를 알아낼 수 있다.
		 * => 클라이언트의 웹 브라우저 정보 및 운영체제 정보를 알아낼 수 있다.
		 * 
		 * ServletResponse 파라미터?
		 * => 응답을 다룰 때 사용하는 도구
		 * => 클라이언트에게 출력할 때 사용할 출력 스트림 객체를 얻을 수 있다.
		 * => 클라이언트에게 보내는 데이터의 유형과 문자 집합을 지정할 수 있다.
		 */
	}

}
