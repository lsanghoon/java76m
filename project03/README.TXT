[주제: GenericServlet 대신 HttpServlet 클래스 이용하기]
1. 기존 서블릿들의 수퍼 클래스를 HttpServlet으로 교체한다.
  - GET/POST 요청을 구분하여 처리한다.
2.

3. 삭제 서블릿에 Redirect 적용
  - 삭제한 후 즉시 목록을 출력한다.
4. 한글이 깨지지 않도록 응답을 설정하라.
  - response.setContentType("text/plain;charset=UTF-8");
5. 서블릿 실행 중에 오류가 발생하면,
    

6. 각 서블릿의 실행 결과 아래에 애플리케이션의 권한을 명시하라!






  
  
  
  
  
  
  
  
  
  