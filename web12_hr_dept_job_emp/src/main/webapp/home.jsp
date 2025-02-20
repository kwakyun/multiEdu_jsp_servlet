<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>홈 페이지</title>
    <style>
        /* 전체 스타일 설정 */
        body {
            font-family: Arial, sans-serif;
            background-color: #f8f9fa;
            margin: 0;
            padding: 0;
        }
        /* 내비게이션 바 스타일 */
        .navbar {
            background-color: #343a40;
            padding: 10px 20px;
            display: flex;
            justify-content: center;
            align-items: center;
        }
        .navbar a {
            color: #ffffff;
            text-decoration: none;
            margin: 0 15px;
            font-size: 16px;
            transition: color 0.3s ease;
        }
        .navbar a:hover {
            color: #ffc107;
        }
        /* 중앙 컨테이너 스타일 */
        .container {
            max-width: 800px;
            margin: 30px auto;
            padding: 20px;
            background-color: #ffffff;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }
        h1 {
            text-align: center;
            color: #343a40;
        }
        hr {
            margin: 20px 0;
            border: 0;
            height: 1px;
            background-color: #e0e0e0;
        }
    </style>
</head>
<body>
    <!-- 내비게이션 바 -->
    <nav class="navbar">
        <a href="home.do">HOME</a>
        <a href="e_insert.do">사원등록</a>
        <a href="e_selectAll.do">사원목록</a>
        <a href="d_insert.do">부서등록</a>
        <a href="d_selectAll.do">부서목록</a>
        <a href="j_insert.do">업무등록</a>
        <a href="j_selectAll.do">업무목록</a>
    </nav>

    <!-- 메인 컨텐츠 영역 -->
    <div class="container">
        <h1>Home</h1>
        <hr>


    </div>
</body>
</html>
