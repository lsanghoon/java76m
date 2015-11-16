package pms.servlet;

import java.io.PrintStream;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pms.dao.BookDao;
import pms.domain.Book;

@Component("/book/return")
public class BookReturnServlet implements Servlet {
	@Autowired
	BookDao bookDao;

	@Override
	public void service(HashMap<String,Object> params) {
		PrintStream out = (PrintStream)params.get("out");
		int no = Integer.parseInt((String)params.get("no"));
		
		Book book = bookDao.detail(no);
		if (book == null) {
			out.println("존재하지않는번호");
			return;
		}
		if (book.isRent())
				out.println("반납처리가 되었습니다.");
			else
				out.println("이미 반납된 도서입니다.");

		book.setNo(no);
		book.setRent(false);
		bookDao.rent(book);
	}
}