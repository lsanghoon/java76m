package java76.pms.controller;

import java.io.File;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import java76.pms.dao.ProductDao;
import java76.pms.domain.Product;
import java76.pms.domain.Users;
import java76.pms.util.MultipartHelper;

@Controller
@RequestMapping("/product/*")
public class ProductController { 
	public static final String SAVED_DIR = "/attachfile";

	@Autowired ProductDao productDao;
	@Autowired ServletContext servletContext;

	@RequestMapping("list")
	public String list(
			Model model) throws Exception {

		List<Product> products = productDao.selectList();

		model.addAttribute("products", products);

		return "product/ProductList";
	}

	@RequestMapping(value="search", method=RequestMethod.GET)
	public String search(
			String content,
			Model model) throws Exception {

		List<Product> products = productDao.search(content);

		model.addAttribute("products", products);

		return "product/ProductSearchList";
	}

	@RequestMapping(value="add", method=RequestMethod.GET)
	public String add() {
		return "product/ProductForm";
	}

	@RequestMapping(value="add", method=RequestMethod.POST)
	public String add(
			Product product,
			Users member,
			MultipartFile photofile,
			HttpSession session
			) throws Exception {

		if (photofile.getSize() > 0) {
			String newFileName = MultipartHelper.generateFilename(photofile.getOriginalFilename());  
			File attachfile = new File(servletContext.getRealPath(SAVED_DIR) 
					+ "/" + newFileName);

			photofile.transferTo(attachfile);
			product.setPphoto(newFileName);
		}

		productDao.insert(product);
		return "redirect:list.do";
	}

	@RequestMapping("detail")
	public String detail(
			int no,
			String email,
			Model model) throws Exception {

		Product product = productDao.selectOne(no);

		model.addAttribute("product", product);
		return "product/ProductDetail";
	}

	@RequestMapping(value="update", method=RequestMethod.POST)
	public String update(
			Product product,
			MultipartFile photofile,
			Model model) throws Exception {

		if (photofile.getSize() > 0) {
			String newFileName = MultipartHelper.generateFilename(photofile.getOriginalFilename());  
			File attachfile = new File(servletContext.getRealPath(SAVED_DIR) 
					+ "/" + newFileName);

			photofile.transferTo(attachfile);
			product.setPphoto(newFileName);

		}   else if (product.getPphoto().length() == 0) {
			product.setPphoto(null);
		}

		if (productDao.update(product) <= 0) {
			model.addAttribute("errorCode", "401");
			return "product/ProductAuthError";
		} 
		return "redirect:list.do";
	}

	@RequestMapping("delete")
	public String delete(
			int no,
			Model model) throws Exception {

		if (productDao.delete(no) <= 0) {
			model.addAttribute("errorCode", "401");
			return "product/ProductAuthError";
		}
		return "redirect:list.do";
	}

}