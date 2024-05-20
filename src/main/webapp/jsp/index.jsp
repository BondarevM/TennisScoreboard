<%--
  Created by IntelliJ IDEA.
  User: GigaPC
  Date: 26.04.2024
  Time: 12:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tennis Scoreboard</title>
    <style><%@ include file="../css/style.css" %><html></style>
</head>
<body>
<%@include file="header.jsp"%>
<div class="container">
    <div class=" item title">Tennis scoreboard</div>
    <div class="item">
        <p><a class="page-link" href="/new-match">NEW</a> - start new match</p>
    </div>
    <div class="item">
        <p><a class="page-link" href="/matches">MATCHES</a> - list of completed matches </p>
    </div>
</div>
</body>
</html>
