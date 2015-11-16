package pms.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pms.domain.Book;

@Component
public class BookDao {
	@Autowired
	SqlSessionFactory sqlSessionFactory;

  public BookDao() {}

  public List<Book> selectList(int pageNo, int pageSize, 
			String keyword, String align) {
  	
  	SqlSession sqlSession = sqlSessionFactory.openSession(true);
	
  	try {
  		HashMap<String,Object> paramMap = new HashMap<>();
      paramMap.put("startIndex", (pageNo - 1) * pageSize);
      paramMap.put("length", pageSize);
			paramMap.put("keyword", keyword);
			paramMap.put("align", align);
			
			return sqlSession.selectList("pms.dao.BookDao.selectList", paramMap);

		} finally {
			try {sqlSession.close();} catch (Exception e) {}
		}
	}

  public int insert(Book book) {
  	SqlSession sqlSession = sqlSessionFactory.openSession(true);
		try {
			return sqlSession.insert("pms.dao.BookDao.insert", book);

		} finally {
			try {sqlSession.close();} catch (Exception e) {}
		}
	}

  public int delete(int no) {
  	SqlSession sqlSession = sqlSessionFactory.openSession(true);
		try {
			return sqlSession.delete("pms.dao.BookDao.delete", no);

		} finally {
			try {sqlSession.close();} catch (Exception e) {}
		}
	}

  public int update(Book book) {
  	SqlSession sqlSession = sqlSessionFactory.openSession(true);
		try {
			return sqlSession.update("pms.dao.BookDao.update", book);

		} finally {
			try {sqlSession.close();} catch (Exception e) {}
		}
	}
  
  public Book detail(int no) {
  	SqlSession sqlSession = sqlSessionFactory.openSession(true);
		try {
			return sqlSession.selectOne("pms.dao.BookDao.detail", no);

		} finally {
			try {sqlSession.close();} catch (Exception e) {}
		}
	}
  
  public int rent(Book book) {
  	SqlSession sqlSession = sqlSessionFactory.openSession(true);
		try {
			return sqlSession.update("pms.dao.BookDao.rent", book);

		} finally {
			try {sqlSession.close();} catch (Exception e) {}
		}
	}
}