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
<%--<spring:hasBindErrors name="userTemplate" />--%>
<form:form commandName="userTemplate" method="post" action="/register.jgkim">
<%--<form method="post" action="/register.jgkim">--%>
    id: <input type="text" name="id"/> <form:errors path="id"/> <br>
    name: <input type="text" name="name"/> <br>
    email: <input type="text" name="email"/> <br>
    password: <input type="password" name="password"/> <form:errors path="password"/> <br>
    <input type="submit"/>
</form:form>
<%--</form>--%>
</body>
</html>
