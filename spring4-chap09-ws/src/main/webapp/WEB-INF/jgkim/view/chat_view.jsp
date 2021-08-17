<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>채팅</title>
<%--    <script src="/resources/js/sockjs-1.5.1.min.js"></script>--%>
    <script src="<c:url value="/resources/js/sockjs-1.5.1.min.js"/>"></script>
    <script type="text/javascript">
        var wsocket;

        function connect() {
            wsocket = new SockJS("http://localhost:8443/chatSocketHandle");
            wsocket.onopen = onOpen;
            wsocket.onmessage = onMessage;
            wsocket.onclose = onClose;
        }

        function disconnect() {
            wsocket.close();
        }

        function onOpen(evt) {
            appendMessage("연결되었습니다.");
        }

        function onMessage(evt) {
            var data = evt.data;
            if (data.substring(0, 4) == "msg:") {
                appendMessage(data.substring(4));
            }
        }

        function onClose(evt) {
            appendMessage("연결을 끊었습니다.");
        }

        function send() {
            var nickname = document.getElementById('nickname').value;
            var msg = document.getElementById('message').value;
            wsocket.send("msg:" + nickname + ":" + msg);
            document.getElementById('message').value = '';
        }

        function appendMessage(msg) {
            var msgArea = document.createElement('div');
            msgArea.innerHTML = msg;
            document.getElementById('chatMessageArea').append(msgArea);

            const objDiv = document.getElementById("chatArea");
            objDiv.scrollTop = objDiv.scrollHeight;
        }

        document.addEventListener("DOMContentLoaded", () => {
            document.getElementById('message').addEventListener('keydown', function (event) {
                var keycode = (event.keyCode ? event.keyCode : event.which);
                if (keycode == '13') {
                    send();
                }
                event.stopPropagation();
            });
            document.getElementById('sendBtn').addEventListener('click', function () {
                send();
            });
            document.getElementById('enterBtn').addEventListener('click', function () {
                connect();
            });
            document.getElementById('exitBtn').addEventListener('click', function () {
                disconnect();
            });
        });
    </script>
    <style>
        #chatArea {
            width: 100%;
            max-width: 800px;
            height: 300px;
            overflow-y: auto;
            border: 1px solid #000000;
        }
    </style>
</head>
<body>
이름: <input type="text" id="nickname">
<input type="button" id="enterBtn" value="입장">
<input type="button" id="exitBtn" value="나가기">

<h1>대화 영역</h1>
<div id="chatArea">
    <div id="chatMessageArea"></div>
</div>
<br/>
<input type="text" id="message" />
<input type="button" id="sendBtn" value="전송">
</body>
</html>