[주제: JSP 사용법]
1. Template Data와 서블릿 클래스
  - JSP엔진은 .jsp 파일을 가지고 서블릿 클래스를 자동 생성한다.
  - 자동 생성된 코드는 어디?
    톰켓 임시 작업 폴더/work/ 디렉토리 아래에 있다. 확인할 것.
  - Test01.jsp
  
2. Scriptlet 태그의 사용
  - JSP 페이지 안에 자바 코드를 넣고 싶을 때
  - Test02.jsp

3. Expression 태그의 사용
  - 계산식의 결과를 출력하고 싶을 때
  - Test03.jsp

4. Declaration 태그의 사용
  - 서블릿 클래스에 필드나 메서드를 추가하고 싶을 때
  - Test04.jsp

5. 스크립트릿에서 사용할 클래스를 임포트하기
  - page 지시어의 import 속성을 사용하여 클래스 패키지 정보를 기술한다.
  - Test05.jsp

6. JSP 내장 변수 (Built-in variables)     
  - _jspService() 메서드 안에 공식적으로 선언된 변수.
  - JSP 엔진은 클래스를 자동 생성할 때 반드시 다음 변수를 _jspService() 메서드에
    선언해야 한다.
    request: HttpServletRequest
    response: HttpServletResponse
    pageContext: PageContext
    session: HttpSession
    application: ServletContext
    config: ServletConfig
    out: JspWriter
    page: Object (서블릿 인스턴스 자신을 가리킴. 즉 this와 같다.)
    error: Exception (오류를 처리하는 페이지라고 선언할 때만 이 변수가 생성된다.)

* whitespace? space(공백), new line, tab

7. <jsp:useBean> JSP 액션 태그 사용법
  - Test06.jsp
  
8. <jsp:include>, <jsp:forward>
  - Test07.jsp
  
[JSP Expression Language 사용법]
=> JSP 확장 태그. => 라이브러리 파이릉ㄹ 별도로 다운로드 해야한다.
=> build.gradle에 JSTL 라이브러리 추가




  
  
  
  
  
  
  
  
  