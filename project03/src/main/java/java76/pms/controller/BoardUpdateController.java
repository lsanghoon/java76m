package java76.pms.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java76.pms.dao.BoardDao;
import java76.pms.domain.Board;
import java76.pms.util.MultipartHelper;

@Component("/board/update.do")
public class BoardUpdateController implements PageController {
	@Autowired BoardDao boardDao;

	@Override
	public String execute(HttpServletRequest request, 
			HttpServletResponse response)
					throws Exception {
		if (request.getMethod().equals("GET"))
			return get(request, response);
		else
			return post(request, response);
	}

	public String get(HttpServletRequest request, 
			HttpServletResponse response)
					throws Exception {

		int no = Integer.parseInt(request.getParameter("no"));

		Board board = boardDao.selectOne(no);
		
		request.setAttribute("board", board);
		return "/board/BoardDetail.jsp";
	}

	// POST 요청이 들어오면 해당 게시물을 입력한 값으로 변경한다.
	public String post(HttpServletRequest request, 
			HttpServletResponse response)
					throws Exception {
		
		Map<String, String> paramMap = 
				MultipartHelper.parseMultiDate(request, 
						request.getServletContext().getRealPath("/attachfile"));
		
		Board board = new Board();

		board.setNo(Integer.parseInt(paramMap.get("no")));
		board.setTitle(paramMap.get("title"));
		board.setContent(paramMap.get("content"));
		board.setPassword(paramMap.get("password"));
		
		if (paramMap.get("attachFile") != null) {
			board.setAttachFile(paramMap.get("attachFile"));
		}	else if (paramMap.get("attach").length() > 0) {
			board.setAttachFile(paramMap.get("attach"));
		}
		System.out.println("out~~");

		if (boardDao.update(board) <= 0) {
			request.setAttribute("errorCode", "401");
			return "/board/BoardAuthError.jsp";
		}

		return "redirect:list.do";
	}
}
