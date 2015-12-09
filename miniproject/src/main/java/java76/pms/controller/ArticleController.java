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

import java76.pms.dao.ArticleDao;
import java76.pms.domain.Article;
import java76.pms.util.MultipartHelper;

@Controller
@RequestMapping("/article/*")
public class ArticleController { 
	public static final String SAVED_DIR = "/attachfile";
	
	@Autowired ArticleDao articleDao;
	@Autowired ServletContext servletContext;

	@RequestMapping("list")
	public String list(
			Model model) throws Exception {

		List<Article> articles = articleDao.selectList();
		
		model.addAttribute("articles", articles);

		return "article/ArticleList";
	}

	
	@RequestMapping(value="add", method=RequestMethod.GET)
	public String add() {
			return "article/ArticleForm";
	}
	
	@RequestMapping(value="add", method=RequestMethod.POST)
	public String add(
			Article article,
			//Member member,
			HttpSession session,
			MultipartFile photo) throws Exception {
		System.out.println("in");
		if (photo.getSize() > 0) {
			String newFileName = MultipartHelper.generateFilename(photo.getOriginalFilename());  
			File attachfile = new File(servletContext.getRealPath(SAVED_DIR) 
																  + "/" + newFileName);
			photo.transferTo(attachfile);
			article.setPhoto(newFileName);
		}
		
		//member = (Member) session.getAttribute("loginUser");
		//article.setName(member.getName());
		//article.setMphoto(member.getPhoto());
		articleDao.insert(article);
		System.out.println("insert");
		return "redirect:list.do";
	}

	@RequestMapping("detail")
	public String detail(
			String email,
			Model model) throws Exception {

		List<Article> articles = articleDao.selectMy(email);
		model.addAttribute("articles", articles);
		
		return "article/ArticleDetail";
	}

	@RequestMapping(value="update", method=RequestMethod.POST)
	public String update(
			Article article,
			MultipartFile file,
			Model model) throws Exception {


		if (file.getSize() > 0) {
			String newFileName = MultipartHelper.generateFilename(file.getOriginalFilename());  
			File attachfile = new File(servletContext.getRealPath(SAVED_DIR) 
																	+ "/" + newFileName);
			file.transferTo(attachfile);
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
			Model model) throws Exception {

		if (articleDao.delete(no) <= 0) {
			model.addAttribute("errorCode", "401");
			return "article/ArticleAuthError";
		} 

		return "redirect:list.do";
	}

}
