<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>selectOne.jsp</title>
    <style>
        #customers {
            font-family: Arial, Helvetica, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }

        #customers td, #customers th {
            border: 1px solid #ddd;
            padding: 8px;
        }

        #customers tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        #customers tr:hover {
            background-color: #ddd;
        }

        #customers th {
            padding-top: 12px;
            padding-bottom: 12px;
            text-align: left;
            background-color: #04AA6D;
            color: white;
        }
    </style>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script>
        $(function () {
            console.log("jQuery loaded");

            let url = "http://localhost:8080/web16_MVC_REST_war_exploded/json_b_selectOne.do";
            let num = '${param.num}';//JSP EL
            console.log("param.num : " + num)
            let data = {num: num};
            $.ajax({
                url: url,
                data: data,
                type: "get", //post,get
                dataType: "json", //응답결과 문서타입 : xml,json,text
                success: function (response, status) {
                    console.log("response", response);

                    let tag = `
                                <tr>
                                    <td>\${response.num}</td>
                                    <td>\${response.title}</td>
                                    <td>\${response.content}</td>
                                    <td>\${response.writer}</td>
                                    <td>\${response.wdate}</td>
                                </tr>
                        `;

                    $("#board").html(tag);

                },
                error: function (ex) {
                    console.log("ex", ex);
                }
            });
        });
    </script>
</head>
<body>
<h1>게시글 상세 페이지</h1>
<jsp:include page="../top_menu.jsp"/>

<table id="customers">
    <thead>
    <tr>
        <th>num</th>
        <th>title</th>
        <th>content</th>
        <th>writer</th>
        <th>wdate</th>
    </tr>
    </thead>
    <tbody id="board"></tbody>
    <tfoot>
    <tr>
        <td colspan="5">
            <a href="b_update.do?num=${param.num}">글수정</a>
            <a href="b_delete.do?num=${param.num}">글삭제</a>
        </td>
    </tr>
    </tfoot>
</table>
</body>
</html>