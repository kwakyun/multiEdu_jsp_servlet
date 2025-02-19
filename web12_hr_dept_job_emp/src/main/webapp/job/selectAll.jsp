<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>직책 목록 페이지</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
            padding: 20px;
            background-color: #f8f9fa;
        }

        h1 {
            text-align: center;
            color: #333;
        }

        form {
            display: flex;
            justify-content: center;
            align-items: center;
            margin-bottom: 20px;
        }

        select, input[type="text"], input[type="submit"] {
            padding: 8px;
            margin: 0 5px;
            border-radius: 5px;
            border: 1px solid #ccc;
        }

        input[type="submit"] {
            background-color: #04AA6D;
            color: white;
            cursor: pointer;
            border: none;
        }

        input[type="submit"]:hover {
            background-color: #038c5a;
        }

        #departments {
            width: 80%;
            margin: 0 auto;
            border-collapse: collapse;
            background: white;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            border-radius: 5px;
            overflow: hidden;
        }

        #departments th, #departments td {
            padding: 12px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }

        #departments th {
            background-color: #04AA6D;
            color: white;
        }

        #departments tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        #departments tr:hover {
            background-color: #ddd;
        }

        #departments a {
            text-decoration: none;
            color: #04AA6D;
            font-weight: bold;
        }

        #departments a:hover {
            text-decoration: underline;
        }

        .pagination {
            text-align: center;
            margin-top: 20px;
        }

        .pagination a {
            display: inline-block;
            padding: 8px 12px;
            margin: 0 5px;
            text-decoration: none;
            color: white;
            background-color: #04AA6D;
            border-radius: 5px;
            font-weight: bold;
        }

        .pagination a:hover {
            background-color: #038c5a;
        }
    </style>
</head>
<body>
    <h1>부서 목록 페이지</h1>
    <jsp:include page="../top_menu.jsp"/>

    <form action="j_searchList.do" method="get">
        <select name="searchKey">
            <option value="job_id">직책아이디</option>
            <option value="job_title">직책명</option>
        </select>
        <input type="text" name="searchWord" value="1" placeholder="검색어 입력"/>
        <input type="submit" value="검색"/>
    </form>

    <table id="jobs">
        <tr>
            <th>직책아이디</th>
            <th>직책명</th>
            <th>최소연봉</th>
            <th>최대연봉</th>
        </tr>

        <c:choose>
            <c:when test="${spage == null}">
                <c:forEach var="vo" items="${vos}">
                    <tr>
                        <td><a href="j_selectOne.do?job_id=${vo.job_id}">${vo.job_id}</a></td>
                        <td>${vo.job_title}</td>
                        <td>${vo.min_salary}</td>
                        <td>${vo.max_salary}</td>
                    </tr>
                </c:forEach>
            </c:when>
            <c:otherwise>
                <c:forEach var="vo" items="${spageVos}">
                    <tr>
                        <td><a href="j_selectOne.do?job_id=${vo.job_id}">${vo.job_id}</a></td>
                        <td>${vo.job_title}</td>
                        <td>${vo.min_salary}</td>
                        <td>${vo.max_salary}</td>
                    </tr>
                </c:forEach>
            </c:otherwise>
        </c:choose>
    </table>

    <div class="pagination">
        <c:forEach var="i" begin="1" end="${cpage}">
            <a href="j_selectAll.do?spage=${i}&limit=10">${i}</a>
        </c:forEach>
    </div>
</body>
</html>
