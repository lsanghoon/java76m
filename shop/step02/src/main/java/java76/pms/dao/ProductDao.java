package java76.pms.dao;

import java.util.List;

import java76.pms.domain.Product;

public interface ProductDao {
  List<Product> selectList();
  
  List<Product> selectCate(String pcate);
  
  int insert(Product product);
  
  int delete(int no);
  
  int update(Product product);
  
  int views(int no);

  Product selectOne(int no);
  
  List<Product> search(String name);
}







