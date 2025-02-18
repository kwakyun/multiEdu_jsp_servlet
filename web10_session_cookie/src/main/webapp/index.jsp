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
<a href="test.do">test.do</a>
<a href="login.do">login 링크</a>
<a href="logout.do">logout 링크</a>
<hr>
name:${name}
<hr>
로그인상태:${logstatus}

<hr>
로그인 폼을 만드세요.
로그인 처리하고 세션에 이름과 아이디 저장
로그아웃 링크를 만드세요
로그아웃 처리하세요.
</body>
</html>