package examweb.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import examweb.domain.Board;

@Controller
@RequestMapping("/ajax/test01")
public class Test01 {
	
	@RequestMapping
	public String execute(Model model) {
		ArrayList<Board> list = new ArrayList<>();
		
		list.add(new Board().setNo(1)
												.setTitle("제목:111a")
												.setContent("내용:xxxxa"));
		
		list.add(new Board().setNo(2)
												.setTitle("제목:111b")
												.setContent("내용:xxxxb"));
		
		list.add(new Board().setNo(3)
												.setTitle("제목:111c")
												.setContent("내용:xxxxc"));
		
		model.addAttribute("list", list);
		
		return "ajax/test01";
	}
}
