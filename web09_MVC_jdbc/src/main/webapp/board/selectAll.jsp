<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <!DOCTYPE html>
 <html>
 <head>
    <title>selectAll.jsp</title>
    <style>
    #customers {
      font-family: Arial, Helvetica, sans-serif;
      border-collapse: collapse;
      width: 100%;
    }

    #customers td, #customers th {
      border: 1px solid #ddd;
      padding: 8px;
    }

    #customers tr:nth-child(even){background-color: #f2f2f2;}

    #customers tr:hover {background-color: #ddd;}

    #customers th {
      padding-top: 12px;
      padding-bottom: 12px;
      text-align: left;
      background-color: #04AA6D;
      color: white;
    }
    </style>
 </head>
 <body>
    <h1>게시글 목록 페이지</h1>
    <jsp:include page="../top_menu.jsp"/>

    <form action="b_searchList.do" method="get">
        <select name="searchKey">
            <option value="title">title</option>
            <option value="content">content</option>
        </select>
        <input type="text" name="searchWord" value="ti"/>
        <input type="submit" value="search"/>
    </form>
    <table id="customers">
        <tr>
            <th>num</th>
            <th>title</th>
            <th>content</th>
            <th>writer</th>
            <th>wdate</th>
        </tr>

       <c:choose>
                <c:when test="${spage == null}">
                    <c:forEach var="vo" items="${vos}">
                        <tr>
                            <td><a href="b_selectOne.do?num=${vo.num}">${vo.num}</a></td>
                            <td>${vo.title}</td>
                            <td>${vo.content}</td>
                            <td>${vo.writer}</td>
                            <td>${vo.wdate}</td>
                        </tr>
                    </c:forEach>
                </c:when>
                <c:otherwise>
                    <c:forEach var="vo" items="${spageVos}">
                        <tr>
                            <td><a href="b_selectOne.do?num=${vo.num}">${vo.num}</a></td>
                            <td>${vo.title}</td>
                            <td>${vo.content}</td>
                            <td>${vo.writer}</td>
                            <td>${vo.wdate}</td>
                        </tr>
                    </c:forEach>
                </c:otherwise>
            </c:choose>

             <tr>
                 <td colspan="${cpage}">
                     <c:forEach var="i" begin="1" end="${cpage}">
                         <a href="b_selectAll.do?spage=${i}&limit=10">${i}</a>
                     </c:forEach>
                 </td>
             </tr>
         </table>
      </body>
      </html>