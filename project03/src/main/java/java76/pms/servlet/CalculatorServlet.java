package java76.pms.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import java76.pms.ContextLoader;
import java76.pms.dao.CalculatorDao;
import java76.pms.domain.Calculator;

public class CalculatorServlet extends GenericServlet {

	@Override
	public void service(ServletRequest request, ServletResponse response) 
			throws ServletException, IOException {

		String op = null;
		
		// op=....v2=20 이부분 받아오기
		String urlpath = ((HttpServletRequest) request).getQueryString();
		String op1 = urlpath.substring(3, 4);

		Calculator calculator = new Calculator();
		calculator.setV1(Integer.parseInt(request.getParameter("v1")));
		calculator.setV2(Integer.parseInt(request.getParameter("v2")));
		op = request.getParameter("op");

		if (op1.equals("%")) {
			//현재 request와 response를 유지시켜 같은 프로젝트에 있는 서블릿에서 받아 쓸수있다.
			//request.getRequestDispatcher("board/list").forward(request, response);
			
			op = "%";
			
		} else if (op1.equals("+")) {
			op = "+";
		}
		
		PrintWriter out = response.getWriter();
		CalculatorDao calculatorDao = ContextLoader.context.getBean(CalculatorDao.class);

		switch (op) {
		case "+":
			op = "+";
			calculatorDao.add(calculator);
			break;
		case "-":
			calculatorDao.minus(calculator);
			break;
		case "*":
			calculatorDao.multi(calculator);
			break;
		case "/":
			calculatorDao.divide(calculator);
			break;
		case "%":
			calculatorDao.remainder(calculator);
			break;
		default:
			break;
		}

		out.printf("%.2f %s %.2f = %.2f", 
				calculator.getV1(), 
				op,
				calculator.getV2(),
				calculator.getResult());
	}


}
