<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "HOME" %></h1>
<br/>
<jsp:include page="top_menu.jsp"/>
<hr>
<pre>
-- hr데이터베이스의 테이블 3개 복제
create table dept as
select * from departments;

create table job as
select * from jobs;

create table emp as
select * from employees;

-- 각테이블에 pk설정 수정
-- fk설정 추가.

부서미션  : 부서등록,수정,삭제,모든부서검색,부서번호검색,부서명or매니저코드 연관검색
</pre>
</body>
</html>