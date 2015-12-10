package java76.pms.controller;

import java.util.HashMap;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java76.pms.dao.UsersDao;
import java76.pms.domain.Users;

@Controller
@RequestMapping("/auth/*")
public class AuthController {  
  @Autowired UsersDao memberDao;

  @RequestMapping(value="login", method=RequestMethod.GET)
  public String loginform() {
  	return "auth/LoginForm";
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
    
    Users member = memberDao.login(paramMap);

    if (member == null) { // 로그인 실패!
      session.invalidate(); // 세션을 무효화시킴. => 새로 세션 객체 생성!
      return "auth/LoginFail";
    }

    session.setAttribute("loginUser", member);
    return "redirect:../article/list.do";
  }
  
  @RequestMapping("logout")
  public String logout(HttpSession session) {
    
    session.invalidate();
    return "redirect:../article/list.do";
  }
}

