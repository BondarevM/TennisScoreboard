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
    <title>New Match</title>
    <style><%@ include file="../css/style.css" %></style>
    <style><%@ include file="../css/newMatch.css" %></style>
</head>
<body>
<%@include file="header.jsp"%>

<div class="container">
    <div class="item title">New match</div>
    <form  action="/new-match" method="post">
        <div class="item">
            <label for="player1">Player 1:
                <input type="text" name="firstPlayerName" id="player1">
            </label>
        </div>
        <div class="item">
            <label for="player2">Player 2:
                <input type="text" name="secondPlayerName" id="player2">
            </label>
        </div>
        <div class=" start-button">
            <button type="submit">Start</button>
        </div>
    </form>
</div>
</body>
</html>
