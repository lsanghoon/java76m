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
import java76.pms.domain.Cart;
import java76.pms.domain.Users;

@Controller
@RequestMapping("/cart/*")
public class CartController { 
	public static final String SAVED_DIR = "/productfile";

	@Autowired CartDao cartDao;
	@Autowired ServletContext servletContext;

	@RequestMapping("list")
	public String list(
			Model model) throws Exception {

		List<Cart> carts = cartDao.selectList();

		model.addAttribute("carts", carts);

		return "cart/CartList";
	}

	@RequestMapping(value="add", method=RequestMethod.GET)
	public String add() {
		return "cart/CartForm";
	}

	@RequestMapping(value="add", method=RequestMethod.POST)
	public String add(
			Cart cart,
			Users user,
			HttpSession session
			) throws Exception {

		user = (Users) session.getAttribute("loginUser");
		cart.setCemail(user.getEmail());

		cartDao.insert(cart);
		return "redirect:list.do";
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
			Model model) throws Exception {

		if (cartDao.update(cart) <= 0) {
			model.addAttribute("errorCode", "401");
			return "cart/CartAuthError";
		} 
		return "redirect:list.do";
	}

	@RequestMapping("delete")
	public String delete(
			int no,
			String email,
			Model model) throws Exception {

		if (cartDao.delete(no) <= 0) {
			model.addAttribute("errorCode", "401");
			return "cart/CartAuthError";
		} 
		return "redirect:list.do";
	}

}
