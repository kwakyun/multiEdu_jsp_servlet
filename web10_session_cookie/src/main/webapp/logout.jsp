<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <title>로그아웃</title>
  <style>
    body {
      background-color: #f4f4f4;
      font-family: Arial, sans-serif;
      display: flex;
      justify-content: center;
      align-items: center;
      height: 100vh;
      margin: 0;
    }
    .logout-container {
      background: #fff;
      padding: 30px 40px;
      border-radius: 8px;
      box-shadow: 0 0 10px rgba(0,0,0,0.1);
      text-align: center;
    }
    .logout-container h2 {
      margin-bottom: 20px;
    }
    .logout-container p {
      margin-bottom: 30px;
      font-size: 16px;
    }
    .logout-btn {
      background: #ff4d4d;
      border: none;
      color: #fff;
      padding: 10px 20px;
      font-size: 16px;
      border-radius: 4px;
      cursor: pointer;
      transition: background 0.3s;
    }
    .logout-btn:hover {
      background: #e60000;
    }
  </style>
</head>
<body>
  <div class="logout-container">
    <h2>로그아웃</h2>
    <p>정말 로그아웃 하시겠습니까?</p>
    <!-- action을 LogoutServlet URL로 변경 -->
    <form action="/logoutOK.do" method="post">
      <button type="submit" class="logout-btn">로그아웃</button>
    </form>
  </div>
</body>
</html>
