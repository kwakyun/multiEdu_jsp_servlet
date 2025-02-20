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

        #customers tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        #customers tr:hover {
            background-color: #ddd;
        }

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
<h1><%= "사원 목록 페이지" %>
</h1>
<br/>
<jsp:include page="../top_menu.jsp"/>
<form action="e_searchList.do">
    <select name="searchKey">
        <option value="first_name">first_name</option>
        <option value="phone_number">phone_number</option>
        <option value="job_id">job_id</option>
    </select>
    <input type="text" name="searchWord" value="Do">
    <input type="submit" value="검색">
</form>
<table id="customers">
    <thead>
    <tr>
        <th>employee_id</th>
        <th>first_name</th>
        <th>last_name</th>
        <th>email</th>
        <th>phone_number</th>
        <th>hire_date</th>
        <th>job_id</th>
        <th>salary</th>
        <th>commission_pct</th>
        <th>manager_id</th>
        <th>department_id</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="vo" items="${list}">
        <tr>
            <td><a href="e_selectOne.do?employee_id=${vo.employee_id}">${vo.employee_id}</a></td>
            <td><a href="e_selectOne.do?employee_id=${vo.employee_id}">${vo.first_name}</a></td>
            <td>${vo.last_name}</td>
            <td>${vo.email}</td>
            <td>${vo.phone_number}</td>
            <td>${vo.hire_date}</td>
            <td>${vo.job_id}</td>
            <td>${vo.salary}</td>
            <td>${vo.commission_pct}</td>
            <td>${vo.manager_id}</td>
            <td>${vo.department_id}</td>
        </tr>
    </c:forEach>

    </tbody>
    <tfoot>
    <tr>
        <td colspan="11">
            <a href="d_selectAll.do?cpage=1&limit=10">1</a>
            <a href="d_selectAll.do?cpage=2&limit=10">2</a>
            <a href="d_selectAll.do?cpage=3&limit=10">3</a>
            <a href="d_selectAll.do?cpage=4&limit=10">4</a>
        </td>
    </tr>
    </tfoot>
</table>
</body>
</html>