<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
<form:form commandName="userTemplate" method="post" action="/register.jgkim">
    id: <input type="text" name="id"/> <form:errors path="id"/> <br>
    name: <input type="text" name="name"/> <br>
    email: <input type="text" name="email"/> <br>
    password: <input type="password" name="password"/> <form:errors path="password"/> <br>
    <input type="submit"/>
</form:form>

<spring:hasBindErrors name="userTemplate" />
    <form method="post" action="/register.jgkim">
    id: <input type="text" name="id"/> <form:errors path="userTemplate.id"/> <br>
    name: <input type="text" name="name"/> <br>
    email: <input type="text" name="email"/> <br>
    password: <input type="password" name="password"/> <form:errors path="userTemplate.password"/> <br>
    <input type="submit"/>
</form>
</body>
</html>
