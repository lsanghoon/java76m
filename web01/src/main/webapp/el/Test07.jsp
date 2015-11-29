<%-- EL 사용법(Expression Language)
--%>
<%@page import="java.util.HashMap"%>
<%@page import="vo.Board"%>
<%@page import="java.sql.Date"%>
<%@ page language="java" 
    contentType="text/plain; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%-- EL에서 제공하는 기본 객체
pageContext     : PageContext
servletContext  : ServeltContext    => ${pageContext.servletContext.객체명}
session         : HttpSession       => ${pageContext.session.객체명}
request         : ServletRequest    => ${pageContext.request.객체명}
response        : ServletResponse   => ${pageContext.response.객체명}
param           : ${param.파라미터명}
paramValues     : ${paramValues.파라미터명}
header          : ${header.헤더명}
headerValues    : ${headerValues.헤더명}
cookie          : ${cookie.쿠키명}
initParam       : ${initParam.컨텍스트 초기화 파라미터명}
pageScope
requestScope
sessionScope
applicationScope
--%>
-------------------------------
<%-- 
=> 파라미터 값이 없으면 null이 아닌 빈 문자열 출력 
=> 예) localhost:8080/web01/Test07.jsp?name=홍길동&age=20
--%>
name 파라미터 값: ${param.name}
age 파라미터 값: ${param.age}
-------------------------------
<%-- 헤더 값 꺼내기 

--%>
User-Agent 헤더 값: ${header.["User-Agent"]}







