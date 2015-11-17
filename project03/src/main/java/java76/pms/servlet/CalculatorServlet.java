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

			String str = urlpath.replace("%", "%25");

			String url = request.getScheme() + "://" +									// "http" + "://"
					request.getServerName() + ":" +													// "localhost" + ":"
					request.getServerPort() +																// "8080"
					((HttpServletRequest) request).getRequestURI() + "?" +	// "/calc" + "?"
					str;																										// "op=%25&v1=10&v2=20"
			
			// URL 바꾸기!!!!
			request.getRequestDispatcher(url);

			op = "%";
		}
		
		PrintWriter out = response.getWriter();
		CalculatorDao calculatorDao = ContextLoader.context.getBean(CalculatorDao.class);

		switch (op) {
		case " ":
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
		}

		out.printf("%.2f %s %.2f = %.2f", 
				calculator.getV1(), 
				op,
				calculator.getV2(),
				calculator.getResult());
	}


}
