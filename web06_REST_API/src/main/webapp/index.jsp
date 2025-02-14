<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
 <!DOCTYPE html>
 <html>
 <head>
    <title>index.jsp</title>
    <script>
        console.log("hello..");
        // Create an XMLHttpRequest object
        const xhttp = new XMLHttpRequest();

        // Define a callback function
        xhttp.onload = function() {
            // Here you can use the Data
            //1.test.do
            console.log(this.responseText);

            //2.json_object.do  ////{"name":"kim","age":33}
            //let obj = JSON.parse(this.responseText);
            //console.log(obj);
            //console.log(obj.name, obj.age);
            //let data = document.querySelector("#data");
            //data.innerHTML = obj.name + "," +obj.age;

            //3.json_array.do  //[{"name":"kim1","age":11},{"name":"kim2","age":22}]
            let arr = JSON.parse(this.responseText);
            console.log(arr);
            let data = document.querySelector("#data");
            let tag = "";
            for (const key in arr) {
                tag += arr[key].name;
                tag += " "+arr[key].age;
            }
            data.innerHTML = tag;


        };

        // Send a request
        //xhttp.open("GET", "http://localhost:8080/web06_REST_API/test.do");
        //xhttp.open("GET", "http://localhost:8080/web06_REST_API/json_object.do");
        xhttp.open("GET", "http://localhost:8080/web06_REST_API/json_array.do");
        xhttp.send();


        window.onload = function(){
            let btn01 = document.querySelector("#btn01");
            let id = document.querySelector("#id");


            btn01.onclick = function(){
                console.log("btn01 click...");
                console.log(id.value);//admin33
                xhttp.onload = function() {
                    console.log(this.responseText);
                };
                xhttp.open("GET", "http://localhost:8080/web06_REST_API/json_idCheck.do?id="+id.value);
                xhttp.send();
            };
        };

    </script>
 </head>
 <body>
    <h1>index.jsp</h1>
    <a href="index.do">index.do</a>
    <a href="index_jquery.do">index_jquery.do</a>
    <hr>
    <h1 id="data"></h1>
    <input type="text" id="id" value="admin33">
    <button id="btn01">click</button>
    <a href="test.do">test.do</a>
    <a href="json_object.do">json_object.do</a>
    <a href="json_array.do">json_array.do</a>
    <a href="json_idCheck.do?id=admin">json_idCheck.do</a>
 </body>
 </html>