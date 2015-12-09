<%@page import="org.springframework.beans.factory.annotation.Autowired"%>
<%@page import="java76.pms.dao.MemberDao"%>
<%@ page contentType = "text/plain; charset=euc-kr" %>
<%@ page import = "java.util.List" %>
<%
String email = request.getParameter("email");
MemberDao dao = new MemberDao();
int re = 0;
if (dao.check(email) > 0) {
	re = 1;
}
%>
<%=re%>