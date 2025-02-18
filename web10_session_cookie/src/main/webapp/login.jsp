<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <!DOCTYPE html>
    <html lang="ko">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>로그인 폼</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                background-color: #f4f4f4;
                display: flex;
                justify-content: center;
                align-items: center;
                height: 100vh;
                margin: 0;
            }

            .login-container {
                background: white;
                padding: 20px;
                border-radius: 8px;
                box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
                width: 300px;
                text-align: center;
            }

            .login-container h2 {
                margin-bottom: 20px;
            }

            .input-group {
                margin-bottom: 15px;
                text-align: left;
            }

            .input-group label {
                display: block;
                font-size: 14px;
                margin-bottom: 5px;
            }

            .input-group input {
                width: 100%;
                padding: 8px;
                box-sizing: border-box;
            }

            .login-btn {
                width: 100%;
                background: #007BFF;
                color: white;
                border: none;
                padding: 10px;
                cursor: pointer;
                border-radius: 5px;
            }

            .login-btn:hover {
                background: #0056b3;
            }

            .error-message {
                color: red;
                font-size: 12px;
                display: none;
                margin-top: 10px;
            }
        </style>
    </head>

    <body>

        <div class="login-container">
            <h2>로그인</h2>
            <!-- 로그인 폼: action 속성에 서블릿 URL을 지정 -->
            <form action="/loginOK.do" method="post">
                <div class="input-group">
                    <label for="username">아이디</label>
                    <input type="text" id="${username}" name="username" placeholder="아이디 입력" required>
                </div>
                <div class="input-group">
                    <label for="password">비밀번호</label>
                    <input type="password" id="${password}" name="password" placeholder="비밀번호 입력" required>
                </div>
                <button type="submit" class="login-btn">로그인</button>
            </form>
            <!-- 서블릿에서 오류 메시지를 전달하는 경우 출력 -->
            <p class="error-message" id="errorMessage">
                <% if(request.getAttribute("loginError") !=null) { %>
                    아이디 또는 비밀번호가 올바르지 않습니다.
                    <% } %>
            </p>
        </div>



    </body>

    </html>