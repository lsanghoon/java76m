package pms.servlet;

import java.io.PrintStream;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pms.dao.BookDao;

@Component("/book/delete")
public class BookDeleteServlet implements Servlet {
	@Autowired
	BookDao bookDao;

	public void service(HashMap<String,Object> params) {
		int no = Integer.parseInt((String)params.get("no"));

		PrintStream out = (PrintStream)params.get("out");

		if(bookDao.delete(no) > 0) {
			out.println("도서정보가 삭제되었습니다.");
		} else
			out.println("존재하지 않는 도서입니다.");
	}

}
