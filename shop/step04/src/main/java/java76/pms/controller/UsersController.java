package java76.pms.controller;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java76.pms.dao.UsersDao;
import java76.pms.domain.Users;

@Controller
@RequestMapping("/users/*")
public class UsersController {
	public static final String SAVED_DIR = "/file";
	
	@Autowired UsersDao usersDao;
	@Autowired ServletContext servletContext;

	@RequestMapping("list")
	public String list(
			Model model) throws Exception {

		List<Users> users = usersDao.selectList();

		model.addAttribute("users", users);

		return "users/UsersList";

	}
	
	@RequestMapping(value="add", method=RequestMethod.POST)
	public String add(Users users) throws Exception {
		
		usersDao.insert(users);

		return "redirect:../product/list.do";

	}

	@RequestMapping("detail")
	public String detail(
			String email,
			Model model) throws Exception {

		Users users = usersDao.selectOne(email);
		model.addAttribute("users", users);

		return "users/UsersDetail";
	}

	@RequestMapping(value="update", method=RequestMethod.POST)
	public String post(
			Users users,
			Model model) throws Exception {

		if (usersDao.update(users) <= 0) {
			model.addAttribute("errorCode", "401");
			return "users/UsersAuthError";
		} 

		return "redirect:../product/list.do";
	}

	@RequestMapping("delete")
	public String delete(
			String email,
			Model model) throws Exception {

		if (usersDao.delete(email) <= 0) {
			model.addAttribute("errorCode", "401");
			return "users/UsersAuthError";
		}
		return "redirect:../auth/list.do";
	}
	
}
