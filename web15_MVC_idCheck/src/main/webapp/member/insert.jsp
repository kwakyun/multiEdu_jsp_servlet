<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원 가입 페이지</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f8f9fa;
            margin: 0;
            padding: 0;
        }

        .container {
            max-width: 600px;
            margin: 50px auto;
            background: #ffffff;
            box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.1);
            border-radius: 10px;
            padding: 20px;
        }

        h1 {
            text-align: center;
            color: #343a40;
        }

        form {
            margin-top: 20px;
        }

        .form-group {
            display: flex;
            flex-direction: column;
            margin-bottom: 15px;
        }

        label {
            margin-bottom: 5px;
            font-weight: bold;
            color: #495057;
        }

        input[type="text"],
        input[type="password"],
        input[type="file"],
        input[type="tel"] {
            padding: 10px;
            border: 1px solid #dee2e6;
            border-radius: 5px;
            font-size: 14px;
            width: 100%;
        }

        input[type="submit"] {
            background-color: #0d6efd;
            color: white;
            border: none;
            padding: 12px 20px;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
        }

        input[type="submit"]:hover {
            background-color: #0a58ca;
        }

        a {
            color: #0d6efd;
            text-decoration: none;
            font-size: 14px;
            cursor: pointer;
        }

        a:hover {
            text-decoration: underline;
        }

        .btn-id-check {
            display: flex;
            align-items: center;
            gap: 10px;
        }

        #result {
            color: gray;
            font-size: 14px;
        }
    </style>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script>
        $(function () {
            console.log("ready...");
            $("#btn_idCheck").click(function () {
                console.log("아이디 중복 체크 버튼 클릭됨");
                let url = "http://localhost:8080/web15_MVC_idCheck_war_exploded/json_idCheck.do";
                let data = { id: $("#id").val() };

                $.ajax({
                    url: url,
                    data: data,
                    type: "post",
                    dataType: "json",
                    success: function (response) {
                        console.log("response", response); // 서버 응답 출력
                        if (response.result === 'OK') {
                            $("#result").html("사용 가능").css("color", "green");
                        } else {
                            $("#result").html("중복된 아이디").css("color", "red");
                        }
                    },
                    error: function (ex) {
                        console.log("오류 발생", ex);
                    }
                });

                return false;
            });
        });
    </script>
</head>

<body>
    <div class="container">
        <h1>회원가입</h1>
        <form action="m_insertOK.do" method="post" enctype="multipart/form-data">
            <!-- 아이디 -->
            <div class="form-group">
                <label for="id">아이디</label>
                <div class="btn-id-check">
                    <input type="text" id="id" name="id" value="admin">
                    <a href="#" id="btn_idCheck">중복 체크</a>
                </div>
                <span id="result">사용 가능</span>
            </div>
            <!-- 비밀번호 -->
            <div class="form-group">
                <label for="pw">비밀번호</label>
                <input type="password" id="pw" name="pw" value="hi1111">
            </div>
            <!-- 이름 -->
            <div class="form-group">
                <label for="name">이름</label>
                <input type="text" id="name" name="name" value="kim">
            </div>
            <!-- 폰번호 -->
            <div class="form-group">
                <label for="tel">폰번호</label>
                <input type="text" id="tel" name="tel" value="010-1111-1111">
            </div>
            <!-- 프로필 사진 -->
            <div class="form-group">
                <label for="upFile">프로필 사진</label>
                <input type="file" id="upFile" name="upFile">
            </div>
            <!-- 전송 버튼 -->
            <div>
                <input type="submit" value="회원가입">
            </div>
        </form>
    </div>
</body>

</html>