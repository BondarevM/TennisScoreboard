<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Hello from content.jsp :)</h1>
<h2>You was redirected to here from new-match page</h2>

<h1>
    <c:out value="${FirstPlayerName}"/>
</h1>
<h1>
    <c:out value="${param.SecondPlayerName}"/>
</h1>


</body>
</html>
