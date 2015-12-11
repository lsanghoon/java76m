<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String region  =  request.getParameter("region");
out.println("<select name='pcate'>");
if(region.equals("Outer")){
 out.println("<option value=''>선택하세요</option> ");
 out.println("<option value='cardigan'>가디건</option> ");
 out.println("<option value='jacket'>자켓</option> ");
 out.println("<option value='coat'>코트</option> "); 
 out.println("<option value='jumper'>점퍼/야상</option> ");
 
} else if(region.equals("Top")) {
 out.println("<option value=''>선택하세요</option> "); 
 out.println("<option value='longT'>긴팔</option> "); 
 out.println("<option value='shortT'>반팔</option> ");
 out.println("<option value='shirt'>셔츠</option> ");
 
} else if(region.equals("Dress")) {
	 out.println("<option value=''>선택하세요</option> "); 
	 out.println("<option value='slim'>슬림</option> "); 
	 out.println("<option value='loose'>루즈</option> "); 
	 
} else if(region.equals("Pants")) {
	 out.println("<option value=''>선택하세요</option> "); 
	 out.println("<option value='longP'>롱팬츠</option> "); 
	 out.println("<option value='shortP'>숏팬츠</option> ");
	 
} else if(region.equals("Bag")) {
	 out.println("<option value=''>선택하세요</option> "); 
	 out.println("<option value='shoulder'>숄더백</option> "); 
	 out.println("<option value='clutch'>클러치백</option> "); 
	 
}

out.println("</select>");
%>