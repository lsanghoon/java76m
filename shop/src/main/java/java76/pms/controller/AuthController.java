package java76.pms.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java76.pms.dao.ProductDao;
import java76.pms.dao.UsersDao;
import java76.pms.domain.Product;
import java76.pms.domain.Users;

@Controller
@RequestMapping("/auth/*")
public class AuthController {  
  @Autowired UsersDao usersDao;
  @Autowired ProductDao productDao;

  @RequestMapping(value="list", method=RequestMethod.GET)
  public String list(Model model) {
  	
  	List<Product> products = productDao.selectList();
		model.addAttribute("products", products);
  	
  	return "product/adminList";
  }
  
  @RequestMapping("catelist")
	public String catelist(
			String pcate,
			Model model) throws Exception {
		
		List<Product> products = productDao.selectCate(pcate);
		model.addAttribute("products", products);
		
		return "product/adminList";
	}
  
  @RequestMapping("detail")
	public String detail(
			int no,
			Model model) throws Exception {

		Product product = productDao.selectOne(no);

		model.addAttribute("product", product);
		return "product/adminDetail";
	}
  
  @RequestMapping(value="login", method=RequestMethod.POST)
  public String login(
      String email,
      String password,
      String saveEmail,
      HttpServletResponse response,
      HttpSession session) {

    Cookie emailCookie = null;
    if (saveEmail != null) { // 이메일 저장을 체크했으면,
      emailCookie = new Cookie("email", email);
      emailCookie.setMaxAge(60 * 60 * 24 * 15);
    } else {
      emailCookie = new Cookie("email", "");
      emailCookie.setMaxAge(0); // 웹브라우저에게 email 쿠키 삭제를 명령한다.
    }
    response.addCookie(emailCookie);

    HashMap<String,Object> paramMap = new HashMap<>();
    paramMap.put("email", email);
    paramMap.put("password", password);
    
    Users users = usersDao.login(paramMap);

    if (users == null) { // 로그인 실패!
      session.invalidate(); // 세션을 무효화시킴. => 새로 세션 객체 생성!
      return "auth/LoginFail";
    }
    
    session.setAttribute("loginUser", users);

    if (users.getEmail().equals("admin@a.com"))
    	return "redirect:list.do";
    
    return "redirect:../product/list.do";
  }
  
  @RequestMapping("logout")
  public String logout(HttpSession session) {
    
    session.invalidate();
    return "redirect:../product/list.do";
  }
}

