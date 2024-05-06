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

<p>${requestScope.matches}</p>
<p>${requestScope.matches.get(0)}</p>
<p>${requestScope.matches.get(0).getId()}</p>

        <c:forEach var="match" items="${requestScope.matches}">
            <p>${match}</p>
            <p>${match.id}</p>
            <p>${match.player1.name}</p>

<%--            <tr>--%>
<%--                <th>${match.id}</th>--%>
<%--                <th>${match.player1.name}</th>--%>
<%--                <th>${match.player2.name}</th>--%>
<%--                <th>${match.winner.name}</th>--%>
<%--            </tr>--%>
        </c:forEach>






</body>
</html>
