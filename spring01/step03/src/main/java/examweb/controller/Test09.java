package examweb.controller;

import java.io.Writer;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/test09/*")
public class Test09 {

	@RequestMapping("e1")
	public ModelAndView e1() throws Exception {
		
		//JSP에 전달할 데이터 + JSP 이름
		ModelAndView mv = new ModelAndView();
		
		//JSP에 전달할 값을 저장한다.
		// 프론트 컨트롤러는 이 객체에 저장된 값을 꺼내 HttpServletRequest 객체에 옮길 것이다.
		mv.addObject("name", "설현");
		mv.addObject("age", 21);
		
		// JSP 이름을 지정한다.
		mv.setViewName("/test09/e1.jsp");
		
		return mv;
	}
	
	@RequestMapping("e2")
	public String e2(Model model) throws Exception {
		
		model.addAttribute("name", "이성경");
		model.addAttribute("age", 25);
		
		
		return "/test09/e1.jsp";
	}
	
	@RequestMapping("e3")
	@ResponseBody
	public String e3() throws Exception {
		
		return "Hello~ 방가방가";
	}

	@RequestMapping("e4")
	public void e4(Writer out) throws Exception {
		out.write("Hello~ 방가방가");
	}
	
	@RequestMapping("e5")
	@ResponseBody
	public String e5(HttpServletResponse response) throws Exception {
		
		// 다음 두가지 방법을 동원해도 한글 깨짐!
		//response.setContentType("text/html;charset=UTF-8");
		//response.setHeader("Content-Type", "text/html;charset=UTF-8");
		
		// 해결책?
		// e6()를 보라
		return "Hello~ 방가방가";
	}
	
	// 페이지 컨트롤러에서 한글 데이터를 바로 출력 할 경우,
	// HttpEntitysㅏ ResponseEntity에 담아서 리턴하라!
	@RequestMapping("e6")
	public ResponseEntity<String> e6() throws Exception {
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "text/html;charset=UTF-8");
		
		ResponseEntity<String> responseEntity = new ResponseEntity<>(
				"Hello~ 방가방가",			// 클라이언트에게 보낼 데이터
				headers,							// 응답 해더
				HttpStatus.CREATED);	// 응답 상태 코드
		
	return responseEntity;
		
	}
	
}















