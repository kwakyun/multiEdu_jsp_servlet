<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <!DOCTYPE html>
 <html>
 <head>
    <title>delete.jsp</title>
 </head>
 <body>
    <h1>회원 삭제 페이지</h1>
    <jsp:include page="../top_menu.jsp"/>
    ${param.num}번회원을 정말삭제하시겠습니까? <a href="m_deleteOK.do?num=${param.num}">OK</a>
 </body>
 </html>