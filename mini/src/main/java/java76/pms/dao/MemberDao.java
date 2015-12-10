package java76.pms.dao;

import java.util.List;
import java.util.Map;

import java76.pms.domain.Users;

public interface MemberDao {
  List<Users> selectList();

  int insert(Users member);

  int delete(String email);
  
  int update(Users member);

  Users selectOne(String email);
  
  Users login(Map<String,Object> paramMap);
}







