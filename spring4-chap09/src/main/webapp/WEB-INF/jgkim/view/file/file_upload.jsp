<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2021-08-13 (013)
  Time: 오전 12:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>File Upload</title>
</head>
<body>
<form action="/jgkim/file/multipart" method="post" enctype="multipart/form-data">
    파일 : <input type="file" name="file"/>
    <input type="submit" value="전송"/>
</form>
</body>
</html>
