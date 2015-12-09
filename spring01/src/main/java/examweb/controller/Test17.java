package examweb.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import examweb.domain.Member;

@Controller 
@RequestMapping("/test17/*")
@SessionAttributes("member")
public class Test17 {
	private static final Logger log = Logger.getLogger(Test17.class);
	
  @RequestMapping(value="s1")
  public void s1() throws Exception {
  }
  
  /* 파라미터 변수에 @ModelAttribute를 붙이는 경우,
   * 그 변수가 @SessionAttributes에 지정된 경우,
   * => 처리 절차
   * 		1) 세션에 파라미터에 지정된 객체를 찾는다. 없으면 오류 발생!
   * 		2) 요청 파라미터 이름과 일치하는 프로퍼티를 찾아 값을 넣는다.
   * => @ModelAttribute가 가리키는 변수가 @SessionAttributes에 등록되어 있다면,
   *  	파라미터로 사용하기 전에 
   */
  @RequestMapping(value="s2")
  public void s2(@ModelAttribute Member member) throws Exception {
  	log.debug(member.toString());
  }
  
  @RequestMapping(value="s3")
  public void s3(@ModelAttribute Member member) throws Exception {
  	log.debug(member.toString());
  }
  
  @RequestMapping(value="s4")
  public void s4(@ModelAttribute Member member) throws Exception {
  	log.debug(member.toString());
  }
  

}





