<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <!DOCTYPE html>
 <html>
 <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>update.jsp</title>
   <style>
     table{
        width: 500px;
    }
    input[type=text],
    input[type=password],
    input[type=tel]{
        width: 100%;
        padding: 8px 8px;
        margin: 8px 0px;
        display: inline-block;
        border: 1px solid #0f9805;
        border-radius: 10px;
    }
    input[type=submit]{
        width: 30%;
        padding: 8px 8px;
        margin: 8px 0px;
        border-radius: 10px;
        background-color: rgb(12, 135, 133);
        color: azure;
    }
    input[type=submit]:hover{
        background-color: rgb(39, 78, 0);
    }
    </style>
 </head>
 <body>
    <h1>게시글 수정 페이지</h1>
    <jsp:include page="../top_menu.jsp"/>

    <form action="b_updateOK.do" method="post">
        <table>
            <tr>
                <td>회원번호:</td>
                <td>${param.num}
                    <input type="hidden" id="num" name="num" value="${param.num}">
                </td>
            </tr>
            <tr>
                <td><label for="title">title:</label></td>
                <td>
                    <input type="text" id="title" name="title" value="${vo2.title}">
                </td>
            </tr>
            <tr>
                <td><label for="content">content:</label></td>
                <td>
                    <input type="password" id="content" name="content" value="${vo2.content}">
                </td>
            </tr>
            <tr>
                <td><label for="writer">writer:</label></td>
                <td>
                    <input type="text" id="writer" name="writer" value="${vo2.writer}">
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="전송">
                </td>
            </tr>
        </table>
    </form>

 </body>
 </html>