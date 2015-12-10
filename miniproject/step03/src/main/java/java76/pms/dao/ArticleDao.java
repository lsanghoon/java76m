package java76.pms.dao;

import java.util.List;

import java76.pms.domain.Article;

public interface ArticleDao {
  List<Article> selectList();
  
  int insert(Article article);
  
  int delete(int no);
  
  int update(Article article);

  List<Article> selectMy(String email);
  
  Article selectOne(int no);
  
  List<Article> search(String content);
}







