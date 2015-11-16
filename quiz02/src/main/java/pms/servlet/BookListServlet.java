package pms.servlet;

import java.io.PrintStream;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pms.dao.BookDao;
import pms.domain.Book;

@Component("/book/list")
public class BookListServlet implements Servlet {
	@Autowired
	BookDao bookDao;

	@Override
	public void service(HashMap<String, Object> params) {
		// <-- 페이징 처리
		int pageNo = 1;
		int pageSize = 10;

		if (params.get("pageNo") != null) {
			pageNo = Integer.parseInt((String)params.get("pageNo"));
		}
		if (params.get("pageSize") != null) {
			pageSize = Integer.parseInt((String)params.get("pageSize"));
		}
		// -->

		// <-- 정렬 처리
		String keyword = "no";
		String align = "desc";

		if (params.get("keyword") != null) {
			keyword = (String)params.get("keyword");
		}
		if (params.get("align") != null) {
			align = (String)params.get("align");
		}
		// -->

		PrintStream out = (PrintStream)params.get("out");

		out.printf("%-3s %-18s %-8s %-10s\n", 
				"No", "Title", "Authors", "press"); 

		for (Book book : bookDao.selectList(pageNo, pageSize, keyword, align)) {
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