<%-- 클래스 임포트 하기
. <%@ page import="패키지정보"%>
. 기존의 page 태그에 붙여도 되고, 새로 page 태그를 선언해도 되다.
. 콤마(,)를 사용하여 여러개의 패키지를 임포트할 수 있다.
. 단 한 page 내에 여러 개의 import 속성이 올 수 없다.
선언 순서는 상관없다. 
어차피 서블릿 클래스의 상단에 import 문장이 추가될 것이기 때문이다. 
그래도 가능한 JSP 패이지에서 상단에 선언하라! 유지보수에 좋다
--%>
<%@ page import="java.util.ArrayList"%>
<%@ page language="java" 
    contentType="text/plain; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
ArrayList list2 = null;
%>











