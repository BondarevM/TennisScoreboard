<%--
  Created by IntelliJ IDEA.
  User: GigaPC
  Date: 26.04.2024
  Time: 13:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <style>
        <%@ include file="../css/style.css" %>
    </style>
    <style>
        <%@ include file="../css/matches.css" %>
    </style>
    <title>Matches</title>
</head>
<body>

<%@include file="header.jsp" %>
<div class="container">
    <div class=" item title">Completed matches</div>
    <form action="/matches?pageNumber=1" method="get">
        <div class="item">
            <p>Name:</p>
        </div>

        <div class="item">
            <label for="search">
                <input type="text" name="playerName" id="search" value="${playerName}">
            </label>
        </div>
        <input type="hidden" name="pageNumber" value="1">
        <div class="item">
            <button type="submit">Search</button>
        </div>
    </form>
    <c:choose>
        <c:when test="${requestScope.paginationException}">
            <p class="error-message">Incorrect page number</p>
        </c:when>
        <c:otherwise>
            <table>
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Player 1</th>
                    <th>Player 2</th>
                    <th>Winner</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="match" items="${requestScope.matches}">
                    <tr>
                        <th>${match.id}</th>
                        <th>${match.player1.name}</th>
                        <th>${match.player2.name}</th>
                        <th>${match.winner.name}</th>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:otherwise>
    </c:choose>
    <div class="pagination-controller">

        <c:choose>
            <%--            Only 1 page of data--%>
            <c:when test="${requestScope.pageNumber eq '1' && requestScope.DataRanOut}">
                <a class="ui-state-disabled" href="matches?pageNumber=${requestScope.pageNumber - 1}">
                    <p class="page-link"> < </p>
                </a>
                <p class="item pages-counter"> ${requestScope.pageNumber} </p>
                <a class="ui-state-disabled" href="matches?pageNumber=${requestScope.pageNumber + 1}">
                    <p class="page-link"> > </p>
                </a>
            </c:when>
<%--            Prev link is disabled--%>
            <c:when test="${requestScope.pageNumber eq '1'}">
                <a class="ui-state-disabled" href="matches?pageNumber=${requestScope.pageNumber - 1}">
                    <p class="page-link"> < </p>
                </a>
                <p class="item pages-counter"> ${requestScope.pageNumber} </p>
                <a href="matches?pageNumber=${requestScope.pageNumber + 1}">
                    <p class="page-link"> > </p>
                </a>
            </c:when>
<%--            Data Ran Out--%>
            <c:when test="${requestScope.DataRanOut}">
                <a href="matches?pageNumber=${requestScope.pageNumber - 1}">
                    <p class="page-link"> < </p>
                </a>
                <p class="item pages-counter"> ${requestScope.pageNumber} </p>
                <a class="ui-state-disabled" href="matches?pageNumber=${requestScope.pageNumber + 1}">
                    <p class="page-link"> > </p>
                </a>
            </c:when>

            <c:otherwise>
                <a href="matches?pageNumber=${requestScope.pageNumber - 1}">
                    <p class="page-link"> < </p>
                </a>
                <p class="item pages-counter"> ${requestScope.pageNumber} </p>
                <a href="matches?pageNumber=${requestScope.pageNumber + 1}">
                    <p class="page-link"> > </p>
                </a>
            </c:otherwise>
        </c:choose>
    </div>
</div>

</body>
</html>
