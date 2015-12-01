<%-- JSTL(JSP Standard Tag Library) 사용법 --%>
<%@ page language="java" 
    contentType="text/plain; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%-- URL을 만드는 c:url 태그 --%>
<%-- c:url 태그 사용 전 --%>
<a href="https://www.google.co.kr/search?q=%ED%99%8D%EA%B8%B8%EB%8F%99&oq=%ED%99%8D%EA%B8%B8%EB%8F%99&aqs=chrome..69i57.2099j0j8&sourceid=chrome&es_sm=119&ie=UTF-8">구글 검색(홍길동)</a>

<%-- c:url 태그 사용 후 --%>
<c:url var="googleUrl" value="https://www.google.co.kr/search">
  <c:param name="q" value="홍길동"/>
  <c:param name="oq" value="홍길동"/>
  <c:param name="aqs" value="chrome..69i57.2099j0j8"/>
  <c:param name="sourceid" value="chrome"/>
  <c:param name="es_sm" value="119"/>
  <c:param name="ie" value="UTF-8"/>
</c:url>
















