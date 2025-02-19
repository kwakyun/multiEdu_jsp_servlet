<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>부서 삭제 페이지</title>
  <style>
    body {
      font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
      background-color: #f4f4f4;
      margin: 0;
      padding: 0;
    }
    .container {
      max-width: 500px;
      margin: 80px auto;
      background: #fff;
      padding: 30px;
      border-radius: 8px;
      box-shadow: 0 2px 10px rgba(0,0,0,0.1);
      text-align: center;
    }
    h1 {
      color: #333;
      margin-bottom: 20px;
    }
    .message {
      font-size: 18px;
      margin-bottom: 30px;
    }
    a.button {
      display: inline-block;
      padding: 10px 20px;
      background-color: #d9534f;
      color: #fff;
      text-decoration: none;
      border-radius: 4px;
      font-size: 16px;
      transition: background-color 0.3s ease;
    }
    a.button:hover {
      background-color: #c9302c;
    }
  </style>
</head>
<body>
  <div class="container">
    <h1>부서 삭제 페이지</h1>
    <jsp:include page="../top_menu.jsp"/>
    <p class="message">${param.department_id}번 부서를 정말 삭제하시겠습니까?</p>
    <a href="d_deleteOK.do?department_id=${param.department_id}" class="button">삭제</a>
  </div>
</body>
</html>
