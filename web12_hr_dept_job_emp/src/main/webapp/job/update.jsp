<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
  <style>
    input[type=text],
    textarea,
    select {
      width: 100%;
      padding: 8px 8px;
      margin: 8px 0;
      display: inline-block;
      border: 1px solid #ff8f8f;
      border-radius: 14px;
      box-sizing: border-box;
    }

    input[type=submit] {
      width: 30%;
      background-color: #4CAF50;
      color: white;
      padding: 8px 8px;
      margin: 8px 0;
      border: none;
      border-radius: 14px;
      cursor: pointer;
    }

    input[type=submit]:hover {
      background-color: #b7e5b9;
    }

    div {
      border-radius: 15px;
      background-color: #f0f0f0;
      padding: 20px;
    }

    #insertTable {
      font-family: Arial, Helvetica, sans-serif;
      border-collapse: collapse;
      width: 100%;
    }

    #insertTable td {
      border: 1px solid #ddd;
      padding: 8px;
    }

    #insertTable tr:nth-child(even) {
      background-color: #ebebeb;
    }

    #insertTable tr:hover {
      background-color: #ffc6c6;
    }
  </style>
</head>

<body>
<jsp:include page="../top_menu.jsp"/>
<div>
  <h1>업무수정 페이지</h1>
  <form action="j_updateOK.do" method="post">
    <table id="insertTable">
      <tr>
        <td><label for="job_id">job_id</label></td>
        <td>${vo2.job_id}
          <input type="hidden" id="job_id" name="job_id" value="${vo2.job_id}">
        </td>
      </tr>
      <tr>
        <td><label for="job_title">job_title</label></td>
        <td><input type="text" id="job_title" name="job_title" value="${vo2.job_title}"
                   placeholder="업무명을 입력하세요"></td>
      </tr>
      <tr>
        <td><label for="min_salary">min_salary</label></td>
        <td><input type="number" id="min_salary" name="min_salary" value="${vo2.min_salary}"
                   placeholder="최소급여를 입력하세요"></td>
      </tr>
      <tr>
      <tr>
        <td><label for="max_salary">max_salary</label></td>
        <td><input type="number" id="max_salary" name="max_salary" value="${vo2.max_salary}"
                   placeholder="최대급여를 입력하세요"></td>
      </tr>
      <tr>
        <td colspan="2"><input type="submit" value="수정완료"></td>
      </tr>
    </table>
  </form>
</div>
</body>

</html>