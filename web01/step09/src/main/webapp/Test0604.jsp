<%-- JSP 전용 태그(JSP Action 태그)
=> JSP 엔진이 서블릿 클래스를 만들 때 특정 자바 코드를 생성한다.
=> 클라이언트에게 보내는 콘텐츠가 아니다.

<jsp:useBean>
. ServletContext, ServletRequest, HttpSession, PageContext 보관소에서
  데이터를 꺼내는 자바 코드를 자동 생성하는 태그
--%>
<%@ page import="java.util.ArrayList"%>
<%@ page language="java" 
    contentType="text/plain; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>

<%
ArrayList<String> list = new ArrayList<>();
list.add("홍길동");
list.add("임꺽정");
list.add("유관순");

// ServletContext 보관소에 데이터 저장
application.setAttribute("names", list);
%>

<%-- 4) <jsp:useBean> 사용 
=> class 와 type 속성함께 사용
--%>

<jsp:useBean id="names3" 
  type="java.util.List<String>"
  class="java.util.ArrayList"
  scope="application"/>
  
<%-- 위의 JSP 액션 태그는 다음 자바 코드와 같다.
List<String> names = 
  (List<String>)application.getAttribute("names");

if (names == null) {
  names = new ArrayList();
  application.setAttribute("names", names);
}
--%>

<%-- 이름 목록을 출력한다. --%>
<%for (String s : names3) {%>
	* <%=s%>
<%}%>






