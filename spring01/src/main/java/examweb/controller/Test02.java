package examweb.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;

import examweb.domain.Board;

@Controller
@RequestMapping("/ajax/test02")
public class Test02 {
	
	@RequestMapping
	public ResponseEntity<String> execute() {
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
		
		HashMap<String,Object> resultMap = new HashMap<>();
		resultMap.put("status", "success");
		resultMap.put("data", list);
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "text/plain;charset=UTF-8");
		
		return new ResponseEntity<>(
				new Gson().toJson(resultMap),
				headers,
				HttpStatus.OK);
	}
}
