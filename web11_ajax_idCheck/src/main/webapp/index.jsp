<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script>
        $(function(){
            $("#btn_idCheck").click(function(){
                console.log("btn_idCheck clicked");

                let url = "http://localhost:8080/web11_ajax_idCheck_war_exploded/json_idCheck.do";
                let data = {id:$("#id").val()};
                $.ajax({
                    url : url,
                    data : data,
                    type : "post",
                    dataType : "json",
                    success : function(response){
                        console.log("response",response);//{"result":"OK"}

                        //OK or Not OK >> 사용가능 또는 중복된 아이디
                        if(response.result==='OK'){
                            $("#result").html("사용가능");
                        }else{
                            $("#result").html("중복된 아이디");
                        }
                    },
                    error : function(ex){
                        console.log("ex",ex);
                    }

                });


                return false;
            });
        });
    </script>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="hello-servlet">Hello Servlet</a>
<form action="insertOK.do">
    <input type="text" name="id" id="id" value="admin01">
    <a href="#" id="btn_idCheck">아이디 중복체크</a>
    <span id="result">사용가능</span>
    <input type="submit" value="Submit">
</form>
</body>
</html>