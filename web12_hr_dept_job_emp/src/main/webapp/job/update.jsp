<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>직책 수정 페이지</title>
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
        <h1>직책 수정 페이지</h1>
        <jsp:include page="../top_menu.jsp"/>
        <form action="j_updateOK.do" method="post">
            <table>
                <tr>
                    <td>직책번호:</td>
                    <td>
                        ${param.job_id}
                        <input type="hidden" id="job_id" name="job_id" value="${param.job_id}">
                    </td>
                </tr>
                <tr>
                    <td><label for="job_title">직책명:</label></td>
                    <td>
                        <input type="text" id="job_title" name="job_title" value="${vo2.job_title}">
                    </td>
                </tr>
                <tr>
                    <td><label for="min_salary">최소급여:</label></td>
                    <td>
                        <input type="text" id="min_salary" name="min_salary" value="${vo2.min_salary}">
                    </td>
                </tr>
                <tr>
                    <td><label for="max_salary">최대급여:</label></td>
                    <td>
                        <input type="text" id="max_salary" name="max_salary" value="${vo2.max_salary}">
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
