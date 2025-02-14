<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    String user_id = (String)request.getAttribute("user_id");
    System.out.println("user_id : "+user_id);
%>
<!DOCTYPE html>
<html>
<head>
    <title>hello.jsp</title>
</head>
<body>
    <h1>hello.jsp</h1>
    <h1>ET : <%= user_id%> <%= (String)request.getAttribute("user_id")%></h1>
    <h1>EL : ${user_id}</h1>
    <br/>
    <a href="index.jsp?age=33&tel=010">index.jsp</a>
    <a href="index.do?age=33&tel=010">index.do</a>
</body>
</html>