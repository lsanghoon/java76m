[주제: 응답 다루기]
Servlet01.java 
  - Refresh : 클라이언트에게 응답할 때,
    일정 시간이 지난 후 다른 자원을 요청하게 만드는 기술.
  - 출력문을 호출하여 보낸 데이터는 내부 버퍼에 임시 보관된다.
  - 실행 결과를 잠깐 출력하고 다른 화면으로 바꾸고 싶을 때 사용
Servlet02.java
  - Redirect : 클라이언트에게 응답할 때 다시 요청할 자원의 주소를 알려준다.
    Refresh와 다른 점은 응답 상태 코드가 다르다.
    응답에 본문을 포함하지 않는다. 즉 헤더만 보낸다.
  - 결과 출력없이, 즉시 다른 화면으로 바꾸고 싶을 때 사용한다.  
Servlet03.java
  - forward : 클라이언트에게 응답을 하지 않고,
              다른 서블릿에게 실행을 위임하는 방법
  - OtherServlet.java 작성
  - 특정 상황에서 동일하게 처리하고 싶을 때 => 예) 오류 메시지 출력
  - servelt03.html을 사용하여 GET, POST 요청 보냄.
    GET요청인 경우 Servlet03.doGet() --(forwarding)--> OtherServlet.doGet()
    POST요청인 경우 Servlet03.doPost() --(forwarding)--> OtherServlet.doPost()
  