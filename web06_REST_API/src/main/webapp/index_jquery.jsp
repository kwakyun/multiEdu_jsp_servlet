<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
 <!DOCTYPE html>
 <html>
 <head>
    <title>index.jsp</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script>
        console.log("hello");

        $(function(){
            console.log("ready...");

            console.log("btn click....eee");

            //post방식 비동기통신
            let url = "http://localhost:8080/web06_REST_API/json_array.do";
            let data = {id:"tester"};
            $.ajax({
                url : url,
                data : data,
                type : "post", //post
                dataType : "json", //응답결과 문서타입 : xml,json,text
                success : function(response,status){
                    console.log("response",response);
                    console.log("status",status);//success : 200 정상적으로 완료

                    let tag = "";
                    for (let i = 0; i < response.length; i++) {
                        //javascript 변수표기법을 jsp에서 사용하려면 역슬러시를 앞에 붙여서 표기해야한다.
                        tag += `<tr><td>\${response[i].name}</td><td>\${response[i].age}</td></tr>`;
                    }
                    $("#person").html(tag);

                },
                error : function(ex){
                    console.log("ex",ex);
                }

            });

        });//end ready...

    </script>
 </head>
 <body>
    <h1>index_jquery.jsp</h1>
    <a href="index.do">index.do</a>
    <a href="index_jquery.do">index_jquery.do</a>
    <hr>
    <table>
        <thead>
            <tr>
                <th>name</th>
                <th>age</th>
            </tr>
        </thead>
        <tbody id="person">

        </tbody>
    </table>
 </body>
 </html>