package examweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import examweb.domain.Board;
import examweb.domain.Member;

@Controller 
@RequestMapping("/test16/*")
public class Test16 {
  /* @ModelAttribute 사용 전
   * 
   * 참고!
   * 빈의 이름을 리턴하지 않으면 프론트 컨트롤러는 다음의 규칙에 따라 뷰 컴포넌트를 찾는다.
   * 1) 요청 URL = http://localhost:8080/spring01/test16/e1.do
   * 2) 뷰의 이름 = 접두사 + 서블릿 이름(확장자 제거) + 접미사
   * 							/WEB-INF/jsp/ + test16/e1 + .jsp
   * 							/WEB-INF/jsp/test16/e1.jsp
   */
  @RequestMapping(value="e1")
  public void e1(Model model) throws Exception {
  	Member member = new Member();
  	member.setName("홍길동");
  	member.setAge(30);
  	
  	// Model에 저장할 때 key를 지정하지 않으면
  	// 클래스 이름을 key로 사용한다. 단, 클래스 이름의 첫 알파벳은 소문자로 만든다.
  	model.addAttribute(member);
  }
  
  /* 메서드앞에 @ModelAttribute 붙이기
   * => 메서드가 리턴하는 값은 자동으로 Model 객체에 저장된다.
   * => Model에 저장할 때 key는 리턴 값의 클래스 이름(첫 알파벳은 소문자)를 사용한다.
   */
  @RequestMapping(value="e2")
  @ModelAttribute
  public Board e2() throws Exception {
  	Board board = new Board();
  	board.setNo(1);
  	board.setTitle("제목이라네");
  	board.setContent("내용이라네");
  	return board;
  }
  
  /* 여러 개의 객체를 @ModelAttribute 붙이기
   * => 메서드 앞에 @ModelAttribute를 선언해 봐야 소용없다. => 리터
   * => 메서드가 리턴하는 값은 자동으로 Model 객체에 저장된다.
   * => Model에 저장할 때 key는 리턴 값의 클래스 이름(첫 알파벳은 소문자)를 사용한다.
   */
  @RequestMapping(value="e3")
  public void e3(Model model) throws Exception {
  	Member member = new Member();
  	member.setName("홍길동");
  	member.setAge(30);
  	
  	Board board = new Board();
  	board.setNo(1);
  	board.setTitle("제목이라네");
  	board.setContent("내용이라네");
  	
  	model.addAttribute(member);
  	model.addAttribute(board);
  }
  
  /* 파라미터 변수에 @ModelAttribute 붙이기
   * => 처리 절차
   * 		1) 객체를 생성한다.
   * 		2) 요청 파라미터의 이름과 일치하는 프로퍼티가 있다면 값을 넣는다.
   * 		3) 객체를 Model에 저장한다.
   */
  @RequestMapping(value="e4")
  public void e4(@ModelAttribute Member member) throws Exception {
  }
  
}





