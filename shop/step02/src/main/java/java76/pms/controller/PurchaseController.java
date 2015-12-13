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
import java76.pms.domain.Purchase;
import java76.pms.domain.Users;

@Controller
@RequestMapping("/purchase/*")
public class PurchaseController { 
	public static final String SAVED_DIR = "/productfile";

	@Autowired PurchaseDao purchaseDao;
	@Autowired CartDao cartDao;
	
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
			Model model) throws Exception {

		List<Purchase> purchases = purchaseDao.selectOne(email);

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

		int sum = cpcost * cstock;
		purchase.setBpsum(sum);
		
		user = (Users) session.getAttribute("loginUser");
		purchase.setBuemail(user.getEmail());
		purchase.setBuname(user.getName());

		purchaseDao.insert(purchase);
		
		return "redirect:../product/list.do";
	}
	
	@RequestMapping(value="add", method=RequestMethod.POST)
	public String add(
			Purchase purchase,
			Users user,
			HttpSession session) throws Exception {

		user = (Users) session.getAttribute("loginUser");
		purchase.setBuemail(user.getEmail());
		purchase.setBuname(user.getName());

		purchaseDao.insert(purchase);
		
		cartDao.deleteall(user.getEmail());
		
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
