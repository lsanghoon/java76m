package java76.pms.controller;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java76.pms.dao.CartDao;
import java76.pms.dao.ProductDao;
import java76.pms.dao.UsersDao;
import java76.pms.domain.Cart;
import java76.pms.domain.Users;

@Controller
@RequestMapping("/cart/*")
public class CartController { 
	public static final String SAVED_DIR = "/productfile";

	@Autowired CartDao cartDao;
	@Autowired ProductDao productDao;
	@Autowired UsersDao usersDao;
	@Autowired ServletContext servletContext;

	@RequestMapping("list")
	public String list(
			String email,
			Cart car,
			Users users,
			HttpSession session,
			Model model) throws Exception {

		users = (Users) session.getAttribute("loginUser");
		
		Users user = usersDao.point(users.getEmail());
		
		model.addAttribute("user", user);
		
		List<Cart> cart = cartDao.selectMy(email);

		int sum = 0;
		String names = "";
		for (Cart cat : cart) {
			sum += cat.getCpcost();
			names = names + "/" + cat.getCpname();
		}

		model.addAttribute("sum", sum);
		model.addAttribute("names", names);
		model.addAttribute("cart", cart);

		return "cart/CartList";
	}

	@RequestMapping(value="add", method=RequestMethod.POST)
	public String add(
			Cart cart,
			Users user,
			HttpSession session) throws Exception {

		user = (Users) session.getAttribute("loginUser");
		cart.setCemail(user.getEmail());

		cartDao.insert(cart);
		return "redirect:list.do?email=" + user.getEmail();
	}

	@RequestMapping("detail")
	public String detail(
			String email,
			Model model) throws Exception {

		List<Cart> cart = cartDao.selectMy(email);
		model.addAttribute("cart", cart);

		return "cart/CartDetail";
	}

	@RequestMapping(value="update", method=RequestMethod.POST)
	public String update(
			Cart cart,
			Model model,
			Users user,
			HttpSession session) throws Exception {

		if (cartDao.update(cart) <= 0) {
			model.addAttribute("errorCode", "401");
			return "cart/CartAuthError";
		} 

		user = (Users) session.getAttribute("loginUser");

		return "redirect:list.do?email=" + user.getEmail();
	}

	@RequestMapping("delete")
	public String delete(
			int no,
			String email,
			Model model,
			Users user,
			HttpSession session) throws Exception {

		if (cartDao.delete(no) <= 0) {
			model.addAttribute("errorCode", "401");
			return "cart/CartAuthError";
		} 

		user = (Users) session.getAttribute("loginUser");

		return "redirect:list.do?email=" + user.getEmail();
	}

}
