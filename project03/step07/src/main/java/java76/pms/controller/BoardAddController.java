package java76.pms.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java76.pms.dao.BoardDao;
import java76.pms.domain.Board;
import java76.pms.util.MultipartHelper;

@Component("/board/add.do")
public class BoardAddController implements PageController {
	@Autowired BoardDao boardDao;

	@Override
	public String execute(HttpServletRequest request, 
			HttpServletResponse response)
					throws Exception {

		Map<String,String> paramMap =
				MultipartHelper.parseMultiDate(
						request, request.getServletContext().getRealPath("/attachfile"));
		
		Board board = new Board();
		response.setContentType("text/plain;charset=UTF-8");

		board.setTitle(paramMap.get("title"));
		board.setContent(paramMap.get("content"));
		board.setPassword(paramMap.get("password"));
		board.setAttachFile(paramMap.get("attachFile"));

		boardDao.insert(board);
		return	"redirect:list.do";
	}


}
