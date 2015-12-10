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
@RequestMapping("/article/*")
public class ProductController { 
	public static final String SAVED_DIR = "/attachfile";

	@Autowired ProductDao articleDao;
	@Autowired ServletContext servletContext;

	@RequestMapping("list")
	public String list(
			Model model) throws Exception {

		List<Product> articles = articleDao.selectList();
		
		model.addAttribute("articles", articles);

		return "article/ArticleList";
	}

	@RequestMapping(value="search", method=RequestMethod.GET)
	public String search(
			String content,
			Model model) throws Exception {

		List<Product> articles = articleDao.search(content);

		model.addAttribute("articles", articles);

		for (Product article : articles) {
			System.out.println("search : " + article.getContent());
		}
		return "article/ArticleSearchList";
	}

	@RequestMapping("gall")
	public String gall(
			String email,
			Model model) throws Exception {

		List<Product> articles = articleDao.selectMy(email);

		model.addAttribute("articles", articles);

		for (Product article : articles) {
			System.out.println(article.getName() + " : " + article.getPhoto());
		}

		return "article/ArticleMyList";
	}

	@RequestMapping(value="add", method=RequestMethod.GET)
	public String add() {
		return "article/ArticleForm";
	}

	@RequestMapping(value="add", method=RequestMethod.POST)
	public String add(
			Product article,
			Users member,
			MultipartFile photofile,
			HttpSession session
			) throws Exception {

		if (photofile.getSize() > 0) {
			String newFileName = MultipartHelper.generateFilename(photofile.getOriginalFilename());  
			File attachfile = new File(servletContext.getRealPath(SAVED_DIR) 
					+ "/" + newFileName);

			photofile.transferTo(attachfile);
			article.setPhoto(newFileName);
		}

		member = (Users) session.getAttribute("loginUser");

		article.setName(member.getName());
		String mp = member.getPhoto();

		article.setMphoto(mp);

		article.setEmail(member.getEmail());

		articleDao.insert(article);
		return "redirect:list.do";
	}

	@RequestMapping("detail")
	public String detail(
			int no,
			String email,
			Model model) throws Exception {

		Product article = articleDao.selectOne(no);
		System.out.println(article.getEmail());
		System.out.println(email);
		if (article.getEmail().equals(email)) {

			model.addAttribute("article", article);
			return "article/ArticleDetail";
		}
		return "redirect:list.do";
	}

	@RequestMapping(value="update", method=RequestMethod.POST)
	public String update(
			Product article,
			MultipartFile photofile,
			Model model) throws Exception {

		if (photofile.getSize() > 0) {
			String newFileName = MultipartHelper.generateFilename(photofile.getOriginalFilename());  
			File attachfile = new File(servletContext.getRealPath(SAVED_DIR) 
					+ "/" + newFileName);

			photofile.transferTo(attachfile);
			article.setPhoto(newFileName);

		}	else if (article.getPhoto().length() == 0) {
			article.setPhoto(null);
		}

		if (articleDao.update(article) <= 0) {
			model.addAttribute("errorCode", "401");
			return "article/ArticleAuthError";
		} 
		return "redirect:list.do";
	}

	@RequestMapping("delete")
	public String delete(
			int no,
			String email,
			Model model) throws Exception {

		Product article = articleDao.selectOne(no);

		if (article.getEmail().equals(email)) {
			if (articleDao.delete(no) <= 0) {
				model.addAttribute("errorCode", "401");
				return "article/ArticleAuthError";
			} 
		}
		return "redirect:list.do";
	}

}
