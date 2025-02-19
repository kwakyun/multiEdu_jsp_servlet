<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1>login.jsp</h1>
<br/>
<a href="index.do">index.do</a>
<hr>
로그인 폼을 만드세요.
loginOK.do >> 로그인 처리하고 세션에 이름과 아이디 저장 >> index.do 이동
로그인 실패시 다시 로그인 페이지로 이동

<form action="loginOK.do" method="post">
    <input type="text" name="id" value="admin01">
    <input type="password" name="pw" value="hi1111">
    <input type="submit">
</form>

</body>
</html>