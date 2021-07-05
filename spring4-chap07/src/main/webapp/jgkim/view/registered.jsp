<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2021-07-05 (005)
  Time: 오후 11:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registered</title>
</head>
<body>
<table border="1">
    <tr>
        <td>id</td>
        <td>${userTemplate.id} </td>
    </tr>
    <tr>
        <td>name</td>
        <td>${userTemplate.name} </td>
    </tr>
    <tr>
        <td>email</td>
        <td>${userTemplate.email} </td>
    </tr>
    <tr>
        <td>password</td>
        <td>${userTemplate.password} </td>
    </tr>
</table>
</body>
</html>
