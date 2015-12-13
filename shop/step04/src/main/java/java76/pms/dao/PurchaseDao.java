package java76.pms.dao;

import java.util.List;

import java76.pms.domain.Purchase;

public interface PurchaseDao {
  List<Purchase> selectList();
  
  int insert(Purchase purchase);
  
  int delete(int no);
  
  List<Purchase> selectOne(String email);
  
  List<Purchase> selectChart();
}







