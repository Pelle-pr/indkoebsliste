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

Her kan du registere dig som bruger på huskelisten

<br>
<br>
<br>


${requestScope.besked}

<br>
<br>
<br>

<form action="opretServlet" method="post">
    <label for="fname">Navn: </label><br>
    <input type="text" id="fname" name="navn"><br>
    <label for="lname">Kode Ord:</label><br>
    <input type="text" id="lname" name="kodeord"><br><br>
    <input type="submit" value="Opret">
</form>


</body>
</html>