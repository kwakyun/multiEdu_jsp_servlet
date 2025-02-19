<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>부서 상세 페이지</title>
  <style>
    body {
      font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
      background-color: #f4f4f4;
      margin: 0;
      padding: 0;
    }
    .container {
      max-width: 800px;
      margin: 50px auto;
      background: #fff;
      padding: 20px 30px;
      border-radius: 8px;
      box-shadow: 0 2px 10px rgba(0,0,0,0.1);
    }
    h1 {
      text-align: center;
      color: #333;
    }
    table {
      width: 100%;
      border-collapse: collapse;
      margin-top: 20px;
    }
    th, td {
      border: 1px solid #ddd;
      padding: 12px;
      text-align: left;
    }
    th {
      background-color: #04AA6D;
      color: white;
    }
    tr:nth-child(even) {
      background-color: #f2f2f2;
    }
    tr:hover {
      background-color: #ddd;
    }
    .action-links {
      margin-top: 20px;
      text-align: center;
    }
    .action-links a {
      display: inline-block;
      padding: 10px 20px;
      margin: 0 10px;
      background-color: #0c8785;
      color: #fff;
      text-decoration: none;
      border-radius: 4px;
      transition: background-color 0.3s ease;
    }
    .action-links a:hover {
      background-color: #274e00;
    }
  </style>
</head>
<body>
  <div class="container">
    <h1>부서 상세 페이지</h1>
    <jsp:include page="../top_menu.jsp"/>
    <table>
      <tr>
        <th>department_id</th>
        <th>department_name</th>
        <th>manager_id</th>
        <th>location_id</th>
      </tr>
      <tr>
        <td>${param.department_id}</td>
        <td>${vo2.department_name}</td>
        <td>${vo2.manager_id}</td>
        <td>${vo2.location_id}</td>
      </tr>
    </table>
    <div class="action-links">
      <a href="d_update.do?department_id=${param.department_id}">부서수정</a>
      <a href="d_delete.do?department_id=${param.department_id}">부서삭제</a>
    </div>
  </div>
</body>
</html>
