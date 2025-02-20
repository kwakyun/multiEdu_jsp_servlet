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

    <form action="d_searchList.do" method="get">
        <select name="searchKey">
            <option value="department_name">department_name</option>
            <option value="manager_id">manager_id</option>
        </select>
        <input type="text" name="searchWord" value="ti"/>
        <input type="submit" value="search"/>
    </form>
    <table id="customers">
        <tr>
            <th>department_id</th>
            <th>department_name</th>
            <th>manager_id</th>
            <th>location_id</th>
        </tr>

        <c:forEach var="vo" items="${vos}">
        <tr>
            <td><a href="d_selectOne.do?department_id=${vo.department_id}">${vo.department_id}</a></td>
            <td>${vo.department_name}</td>
            <td>${vo.manager_id}</td>
            <td>${vo.location_id}</td>
        </tr>
        </c:forEach>
        <tr>
            <td colspan="5">
                <a href="d_selectAll.do?cpage=1&limit=10">1</a>
                <a href="d_selectAll.do?cpage=2&limit=10">2</a>
                <a href="d_selectAll.do?cpage=3&limit=10">3</a>
                <a href="d_selectAll.do?cpage=4&limit=10">4</a>
            </td>
        </tr>
    </table>
 </body>
 </html>