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
        $(function(){
            console.log("jQuery loaded");

            let url = "http://localhost:8080/web16_MVC_REST_war_exploded/json_m_selectOne.do";
            let num = '${param.num}';//JSP EL
            console.log("param.num : " + num)
            let data = {num:num};
            $.ajax({
                url : url,
                data : data,
                type : "get", //post,get
                dataType : "json", //응답결과 문서타입 : xml,json,text
                success : function(response,status){
                    console.log("response",response);

                    let tag = `
                                <tr>
                                    <td>\${response.num}</td>
                                    <td>\${response.id}</td>
                                    <td>\${response.pw}</td>
                                    <td>\${response.name}</td>
                                    <td>\${response.tel}</td>
                                    <td><img src="upload/\${response.imgName}" width="300" alt="default.png"></td>
                                </tr>
                        `;

                    $("#member").html(tag);

                },
                error : function(ex){
                    console.log("ex",ex);
                }
            });
        });
    </script>
</head>
<body>
<h1>회원 상세 페이지</h1>
<jsp:include page="../top_menu.jsp"/>

<table id="customers">
    <tr>
        <th>num</th>
        <th>id</th>
        <th>pw</th>
        <th>name</th>
        <th>tel</th>
        <th>imgName</th>
    </tr>
    <tbody id="member">
    </tbody>
    <tr>
        <td colspan="6">
            <a href="m_update.do?num=${param.num}">회원수정</a>
            <a href="m_delete.do?num=${param.num}">회원삭제</a>
        </td>
    </tr>
</table>
</body>
</html>