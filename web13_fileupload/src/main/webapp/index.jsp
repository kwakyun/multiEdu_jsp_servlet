<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1>file upload</h1>
<br/>
<form action="fileUpload.do" method="post" enctype="multipart/form-data">
    <input type="text" name="name"  value="kim길동" />
    <input type="text" name="age"  value="33" />
    <input type="file" name="upFile" />
    <input type="submit" />
</form>
<img src="upload/${param.imgName}" alt="default.png">
</body>
</html>