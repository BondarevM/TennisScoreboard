<%--
  Created by IntelliJ IDEA.
  User: GigaPC
  Date: 24.04.2024
  Time: 15:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1> New match page</h1>

    <form action="/new-match" method="post">
        <div>
        <label for="player1">Имя игрока 1:!
            <input type="text" name="FirstPlayerName" id="player1">
        </label>
        </div>
        <div>
        <label for="player2">Имя игрока 2:
            <input type="text" name="SecondPlayerName" id="player2">
        </label>
        </div>
        <div>
        <button type="submit">начать</button>
        </div>
    </form>
</body>
</html>
