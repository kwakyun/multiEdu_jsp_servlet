<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    //scriptlet tag : java code block
    String name = "kim";
    System.out.println(name);

    //out : jsp 내장객체(초기화가 되어있는객체) ex : request,response,session,,,,
    out.print("hello out..."+name);
    out.print("hello out...");
    out.print("안녕하세요");
    out.print("안녕하세요");
    out.print("<h1>안녕하세요</h1>");

    //request parameter 정보획득하기.(모두 문자열이다)
    //http://localhost:8080/web02_Controller/index.jsp?age=33&tel=010
    String age = request.getParameter("age");
    System.out.println("age:"+age);

    String tel = request.getParameter("tel");
    System.out.println("tel:"+tel);

    //request attribute 설정(setAttribute(key,value))
    request.setAttribute("user_id","admin");

    //request attribute 획득(getAttribute(key))
    String user_id = (String)request.getAttribute("user_id");
    System.out.println("user_id : "+ user_id);
%>
 <!DOCTYPE html>
 <html>
 <head>
    <title>index.jsp</title>
 </head>
 <body>
     <h1>Expression Tag :
        <%= name %> <%= age %> <%= request.getParameter("age") %>
        <%= request.getParameter("tel") %>
        <%= (String)request.getAttribute("user_id") %>
     </h1>
     <h1>EL(Expression Language) :
             ${param.age} ${param.tel} ${requestScope.user_id} ${user_id}
          </h1>
     <br/>
     <a href="hello-servlet">Hello Servlet</a>
     <a href="hello-jsp">Hello jsp</a>
     <a href="test">test jsp</a>
     <a href="test2.do?name=kim&age=44&tel=010">test2.do</a>
     <hr>
     <c:forEach var="i" begin="1" end="10">
        JSTL ${i}
     </c:forEach>
 </body>
 </html>