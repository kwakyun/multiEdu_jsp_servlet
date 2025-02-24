<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>insert.jsp</title>
    <style>
        table {
            width: 500px;
        }

        input[type=text],
        input[type=password],
        input[type=tel] {
            width: 100%;
            padding: 8px 8px;
            margin: 8px 0px;
            display: inline-block;
            border: 1px solid #0f9805;
            border-radius: 10px;
        }

        input[type=submit] {
            width: 30%;
            padding: 8px 8px;
            margin: 8px 0px;
            border-radius: 10px;
            background-color: rgb(12, 135, 133);
            color: azure;
        }

        input[type=submit]:hover {
            background-color: rgb(39, 78, 0);
        }
    </style>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script>
        $(function () {
            console.log("ready.....");
            $("#btn_idCheck").click(function () {
                console.log("btn_idCheck clicked");

                let url = "http://localhost:8080/web16_MVC_REST_war_exploded/json_idCheck.do";
                let data = {id: $("#id").val()};
                $.ajax({
                    url: url,
                    data: data,
                    type: "post",
                    dataType: "json",
                    success: function (response) {
                        console.log("response", response);//{"result":"OK"}

                        //OK or Not OK >> 사용가능 또는 중복된 아이디
                        if (response.result === 'OK') {
                            $("#result").html("사용가능");
                        } else {
                            $("#result").html("중복된 아이디");
                        }
                    },
                    error: function (ex) {
                        console.log("ex", ex);
                    }

                });


                return false;
            });
        });
    </script>
</head>
<body>
<h1>회원 가입 페이지</h1>
<jsp:include page="../top_menu.jsp"/>

<form action="m_insertOK.do" method="post" enctype="multipart/form-data">
    <table>
        <tr>
            <td><label for="id">아이디:</label></td>
            <td>
                <input type="text" id="id" name="id" value="admin">
                <a href="#" id="btn_idCheck">아이디 중복체크</a>
                <span id="result">사용가능</span>
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
            <td><label for="upFile">프로필사진:</label></td>
            <td>
                <input type="file" id="upFile" name="upFile">
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