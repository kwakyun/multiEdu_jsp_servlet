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
    <h1>부서 상세 페이지</h1>
    <jsp:include page="../top_menu.jsp"/>

    <table id="customers">
        <tr>
            <th>department_id</th>
            <th>department_name</th>
            <th>manager_id</th>
            <th>location_id</th>
        </tr>
        <tr>
            <td>${param.department_id}</td>
            <td>${vo2.department_name}</td>
            <td>${vo2.manager_id}</td>
            <td>${vo2.location_id}</td>
        </tr>
        <tr>
            <td colspan="5">
                <a href="d_update.do?department_id=${param.department_id}">부서수정</a>
                <a href="d_delete.do?department_id=${param.department_id}">부서삭제</a>
            </td>
        </tr>
    </table>
 </body>
 </html>