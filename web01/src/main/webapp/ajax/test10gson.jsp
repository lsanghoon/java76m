<%@page import="com.google.gson.Gson"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="vo.Board"%>
<%@ page language="java"
    contentType="text/plain; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="boards"
             class="java.util.ArrayList"
             type="java.util.List<Board>"
             scope="session"/>
             
<%
// 다른 클라이언트에서 AJAX 요청 결과를 가져갈 수 있도록 허락한다.
response.setHeader("Access-Control-Allow-Origin", "*");

Board board = new Board();
board.setTitle("1113");
board.setContent("xxxxxx");
boards.add(board);

board = new Board();
board.setTitle("2223");
board.setContent("xxxxxax");
boards.add(board);

board = new Board();
board.setTitle("3333");
board.setContent("axxxxxx");
boards.add(board);


//클라이언트에게 전달할 데이터를 담을 맵 객체를 생성한다.
HashMap<String,Object> resultMap = new HashMap<>();
resultMap.put("status", "success");
resultMap.put("data", boards);

//DB에서 꺼낼꺼면 하지 않아도 된다 for문
int no = 0;
for (Board b : boards) {
	b.setNo(++no);
}

out.print(new Gson().toJson(resultMap));
%>

<%-- <%=new Gson().toJson(resultMap)%> --%>
