<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>직원 목록 페이지</title>
    <!-- Google Fonts: Noto Sans KR -->
    <link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR:400,700&display=swap" rel="stylesheet">
    <style>
        body {
            font-family: 'Noto Sans KR', Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f1f3f5;
        }
        .container {
            max-width: 1200px;
            margin: 30px auto;
            padding: 20px;
            background: #fff;
            box-shadow: 0 4px 6px rgba(0,0,0,0.1);
            border-radius: 8px;
        }
        h1 {
            text-align: center;
            color: #333;
            margin-bottom: 20px;
        }
        form {
            display: flex;
            justify-content: center;
            align-items: center;
            margin-bottom: 30px;
            flex-wrap: wrap;
        }
        select, input[type="text"], input[type="submit"] {
            padding: 10px 12px;
            margin: 5px;
            border-radius: 5px;
            border: 1px solid #ccc;
            font-size: 16px;
        }
        input[type="submit"] {
            background-color: #007bff;
            color: white;
            cursor: pointer;
            border: none;
            transition: background-color 0.3s ease;
        }
        input[type="submit"]:hover {
            background-color: #0056b3;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
        }
        table thead {
            background: linear-gradient(135deg, #007bff, #00aaff);
            color: white;
        }
        table th, table td {
            padding: 15px;
            border: 1px solid #ddd;
            text-align: left;
        }
        table tbody tr:nth-child(even) {
            background-color: #f8f9fa;
        }
        table tbody tr:hover {
            background-color: #e9ecef;
        }
        table a {
            text-decoration: none;
            color: #007bff;
            font-weight: bold;
        }
        table a:hover {
            text-decoration: underline;
        }
        .pagination {
            text-align: center;
        }
        .pagination a {
            display: inline-block;
            padding: 10px 15px;
            margin: 0 5px;
            text-decoration: none;
            color: white;
            background-color: #007bff;
            border-radius: 4px;
            transition: background-color 0.3s ease;
        }
        .pagination a:hover {
            background-color: #0056b3;
        }
        @media(max-width: 768px) {
            table th, table td {
                padding: 10px;
            }
            select, input[type="text"], input[type="submit"] {
                font-size: 14px;
            }
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>직원 목록 페이지</h1>
        <jsp:include page="../top_menu.jsp"/>
        <form action="e_searchList.do" method="get">
            <select name="searchKey">
                <option value="employee_id">직원 ID</option>
                <option value="job_id">직업 ID</option>
            </select>
            <input type="text" name="searchWord" value="1" placeholder="검색어 입력"/>
            <input type="submit" value="검색"/>
        </form>
        <table id="employees">
            <thead>
                <tr>
                    <th>직원 ID</th>
                    <th>성</th>
                    <th>이름</th>
                    <th>이메일</th>
                    <th>전화번호</th>
                    <th>입사일자</th>
                    <th>직업 ID</th>
                    <th>연봉</th>
                    <th>커미선퍼센트</th>
                    <th>메니저 ID</th>
                    <th>부서 ID</th>
                </tr>
            </thead>
            <tbody>
                <c:choose>
                    <c:when test="${spage == null}">
                        <c:forEach var="vo" items="${vos}">
                            <tr>
                                <td><a href="e_selectOne.do?employee_id=${vo.employee_id}">${vo.employee_id}</a></td>
                                <td>${vo.first_name}</td>
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
                    </c:when>
                    <c:otherwise>
                        <c:forEach var="vo" items="${spageVos}">
                            <tr>
                                <td><a href="e_selectOne.do?employee_id=${vo.employee_id}">${vo.employee_id}</a></td>
                                <td>${vo.first_name}</td>
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
                    </c:otherwise>
                </c:choose>
            </tbody>
        </table>
        <div class="pagination">
            <c:forEach var="i" begin="1" end="${cpage}">
                <a href="e_selectAll.do?spage=${i}&limit=10">${i}</a>
            </c:forEach>
        </div>
    </div>
</body>
</html>
