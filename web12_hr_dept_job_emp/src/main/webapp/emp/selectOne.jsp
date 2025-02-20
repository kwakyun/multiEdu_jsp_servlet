<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
<h1>사원 정보 페이지</h1>
<br/>
<jsp:include page="../top_menu.jsp"/>
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
    <tr>
        <td>${vo2.employee_id}</td>
        <td>${vo2.first_name}</td>
        <td>${vo2.last_name}</td>
        <td>${vo2.email}</td>
        <td>${vo2.phone_number}</td>
        <td>${vo2.hire_date}</td>
        <td>${vo2.job_id}</td>
        <td>${vo2.salary}</td>
        <td>${vo2.commission_pct}</td>
        <td>${vo2.manager_id}</td>
        <td>${vo2.department_id}</td>
    </tr>
    </tbody>
</table>
<a href="e_update.do?employee_id=${vo2.employee_id}">사원수정</a>
<a href="e_delete.do?employee_id=${vo2.employee_id}">사원삭제</a>
</body>
</html>