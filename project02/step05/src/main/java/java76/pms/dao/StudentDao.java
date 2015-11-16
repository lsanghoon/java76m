package java76.pms.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java76.pms.annotation.Component;
import java76.pms.domain.Student;

@Component
public class StudentDao {
	SqlSessionFactory sqlSessionFactory;

	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}
	
	public StudentDao() {}

	public List<Student> selectList(int pageNo, int pageSize,
			String keyword, String align) {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		try {
			HashMap<String,Object> paramMap = new HashMap<>();
      paramMap.put("startIndex", (pageNo - 1) * pageSize);
      paramMap.put("length", pageSize);
      paramMap.put("keyword", keyword);
			paramMap.put("align", align);
      
			return sqlSession.selectList(
					"java76.pms.dao.StudentDao.selectList", paramMap);

		} finally {
			try {sqlSession.close();} catch (Exception e) {}
		}
	}

	public int insert(Student student) {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		try {
			return sqlSession.insert("java76.pms.dao.StudentDao.insert", student);
			
		} finally {
			try {sqlSession.close();} catch (Exception e) {}
		}
	}

	public int delete(int no) {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		try {
			return sqlSession.delete("java76.pms.dao.StudentDao.delete", no);
			
		} finally {
			try {sqlSession.close();} catch (Exception e) {}
		}
	}
	
	public int update(Student student) {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		try {
			return sqlSession.update("java76.pms.dao.StudentDao.update", student);
			
		} finally {
			try {sqlSession.close();} catch (Exception e) {}
		}
	}
}
