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
<form:form method="post" action="/register.jgkim" modelAttribute="userTemplate">
    id: <input type="text" name="id"/> <form:errors path="id"/> <br>
    name: <input type="text" name="name"/> <form:errors path="name"/> <br>
    email: <input type="text" name="email"/> <form:errors path="email"/> <br>
    password: <input type="password" name="password"/> <form:errors path="password"/> <br>
    age: <input type="text" name="age"/> <form:errors path="age"/> <br>
    jgkim: <input type="text" name="jgkim"/> <form:errors path="jgkim"/> <br>
    date: <input type="text" name="date"/> <form:errors path="date"/> <br>
    <input type="submit"/>
</form:form>
<a href="/deleteSession.jgkim">세션 삭제</a>
세션 값:<%=session.getAttribute("userTemplate")%>

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
