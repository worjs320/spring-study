<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2021-07-05 (005)
  Time: 오후 11:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Form</title>
</head>
<body>
    <form method="post" action="/register.jgkim">
        <input type="text" name="id"/>
        <input type="text" name="name"/>
        <input type="text" name="email"/>
        <input type="password" name="password"/>
        <input type="submit"/>
    </form>
</body>
</html>
