<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <!DOCTYPE html>
 <html>
 <head>
    <title>index.jsp</title>
 </head>
 <body>
     <h1>Hello World!</h1>
     <br/>
     <a href="hello-servlet">Hello Servlet</a>
     <a href="hello-jsp">Hello jsp</a>
     <hr>
     <c:forEach var="i" begin="1" end="10">
        JSTL
     </c:forEach>
 </body>
 </html>