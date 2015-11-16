package pms.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import pms.annotation.Component;
import pms.domain.Book;

@Component
public class BookDao {
	SqlSessionFactory sqlSessionFactory;

	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

  public BookDao() {}

  public List<Book> selectList() {
  	SqlSession sqlSession = sqlSessionFactory.openSession(true);
		try {
			return sqlSession.selectList("pms.dao.BookDao.selectList");

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