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
    <h1>게시글 상세 페이지</h1>
    <jsp:include page="../top_menu.jsp"/>

    <table id="customers">
        <tr>
            <th>num</th>
            <th>title</th>
            <th>content</th>
            <th>writer</th>
            <th>wdate</th>
        </tr>
        <tr>
            <td>${param.num}</td>
            <td>${vo2.title}</td>
            <td>${vo2.content}</td>
            <td>${vo2.writer}</td>
            <td>${vo2.wdate}</td>
        </tr>
        <tr>
            <td colspan="5">
                <a href="b_update.do?num=${param.num}">글수정</a>
                <a href="b_delete.do?num=${param.num}">글삭제</a>
            </td>
        </tr>
    </table>
 </body>
 </html>