<%--
  Created by IntelliJ IDEA.
  User: Tha-Y
  Date: 23-02-2020
  Time: 15:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Opret Bruger</title>
</head>
<body>

Her skal du registere dig som bruger inden du kan købe ind.

<br>
<br>
<br>


${requestScope.besked}

<br>
<br>
<br>

<form action="opretServlet" method="post">
    <label for="fname">Brugernavn: </label><br>
    <input type="text" id="fname" name="navn"><br>
    <label for="lname">Kodeord:</label><br>
    <input type="text" id="lname" name="kodeord"><br><br>
    <input type="submit" value="Opret">
</form>


</body>
</html>
