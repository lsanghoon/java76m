package pms.servlet;

import java.io.PrintStream;
import java.util.HashMap;

import pms.annotation.Component;
import pms.dao.BookDao;
import pms.domain.Book;

@Component("/book/rent")
public class BookRentServlet01 implements Servlet {
	BookDao bookDao;

	public void setBoardDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}

	@Override
	public void service(HashMap<String,Object> params) {
		Book book = new Book();
		PrintStream out = (PrintStream)params.get("out");
		int no = Integer.parseInt((String)params.get("no"));

		for (Book books : bookDao.selectList()) {
			if (no != books.getNo())
				continue;
			if (books.isRent()) {
				out.println("이미 대여된 도서입니다.");
			} else {
				out.println("대여처리 되었습니다.");
			}
		}
		
		book.setNo(no);
		book.setRent(true);
		if (bookDao.rent(book) <= 0)
			out.println("존재하지않는번호");
	}
}
	
	
	/*@Override
	public void service(HashMap<String,Object> params) {
		Book book = new Book();
		PrintStream out = (PrintStream)params.get("out");
		int no = Integer.parseInt((String)params.get("no"));
		book.setNo(no);
		
		//book.setNo(Integer.parseInt((String)params.get("no")));
		
		if (bookDao.rent(book) > 0)
		else
			out.println("이미 대여된 도서이거나 존재하지 않는 책입니다.");



		for (Book books : bookDao.selectList()) {
			if (no != books.getNo())
				continue;
			if (books.isRent()) {
				out.println("이미 대여된 도서입니다.");
			} else {
				out.println("대여처리 되었습니다.");
			}
		}

		book.setRent(true);

	}


}*/
