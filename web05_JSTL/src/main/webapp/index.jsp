<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
 <!DOCTYPE html>
 <html>
 <head>
    <title>index.jsp</title>
 </head>
 <body>
    <h1>Hello World!</h1>
    <br/>
    <hr>
    <c:forEach var="i" begin="1" end="10">
        JSTL ${i}
    </c:forEach>
    <hr>
    <c:forEach var="i" begin="1" end="10" step="2">
        JSTL ${i}
    </c:forEach>
    <hr>
    <c:forEach var="i" begin="1" end="10">
        <c:if test="${i>5}">${i}</c:if>
    </c:forEach>
    <hr>
    ${10+3}
    ${10-3}
    ${10*3}
    ${10/3}
    ${10%3}
    <hr>
    ${10==3}
    ${10!=3}
    ${10>=3}
    ${10 ge 3}
    ${10<=3}
    ${10 le 3}
    ${10>3}
    ${10 gt 3}
    ${10<3}
    ${10 lt 3}
    <hr>
    http://localhost:8080/web05_JSTL/?name=kim
    <hr>
    ${param.name}
    <hr>
    ${param.name == null}
    ${param.name eq null}
    ${param.name eq 'kim'}
    <hr>
    ${param.name != null}
    ${param.name ne null}
    ${param.name ne 'kim'}
    <hr>
    ${true and true}
    ${true && true}
    <hr>
    ${true or false}
    ${true || false}
    <hr>
    <c:if test="${param.name == null}">파라미터가 없습니다.</c:if>
    <c:if test="${param.name eq null}">파라미터가 없습니다.</c:if>
    <c:if test="${empty param.name}">파라미터가 없습니다.</c:if>
    <c:if test="${not empty param.name}">파라미터가 비어있지않습니다.</c:if>
    <hr>
    <c:set var="result" value="kim21"></c:set>
    <hr>
    <c:choose>
        <c:when test="${result == 'kim11'}">${result}</c:when>
        <c:when test="${result == 'kim21'}">${result}</c:when>
        <c:when test="${result == 'kim31'}">${result}</c:when>
        <c:when test="${result == 'kim41'}">${result}</c:when>
        <c:otherwise>otherwise</c:otherwise>
    </c:choose>
    <hr>
    <c:catch var="ex">
        <%
            int[] sus = new int[5];//0,0,0,0,0
            out.print("sus[0] : "+sus[0]);
            out.print("sus[4] : "+sus[5]);
        %>
    </c:catch>
    ${ex}
    <hr>
    <c:set var="name" value="kim"></c:set>
    ${name} ${fn:length(name)}
    <c:remove var="name"></c:remove>
    ${name}
 </body>
 </html>