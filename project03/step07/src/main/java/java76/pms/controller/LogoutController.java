package java76.pms.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java76.pms.dao.StudentDao;

@Component("/auth/logout.do")
public class LogoutController implements PageController {
	@Autowired StudentDao studentDao;

	@Override
	public String execute(
			HttpServletRequest request, HttpServletResponse response)
					throws Exception {

		request.getSession().invalidate();
		return "redirect:LoginForm.jsp";

	}


}
