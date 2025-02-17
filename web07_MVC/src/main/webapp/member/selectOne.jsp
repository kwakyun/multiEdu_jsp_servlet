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
    <h1>회원 상세 페이지</h1>
    <jsp:include page="../top_menu.jsp"/>

    <table id="customers">
        <tr>
            <th>num</th>
            <th>id</th>
            <th>pw</th>
            <th>name</th>
            <th>tel</th>
        </tr>
        <tr>
            <td>${param.num}</td>
            <td>${vo2.id}</td>
            <td>${vo2.pw}</td>
            <td>${vo2.name}</td>
            <td>${vo2.tel}</td>
        </tr>
        <tr>
            <td colspan="5">
                <a href="m_update.do?num=${param.num}">회원수정</a>
                <a href="m_delete.do?num=${param.num}">회원삭제</a>
            </td>
        </tr>
    </table>
 </body>
 </html>