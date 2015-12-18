package java76.pms.controller.ajax;

import java.io.File;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java76.pms.dao.BoardDao;
import java76.pms.domain.AjaxResult;
import java76.pms.domain.Board;
import java76.pms.util.MultipartHelper;

@Controller("ajax.BoardController")
@RequestMapping("/board/ajax/*")
public class BoardController { 
	public static final String SAVED_DIR = "/attachfile";
	
	@Autowired BoardDao boardDao;
	@Autowired ServletContext servletContext;

	@RequestMapping("list")
	public Object list(
			@RequestParam(defaultValue="1") int pageNo,
			@RequestParam(defaultValue="10") int pageSize,
			@RequestParam(defaultValue="no") String keyword,
			@RequestParam(defaultValue="desc") String align) throws Exception {

		HashMap<String,Object> paramMap = new HashMap<>();
		paramMap.put("startIndex", (pageNo - 1) * pageSize);
		paramMap.put("length", pageSize);
		paramMap.put("keyword", keyword);
		paramMap.put("align", align);

		List<Board> boards = boardDao.selectList(paramMap);

		HashMap<String,Object> resultMap = new HashMap<>();
		resultMap.put("status", "success");
		resultMap.put("data", boards);

		return resultMap;
	}

	@RequestMapping(value="add", method=RequestMethod.GET)
	public String add() {
		return "board/BoardForm";
	}
	
	@RequestMapping(value="add", method=RequestMethod.POST)
	public String add(
			Board board,
			MultipartFile file) throws Exception {

		if (file.getSize() > 0) {
			String newFileName = MultipartHelper.generateFilename(file.getOriginalFilename());  
			File attachfile = new File(servletContext.getRealPath(SAVED_DIR) 
																  + "/" + newFileName);
			file.transferTo(attachfile);
			board.setAttachFile(newFileName);
		}

		boardDao.insert(board);

		return "redirect:list.do";
	}

	@RequestMapping("detail")
	public Object detail(int no) throws Exception {

		Board board = boardDao.selectOne(no);
		return new AjaxResult("success", board);
	}

	@RequestMapping(value="update", method=RequestMethod.POST)
	public String update(
			Board board,
			MultipartFile file,
			Model model) throws Exception {


		if (file.getSize() > 0) {
			String newFileName = MultipartHelper.generateFilename(file.getOriginalFilename());  
			File attachfile = new File(servletContext.getRealPath(SAVED_DIR) 
																	+ "/" + newFileName);
			file.transferTo(attachfile);
			board.setAttachFile(newFileName);
			
		}	else if (board.getAttachFile().length() == 0) {
			board.setAttachFile(null);
		}

		if (boardDao.update(board) <= 0) {
			model.addAttribute("errorCode", "401");
			return "board/BoardAuthError";
		} 
		
		return "redirect:list.do";
	}

	@RequestMapping("delete")
	public AjaxResult delete(
			int no,
			String password) throws Exception {

		HashMap<String,Object> paramMap = new HashMap<>();
		paramMap.put("no", no);
		paramMap.put("password", password);

		if (boardDao.delete(paramMap) <= 0) {
			return new AjaxResult("failure", null);
		} 

		return new AjaxResult("success", null);
	}


	/*private String replace(String checkIndex) {
		if ( checkIndex != null ) {
			checkIndex = checkIndex.replaceAll("<","&lt;");
			checkIndex = checkIndex.replaceAll(">","&gt;");
		} 
		return checkIndex;

	}*/
}
