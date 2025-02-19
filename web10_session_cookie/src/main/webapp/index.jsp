<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1>index.jsp</h1>
<br/>
<a href="index.do">index.do</a>
<a href="test_session.do">test_session.do</a>
<a href="test_cookie.do">test_cookie.do</a>
<a href="login.do">login.do</a>
<a href="logout.do">logout.do</a>
<hr>
<hr>
<h1>세션정보</h1>
name:${name}
<hr>
id:${id}
<h1>쿠키정보</h1>
message:${cookie['message'].value}
<hr>
isChecked:${cookie['isChecked'].value}
<hr>
로그인 링크를 만드세요. >> login.do 로 이동
로그아웃 링크를 만드세요. >> logout.do 로그아웃 처리하세요.>> index.do

</body>
</html>