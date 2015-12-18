package examweb.controller;

import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller 
@RequestMapping("/test13/*") 
public class Test13 {
  private static final Logger logger = Logger.getLogger(Test13.class); 
  
  /* get과 post 구분하기
   */
  
  @RequestMapping(value="e1", method=RequestMethod.GET)
  public String get() throws Exception {
    
    return "test13/get";
  }

  @RequestMapping(value="e1", method=RequestMethod.POST)
  public String post() throws Exception {
    
    return "test13/post";
  }
}





