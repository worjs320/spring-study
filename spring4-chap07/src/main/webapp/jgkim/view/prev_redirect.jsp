<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2021-07-11 (011)
  Time: 오후 11:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Prev Redirect</title>
</head>
<body>
    <form method="get" action="${pageContext.request.contextPath}/redirect.jgkim">
        <input type="text" name="cookieValue"/>
        <input type="submit"/>
    </form>
</body>
</html>
