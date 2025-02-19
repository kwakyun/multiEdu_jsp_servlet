<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1>test_cookie.jsp</h1>
<br/>
<a href="index.do">index.do</a>
<a href="test_session.do">test_session.do</a>
<a href="test_cookie.do">test_cookie.do</a>
<hr>
<h1>쿠키정보</h1>
message:${cookie['message'].value}
<hr>
isChecked:${cookie['isChecked'].value}
</body>
</html>