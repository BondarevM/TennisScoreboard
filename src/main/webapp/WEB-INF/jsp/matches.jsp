<%--
  Created by IntelliJ IDEA.
  User: GigaPC
  Date: 26.04.2024
  Time: 13:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <div class=" item title">Matches played</div>
    <form action="/matches" method="get">
        <div class="item">
            <p>Name:</p>
        </div>

        <div class="item">
            <label for="search">
                <input type="text" name="PlayerName" id="search">
            </label>
        </div>
        <div class="item">
        <button>Search</button>
        </div>
    </form>

    <table>
        <thead>
        <tr>
            <th>ID</th>
            <th>Player 1</th>
            <th>Player 2</th>
            <th>winner</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <th>1</th>
            <th>Mikhail</th>
            <th>Petr</th>
            <th>Mikhail</th>
        </tr>
        <tr>
            <th>2</th>
            <th>Mikhail</th>
            <th>Petr</th>
            <th>Mikhail</th>
        </tr>
        <tr>
            <th>3</th>
            <th>Mikhail</th>
            <th>Petr</th>
            <th>Mikhail</th>
        </tr>
        <tr>
            <th>4</th>
            <th>Mikhail</th>
            <th>Petr</th>
            <th>Mikhail</th>
        </tr>
        <tr>
            <th>5</th>
            <th>Mikhail</th>
            <th>Petr</th>
            <th>Mikhail</th>
        </tr>
        </tbody>
    </table>
    <div class="pagination-controller">
    <form class="item" action="" method="get">
        <button class="button"> < </button>
    </form>
        <p class="item">  1  </p>
    <form class="item" action="" method="get">
        <button class="button"> > </button>
    </form>
    </div>

</div>

</body>
</html>
