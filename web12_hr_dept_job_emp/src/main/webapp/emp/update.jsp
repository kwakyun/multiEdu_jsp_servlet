<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>직원 수정 페이지</title>
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
        <h1>직원 수정 페이지</h1>
        <jsp:include page="../top_menu.jsp"/>
        <form action="e_updateOK.do" method="post">
            <table>
                <tr>
                    <td>직원번호:</td>
                    <td>
                        ${param.employee_id}
                        <input type="hidden" id="employee_id" name="employee_id" value="${param.employee_id}">
                    </td>
                </tr>
                <tr>
                    <td><label for="first_name">성:</label></td>
                    <td>
                        <input type="text" id="first_name" name="first_name" value="${vo2.first_name}">
                    </td>
                </tr>
                <tr>
                    <td><label for="last_name">이름:</label></td>
                    <td>
                        <input type="text" id="last_name" name="last_name" value="${vo2.last_name}">
                    </td>
                </tr>
                <tr>
                    <td><label for="email">이메일:</label></td>
                    <td>
                        <input type="text" id="email" name="email" value="${vo2.email}">
                    </td>
                </tr>
                <tr>
                    <td><label for="phone_number">전화번호:</label></td>
                    <td>
                        <input type="text" id="phone_number" name="phone_number" value="${vo2.phone_number}">
                    </td>
                </tr>
                <tr>
                    <td><label for="hire_date">입사일자:</label></td>
                    <td>
                        <input type="text" id="hire_date" name="hire_date" value="${vo2.hire_date}">
                    </td>
                </tr>
                <tr>
                    <td><label for="job_id">직업아이디:</label></td>
                    <td>
                        <input type="text" id="job_id" name="job_id" value="${vo2.job_id}">
                    </td>
                </tr>
                <tr>
                    <td><label for="salary">연봉:</label></td>
                    <td>
                        <input type="text" id="salary" name="salary" value="${vo2.salary}">
                    </td>
                </tr>
                <tr>
                    <td><label for="commision_pct">커미선포인트:</label></td>
                    <td>
                        <input type="text" id="commission_pct" name="commission_pct" value="${vo2.commission_pct}">
                    </td>
                </tr>
                <tr>
                    <td><label for="manager_id">메니저아이디:</label></td>
                    <td>
                        <input type="number" id="manager_id" name="manager_id" value="${vo2.manager_id}">
                    </td>
                </tr>
                <tr>
                    <td><label for="department_id">부서아이디:</label></td>
                    <td>
                        <input type="number" id="department_id" name="department_id" value="${vo2.department_id}">
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
