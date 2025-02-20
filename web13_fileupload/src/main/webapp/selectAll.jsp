<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
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
<h1>selectAll.jsp</h1>
<br/>
<a href="index.do">HOME</a>
<table id="customers">
    <tr>
        <th>num</th>
        <th>name</th>
        <th>age</th>
        <th>imgName</th>
    </tr>

    <c:forEach var="vo" items="${vos}">
        <tr>
            <td><a href="selectOne.do?num=${vo.num}">${vo.num}</a></td>
            <td>${vo.name}</td>
            <td>${vo.age}</td>
            <td><img src="upload/${vo.imgName}" width="50" alt="default.png"></td>
        </tr>
    </c:forEach>
    <tr>
        <td colspan="4">
            <a href="selectAll.do?cpage=1&limit=10">1</a>
            <a href="selectAll.do?cpage=2&limit=10">2</a>
            <a href="selectAll.do?cpage=3&limit=10">3</a>
            <a href="selectAll.do?cpage=4&limit=10">4</a>
        </td>
    </tr>
</table>

</body>
</html>