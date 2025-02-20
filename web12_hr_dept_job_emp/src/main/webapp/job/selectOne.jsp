<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <!DOCTYPE html>
 <html>
 <head>
    <title>selectOne.jsp</title>
    <style>
        #customers {
          font-family: Arial, Helvetica, sans-serif;
          border-collapse: collapse;
          width: 100%;
        }

        #customers td, #customers th {
          border: 1px solid #ddd;
          padding: 8px;
        }

        #customers tr:nth-child(even){background-color: #f2f2f2;}

        #customers tr:hover {background-color: #ddd;}

        #customers th {
          padding-top: 12px;
          padding-bottom: 12px;
          text-align: left;
          background-color: #04AA6D;
          color: white;
        }
        </style>
 </head>
 <body>
    <h1>업무 상세 페이지</h1>
    <jsp:include page="../top_menu.jsp"/>

    <table id="customers">
        <tr>
            <th>job_id</th>
            <th>job_title</th>
            <th>min_salary</th>
            <th>max_salary</th>
        </tr>
        <tr>
            <td>${param.job_id}</td>
            <td>${vo2.job_title}</td>
            <td>${vo2.min_salary}</td>
            <td>${vo2.max_salary}</td>
        </tr>
        <tr>
            <td colspan="5">
                <a href="j_update.do?job_id=${param.job_id}">업무수정</a>
                <a href="j_delete.do?job_id=${param.job_id}">업무삭제</a>
            </td>
        </tr>
    </table>
 </body>
 </html>