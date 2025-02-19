<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>부서 등록 페이지</title>
  <style>
    body {
      font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
      background-color: #f4f4f4;
      margin: 0;
      padding: 0;
    }
    .container {
      max-width: 600px;
      margin: 50px auto;
      background: #fff;
      border-radius: 8px;
      padding: 20px 30px;
      box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
    }
    h1 {
      text-align: center;
      color: #333;
      margin-bottom: 30px;
    }
    table {
      width: 100%;
      border-collapse: collapse;
    }
    table td {
      padding: 12px;
    }
    label {
      display: block;
      font-weight: bold;
      color: #555;
      margin-bottom: 5px;
    }
    input[type="text"] {
      width: 100%;
      padding: 10px;
      margin: 5px 0 10px;
      border: 1px solid #ccc;
      border-radius: 4px;
      box-sizing: border-box;
    }
    input[type="submit"] {
      width: 100%;
      padding: 10px;
      background-color: #0c8785;
      color: #fff;
      border: none;
      border-radius: 4px;
      font-size: 16px;
      cursor: pointer;
      margin-top: 20px;
    }
    input[type="submit"]:hover {
      background-color: #274e00;
    }
  </style>
</head>
<body>
  <div class="container">
    <h1>부서 등록 페이지</h1>
    <jsp:include page="../top_menu.jsp"/>
    <form action="j_insertOK.do" method="post">
      <table>
        <tr>
          <td>
            <label for="job_id">직업아이디:</label>
            <input type="text" id="job_id" name="job_id" value="BE">
          </td>
        </tr>
        <tr>
          <td>
            <label for="job_title">직책명:</label>
            <input type="text" id="job_title" name="job_title" value="Backend_Engineer">
          </td>
        </tr>
        <tr>
          <td>
            <label for="min_salary">최소급여:</label>
            <input type="text" id="min_salary" name="min_salary" value="5000">
          </td>
        </tr>
        <tr>
          <td>
            <label for="max_salary">최대급여:</label>
            <input type="text" id="max_salary" name="max_salary" value="15000">
          </td>
        </tr>
      </table>
      <input type="submit" value="전송">
    </form>
  </div>
</body>
</html>
