<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>selectAll.jsp</title>
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

            let url = "http://localhost:8080/web16_MVC_REST_war_exploded/json_b_selectAll.do";
            let cpage = '${param.cpage}';//JSP EL
            let limit = '${param.limit}';//JSP EL
            let data = {cpage:cpage,limit:limit};
            $.ajax({
                url : url,
                data : data,
                type : "get", //post,get
                dataType : "json", //응답결과 문서타입 : xml,json,text
                success : function(response,status){
                    console.log("response",response);

                    let tag = "";
                    for (let i = 0; i < response.length; i++) {
                        //javascript 변수표기법을 jsp에서 사용하려면 역슬러시를 앞에 붙여서 표기해야한다.
                        tag += `
                                <tr>
                                    <td><a href="b_selectOne.do?num=\${response[i].num}">\${response[i].num}</a></td>
                                    <td>\${response[i].title}</td>
                                    <td>\${response[i].content}</td>
                                    <td>\${response[i].writer}</td>
                                    <td>\${response[i].wdate}</td>
                                </tr>
                        `;
                    }
                    $("#boards").html(tag);
                },
                error : function(ex){
                    console.log("ex",ex);
                }
            });//end .ajax

            $("#searchForm").submit(function(){
                console.log("submit");
                console.log($("#searchKey").val(),$("#searchWord").val());

                let url = "http://localhost:8080/web16_MVC_REST_war_exploded/json_b_searchList.do";
                let searchKey = $("#searchKey").val();
                let searchWord = $("#searchWord").val();
                let data = {searchKey:searchKey,searchWord:searchWord};
                $.ajax({
                    url : url,
                    data : data,
                    type : "get", //post,get
                    dataType : "json", //응답결과 문서타입 : xml,json,text
                    success : function(response,status){
                        console.log("response",response);

                        let tag = "";
                        for (let i = 0; i < response.length; i++) {
                            tag += `
                               <tr>
                                    <td><a href="b_selectOne.do?num=\${response[i].num}">\${response[i].num}</a></td>
                                    <td>\${response[i].title}</td>
                                    <td>\${response[i].content}</td>
                                    <td>\${response[i].writer}</td>
                                    <td>\${response[i].wdate}</td>
                                </tr>
                        `;
                        }
                        $("#boards").html(tag);

                    },
                    error : function(ex){
                        console.log("ex",ex);
                    }

                });//end .ajax

                return false;//이벤트 방지
            });

        });//end ready

    </script>
</head>
<body>
<h1>게시글 목록 페이지</h1>
<jsp:include page="../top_menu.jsp"/>

<form action="b_searchList.do" method="get"  id="searchForm">
    <select id="searchKey">
        <option value="title">title</option>
        <option value="content">content</option>
    </select>
    <input type="text" id="searchWord" value="ti"/>
    <input type="submit" value="search"/>
</form>
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
    <tbody id="boards"></tbody>
    <tfoot>
    <tr>
        <td colspan="5">
            <a href="b_selectAll.do?cpage=1&limit=10">1</a>
            <a href="b_selectAll.do?cpage=2&limit=10">2</a>
            <a href="b_selectAll.do?cpage=3&limit=10">3</a>
            <a href="b_selectAll.do?cpage=4&limit=10">4</a>
        </td>
    </tr>
    </tfoot>
</table>
</body>
</html>