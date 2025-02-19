<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>부서 수정 페이지</title>
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
        }
        form table {
            width: 100%;
            margin: 20px 0;
        }
        form table td {
            padding: 10px;
        }
        label {
            font-weight: bold;
            color: #555;
        }
        input[type="text"],
        input[type="password"],
        input[type="tel"] {
            width: 100%;
            padding: 10px;
            margin: 8px 0;
            display: inline-block;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        input[type="submit"] {
            width: 100%;
            background-color: #0c8785;
            color: #fff;
            padding: 10px;
            border: none;
            border-radius: 4px;
            font-size: 16px;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #274e00;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>부서 수정 페이지</h1>
        <jsp:include page="../top_menu.jsp"/>
        <form action="d_updateOK.do" method="post">
            <table>
                <tr>
                    <td>부서번호:</td>
                    <td>
                        ${param.department_id}
                        <input type="hidden" id="department_id" name="department_id" value="${param.department_id}">
                    </td>
                </tr>
                <tr>
                    <td><label for="department_name">부서명:</label></td>
                    <td>
                        <input type="text" id="department_name" name="department_name" value="${vo2.department_name}">
                    </td>
                </tr>
                <tr>
                    <td><label for="manager_id">관리자 아이디:</label></td>
                    <td>
                        <input type="text" id="manager_id" name="manager_id" value="${vo2.manager_id}">
                    </td>
                </tr>
                <tr>
                    <td><label for="location_id">장소 아이디:</label></td>
                    <td>
                        <input type="text" id="location_id" name="location_id" value="${vo2.location_id}">
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" value="전송">
                    </td>
                </tr>
            </table>
        </form>
    </div>
</body>
</html>
