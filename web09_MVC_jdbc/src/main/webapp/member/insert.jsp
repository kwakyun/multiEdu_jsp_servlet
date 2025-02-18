<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <!DOCTYPE html>
 <html>
 <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>insert.jsp</title>
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
    <h1>회원 가입 페이지</h1>
    <jsp:include page="../top_menu.jsp"/>

    <form action="m_insertOK.do" method="post">
            <table>
                <tr>
                    <td><label for="id">아이디:</label></td>
                    <td>
                        <input type="text" id="id" name="id" value="admin">
                    </td>
                </tr>
                <tr>
                    <td><label for="pw">비번:</label></td>
                    <td>
                        <input type="password" id="pw" name="pw" value="hi1111">
                    </td>
                </tr>
                <tr>
                    <td><label for="name">이름:</label></td>
                    <td>
                        <input type="text" id="name" name="name" value="kim">
                    </td>
                </tr>
                <tr>
                    <td><label for="tel">폰번:</label></td>
                    <td>
                        <input type="text" id="tel" name="tel" value="010-1111-1111">
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