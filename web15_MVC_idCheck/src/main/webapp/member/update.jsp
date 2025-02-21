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
    <h1>회원 수정 페이지</h1>
    <jsp:include page="../top_menu.jsp"/>

    <form action="m_updateOK.do" method="post" enctype="multipart/form-data">
        <table>
            <tr>
                <td>회원번호:</td>
                <td>${param.num}
                    <input type="hidden" id="num" name="num" value="${param.num}">
                </td>
            </tr>
            <tr>
                <td><label for="id">아이디:</label></td>
                <td>
                    <input type="text" id="id" name="id" value="${vo2.id}">
                </td>
            </tr>
            <tr>
                <td><label for="pw">비번:</label></td>
                <td>
                    <input type="password" id="pw" name="pw" value="${vo2.pw}">
                </td>
            </tr>
            <tr>
                <td><label for="name">이름:</label></td>
                <td>
                    <input type="text" id="name" name="name" value="${vo2.name}">
                </td>
            </tr>
            <tr>
                <td><label for="tel">폰번:</label></td>
                <td>
                    <input type="text" id="tel" name="tel" value="${vo2.tel}">
                </td>
            </tr>
            <tr>
                <td><label for="upFile">프로필사진 업로드:</label></td>
                <td><img src="upload/${vo2.imgName}" width="30" alt="default.png"></td>
                <td><input type="file" id="upFile" name="upFile"> </td>

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