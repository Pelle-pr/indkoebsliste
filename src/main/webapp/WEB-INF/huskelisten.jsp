<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Tha-Y
  Date: 23-02-2020
  Time: 15:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Indkøbskurv</title>
</head>
<body>
<h1> Velkommen til indkøbskurven, så skal du bare tilføje!</h1>
<br>
${sessionScope.besked}
<br>
${requestScope.besked}
<br>
<form action="koebServlet" method="post">

    <label for="fname">Angiv vare: </label><br>
    <input type="text" id="fname" name="vareNavn"><br>
    <input type="submit" value="Tilføj">

</form>
<br>

<c:forEach var="element" items="${sessionScope.liste}">

        ${element}
    <br>

</c:forEach>

<br>
<br>
<br>
<br>
<form action="logoutServlet" method="post">


    <input type="submit" value="Log ud">

</form>


</body>
</html>
