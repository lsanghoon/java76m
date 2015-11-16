package java76.pms.servlet;

import java.io.PrintStream;
import java.sql.Date;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java76.pms.dao.BoardDao;
import java76.pms.domain.Board;

@Component("/board/update")
public class BoardUpdateServlet implements Servlet {
	@Autowired
	BoardDao boardDao;

	@Override
	public void service(HashMap<String,Object> params) {
		Board board = new Board();

		board.setNo((int) params.get("no"));
		board.setTitle((String)params.get("title"));
		board.setContent((String)params.get("content"));
		board.setCreatedDate(Date.valueOf((String)params.get("createddate")));
		board.setPassword((String)params.get("password"));

		PrintStream out = (PrintStream)params.get("out");

		if (boardDao.update(board) > 0) {
			out.println("수정하였습니다.");
		} else
			out.println("유효하지 않습니다.");
	}


}
