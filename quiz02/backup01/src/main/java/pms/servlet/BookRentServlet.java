package pms.servlet;

import java.io.PrintStream;
import java.util.HashMap;

import pms.annotation.Component;
import pms.dao.BookDao;
import pms.domain.Book;

@Component("/book/rent")
public class BookRentServlet implements Servlet {
	BookDao bookDao;

	public void setBoardDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}

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
			out.println("이미 대여된 도서입니다.");
		else 
			out.println("대여처리 되었습니다.");

		book.setNo(no);
		book.setRent(true);
		bookDao.rent(book);
	}
}