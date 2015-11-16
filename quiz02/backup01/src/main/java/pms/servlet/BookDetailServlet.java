package pms.servlet;

import java.io.PrintStream;
import java.util.HashMap;

import pms.annotation.Component;
import pms.dao.BookDao;
import pms.domain.Book;

@Component("/book/detail")
public class BookDetailServlet implements Servlet {
	BookDao bookDao;

	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}

	@Override
	public void service(HashMap<String, Object> params) {
		PrintStream out = (PrintStream)params.get("out");
		int no = Integer.parseInt((String)params.get("no"));

		Book book = bookDao.detail(no);
		if (book == null) {
			out.println("존재하지않는번호");
			return;
		}
		out.println("제	목 : " + book.getTitle());
		out.println("저	자 : " + book.getAuthors());
		out.println("출판사 : " + book.getPress());
		out.println("태	그 : " + book.getTag());
	}
}
