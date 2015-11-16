package pms.servlet;

import java.io.PrintStream;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pms.dao.BookDao;
import pms.domain.Book;

@Component("/book/add")
public class BookAddServlet implements Servlet {
	@Autowired
	BookDao bookDao;
	
	@Override
	public void service(HashMap<String,Object> params) {
		Book book = new Book();
		
		book.setTitle((String)params.get("title"));
		book.setAuthors((String)params.get("authors"));
		book.setPress((String)params.get("press"));
		book.setTag((String)params.get("tag"));
			
		bookDao.insert(book);
		
		PrintStream out = (PrintStream)params.get("out");
		out.println("도서정보가 등록되었습니다.");
		out.println();
	}


}
