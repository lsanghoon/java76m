package java76.pms.dao;

import java.util.List;

import java76.pms.domain.Cart;

public interface CartDao {
  List<Cart> selectList();
  
  int insert(Cart cart);
  
  int delete(int no);
  
  int deleteall(String email);
  
  int update(Cart cart);

  List<Cart> selectMy(String email);
  
}







