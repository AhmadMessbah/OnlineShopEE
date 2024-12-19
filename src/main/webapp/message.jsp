<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Message</title>
    <style>
      .badge {
        background-color: red;
        color: white;
        padding: 3px 8px;
        border-radius: 50%;
        font-size: 0.9em;
        vertical-align: top;
        margin-left: 5px;
      }
    </style>
    <script>
      let ws;
      let messageCount = 0;

      function connect() {
        ws = new WebSocket("ws://localhost/messages");
        ws.onmessage = function (event) {
          const message = JSON.parse(event.data);

          // Update the message count badge
          messageCount++;
          updateBadge(messageCount);

          // Display the new message in the message list
          const messageList = document.getElementById("messageList");
          const listItem = document.createElement("li");
          listItem.textContent = message.title + ": " + message.text;
          messageList.appendChild(listItem);
        };
      }

      function updateBadge(count) {
        const badge = document.getElementById("messageBadge");
        badge.textContent = count;
      }

      function sendMessage() {
        const title = document.getElementById("title").value;
        const text = document.getElementById("text").value;
        const message = { title, text };
        ws.send(JSON.stringify(message));
      }

      window.onload = connect;
    </script>
  </head>
  <body>
  <h1>Message Board</h1>

  <!-- Button with Badge -->
  <button onclick="showAllMessages()">
    All Messages
    <span id="messageBadge" class="badge">0</span>
  </button>

  <ul id="messageList"></ul>

  <input type="text" id="title" placeholder="Title">
  <input type="text" id="text" placeholder="Text">
  <button onclick="sendMessage()">Send</button>
  </body>
</html>