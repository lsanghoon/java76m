package pms.servlet;

import java.io.PrintStream;
import java.util.HashMap;

import pms.annotation.Component;
import pms.dao.BookDao;
import pms.domain.Book;

@Component("/book/list")
public class BookListServlet implements Servlet {
	BookDao bookDao;

	public void setBookDao(BookDao bookDao) {
	  this.bookDao = bookDao;
	}
	
	@Override
	public void service(HashMap<String, Object> params) {
		PrintStream out = (PrintStream)params.get("out");

		out.printf("%-3s %-18s %-8s %-10s\n", 
				"No", "Title", "Authors", "press"); 

		for (Book book : bookDao.selectList()) {
			if (book == null)
				continue;
			String[] authors = book.getAuthors().split(",");
				out.printf("%3d %-18s %-8s %-10s\n", 
				    book.getNo(),
						book.getTitle(),
						authors[0],
						book.getPress());
		}
	}

}