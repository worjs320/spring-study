<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2021-08-16 (016)
  Time: 오전 12:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Echo</title>
    <script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function() {
            $('#sendBtn').click(function() { sendMessage(); });
        });

        var wsocket;
        function sendMessage() {
            wsocket = new WebSocket("ws://localhost:8443/echoHandlerSocket");
            wsocket.onmessage = onMessage;
            wsocket.onclose = onClose;
            wsocket.onopen = function() {
                wsocket.send( $("#message").val() );
            };
        }
        function onMessage(evt) {
            var data = evt.data;
            alert("서버에서 데이터 받음: " + data);
            wsocket.close();
        }
        function onClose(evt) {
            alert("연결 끊김");
        }
    </script>
</head>
<body>
<input type="text" id="message">
<input type="button" id="sendBtn" value="전송">
</body>
</html>
