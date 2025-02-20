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
    <h1>업무 목록 페이지</h1>
    <jsp:include page="../top_menu.jsp"/>

    <form action="j_searchList.do" method="get">
        <select name="searchKey">
            <option value="job_title">job_title</option>
            <option value="min_salary">min_salary</option>
            <option value="max_salary">max_salary</option>
        </select>
        <input type="text" name="searchWord" value="ti"/>
        <input type="submit" value="search"/>
    </form>
    <table id="customers">
        <tr>
            <th>job_id</th>
            <th>job_title</th>
            <th>min_salary</th>
            <th>max_salary</th>
        </tr>

        <c:forEach var="vo" items="${vos}">
        <tr>
            <td><a href="j_selectOne.do?job_id=${vo.job_id}">${vo.job_id}</a></td>
            <td>${vo.job_title}</td>
            <td>${vo.min_salary}</td>
            <td>${vo.max_salary}</td>
        </tr>
        </c:forEach>
        <tr>
            <td colspan="4">
                <a href="d_selectAll.do?cpage=1&limit=10">1</a>
                <a href="d_selectAll.do?cpage=2&limit=10">2</a>
                <a href="d_selectAll.do?cpage=3&limit=10">3</a>
                <a href="d_selectAll.do?cpage=4&limit=10">4</a>
            </td>
        </tr>
    </table>
 </body>
 </html>