package java76.pms.dao;

import java.util.List;

import java76.pms.domain.Product;

public interface ProductDao {
  List<Product> selectList();
  
  int insert(Product article);
  
  int delete(int no);
  
  int update(Product article);

  List<Product> selectMy(String email);
  
  Product selectOne(int no);
  
  List<Product> search(String content);
}







