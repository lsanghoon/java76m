package java76.pms.dao;

import java.util.List;
import java.util.Map;

import java76.pms.domain.Member;

public interface MemberDao {
  List<Member> selectList();

  int insert(Member member);

  int delete(String email);
  
  int update(Member member);

  Member selectOne(String email);
  
  int check(String email);

  Member login(Map<String,Object> paramMap);
}







