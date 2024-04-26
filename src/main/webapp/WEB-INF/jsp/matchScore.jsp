<%--
  Created by IntelliJ IDEA.
  User: GigaPC
  Date: 26.04.2024
  Time: 10:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style><%@ include file="../css/style.css" %></style>
    <style><%@ include file="../css/matchScore.css" %></style>
    <title>Match score</title>

</head>
<body>
<%@include file="header.jsp"%>


<div class="container">
    <table class="score-table">
        <tr>
            <th>Players</th>
            <th>Set</th>
            <th>Game</th>
            <th>Score</th>
        </tr>
        <tr>
            <td>Имя игрока 1</td>
            <td>Количество выигранных сетов 1</td>
            <td>Количество выигранных геймов 1</td>
            <td>Колличество очков</td>
            <td class="button-cell">
                <form action="" method="post">
                    <button class="button">The first player wins a point</button>
                </form>
            </td>
        </tr>
        <tr>
            <td>Имя игрока 2</td>
            <td>Количество выигранных сетов 2</td>
            <td>Количество выигранных геймов 2</td>
            <td>Колличество очков</td>
            <td class="button-cell">
                <form action="" method="post">
                    <button class="button">The first player wins a point</button>
                </form>
            </td>
        </tr>
    </table>

</div>
</body>
</html>
