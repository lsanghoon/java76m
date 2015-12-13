package java76.pms.dao;

import java.util.List;
import java.util.Map;

import java76.pms.domain.Users;

public interface UsersDao {
  List<Users> selectList();

  int insert(Users users);

  int delete(String email);
  
  int update(Users users);
  
  int updatePoint(Users users);

  Users point(String email);
  
  Users selectOne(String email);
  
  Users login(Map<String,Object> paramMap);
}







