<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2021-08-10 (010)
  Time: 오전 12:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>XML Request Test</title>
    <script type="text/javascript">
        document.addEventListener("DOMContentLoaded", () => {
            const httpRequest = new XMLHttpRequest();

            httpRequest.onreadystatechange = () => {
                if (httpRequest.readyState === XMLHttpRequest.DONE) {
                    if (httpRequest.status === 200) {
                        console.log(httpRequest.responseText);
                    } else {
                        alert('Error');
                    }
                }
            }
            httpRequest.open('POST', '/jgkim/person_list.xml');
            httpRequest.setRequestHeader('Content-Type',"text/xml");
            httpRequest.send(`<?xml version="1.0" encoding="UTF-8"?>
            <person-list>
                <persons>
                    <id>발악</id>
                    <name>이름</name>
                    <age>19</age>
                    <gender>1자</gender>
                </persons>
                <persons>
                    <id>발악2</id>
                    <name>이름2</name>
                    <age>40</age>
                    <gender>여자</gender>
                </persons>
            </person-list>`);
        });
    </script>
</head>
<body>

</body>
</html>
