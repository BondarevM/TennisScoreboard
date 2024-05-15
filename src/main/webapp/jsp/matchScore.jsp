<%--
  Created by IntelliJ IDEA.
  User: GigaPC
  Date: 26.04.2024
  Time: 10:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <style><%@ include file="../css/style.css" %></style>
    <style><%@ include file="../css/matchScore.css" %></style>
    <title>Match score</title>

</head>
<body>
<%@include file="header.jsp"%>


<div class="container">
    <c:choose>
        <c:when test="${requestScope.matchFinished}">
            <p>${requestScope.winner} won!</p>
            <div class="item">
                <p><a class="page-link" href="/new-match">NEW</a> - start new match</p>
            </div>
            <div class="item">
                <p><a class="page-link" href="/matches">MATCHES</a> - List of matches played</p>
            </div>
        </c:when>
        <c:otherwise>
            <table class="score-table">
                <thead>
                <tr>
                    <th>Players</th>
                    <th>Set</th>
                    <th>Game</th>
                    <th>Score</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>${requestScope.firstPlayerName}</td>
                    <td>${requestScope.firstPlayerSet}</td>
                    <td>${requestScope.firstPlayerGame}</td>
                        <%--            <td>${requestScope.firstPlayerScore}</td>--%>
                    <td>
                        <c:choose>
                            <c:when test="${requestScope.winByTwo}">
                                ${requestScope.firstPlayerAdIn}
                            </c:when>
                            <c:otherwise>
                                ${requestScope.firstPlayerScore}
                            </c:otherwise>
                        </c:choose>
                    </td>
                    <td class="button-cell">
                        <form action="match-score?uuid=${param.uuid}" method="post">
                            <button class="button" name="player1" value="${requestScope.firstPlayerName}">
                                <img class="goal-image" src="../images/goal.gif" alt="Goal Image">
                            </button>
                        </form>
                    </td>
                </tr>
                <tr>
                    <td>${requestScope.secondPlayerName}</td>
                    <td>${requestScope.secondPlayerSet}</td>
                    <td>${requestScope.secondPlayerGame}</td>
                        <%--            <td>${requestScope.secondPlayerScore}</td>--%>
                    <td>
                        <c:choose>
                            <c:when test="${requestScope.winByTwo}">
                                ${requestScope.secondPlayerAdIn}
                            </c:when>
                            <c:otherwise>
                                ${requestScope.secondPlayerScore}
                            </c:otherwise>
                        </c:choose>
                    </td>
                    <td class="button-cell">
                        <form action="match-score?uuid=${param.uuid}" method="post">
                            <button class="button" name="player2" value="${requestScope.secondPlayerName}">
                                <img class="goal-image" src="../images/goal.gif" alt="Goal Image">
                            </button>
                        </form>
                    </td>
                </tr>
                </tbody>
            </table>
        </c:otherwise>
    </c:choose>

</div>
</body>
</html>
