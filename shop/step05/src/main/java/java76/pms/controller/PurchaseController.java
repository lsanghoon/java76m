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
import java76.pms.dao.PurchaseDao;
import java76.pms.dao.UsersDao;
import java76.pms.domain.Purchase;
import java76.pms.domain.Users;

@Controller
@RequestMapping("/purchase/*")
public class PurchaseController { 
	public static final String SAVED_DIR = "/productfile";

	@Autowired PurchaseDao purchaseDao;
	@Autowired CartDao cartDao;
	@Autowired UsersDao usersDao;

	@Autowired ServletContext servletContext;

	@RequestMapping("list")
	public String list(
			Model model) throws Exception {

		List<Purchase> purchases = purchaseDao.selectList();
		List<Purchase> charts = purchaseDao.selectChart();

		model.addAttribute("purchases", purchases);
		model.addAttribute("charts",charts);

		return "purchase/PurchaseList";
	}


	@RequestMapping("listone")
	public String listone(
			String email,
			Users users,
			HttpSession session,
			Model model) throws Exception {

		List<Purchase> purchases = purchaseDao.selectOne(email);
		
		users = (Users) session.getAttribute("loginUser");
		
		Users user = usersDao.point(users.getEmail());
		
		model.addAttribute("user", user);
		model.addAttribute("purchases", purchases);

		return "purchase/PurchaseListone";
	}

	@RequestMapping(value="adddir", method=RequestMethod.POST)
	public String adddir(
			Purchase purchase,
			int cpcost,
			int cstock,
			Users user,
			HttpSession session) throws Exception {

		if (cstock != 0) {
			int sum = cpcost * cstock;
			purchase.setBpsum(sum);

			user = (Users) session.getAttribute("loginUser");
			purchase.setBuemail(user.getEmail());
			purchase.setBuname(user.getName());

			int psum = purchase.getBpsum();
			psum *= 0.03;
			
			user.setPoint(psum);
			usersDao.updatePoint(user);
			
			purchaseDao.insert(purchase);
		}
		
		return "redirect:../product/list.do";
	}

	@RequestMapping(value="add", method=RequestMethod.POST)
	public String add(
			Purchase purchase,
			Users user,
			HttpSession session) throws Exception {

		if (purchase.getBpsum() > 0) {
			user = (Users) session.getAttribute("loginUser");
			purchase.setBuemail(user.getEmail());
			purchase.setBuname(user.getName());

			int psum = purchase.getBpsum();
			psum *= 0.03;
			
			user.setPoint(psum);
			usersDao.updatePoint(user);
			
			purchaseDao.insert(purchase);
			cartDao.deleteall(user.getEmail());
		}

		return "redirect:../product/list.do";
	}

	@RequestMapping("delete")
	public String delete(
			int no,
			String email,
			Model model,
			Users user,
			HttpSession session) throws Exception {

		if (purchaseDao.delete(no) <= 0) {
			model.addAttribute("errorCode", "401");
			return "cart/CartAuthError";
		} 

		user = (Users) session.getAttribute("loginUser");

		return "redirect:list.do?email=" + user.getEmail();
	}

}
