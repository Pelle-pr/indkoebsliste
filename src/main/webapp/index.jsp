<%--
  Created by IntelliJ IDEA.
  User: Tha-Y
  Date: 23-02-2020
  Time: 14:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Indkøbsliste</title>
</head>
<body>
<h1> Velkommen til din online indkøbsliste</h1>

<br>
<form action="loginServlet" method="post">
    <label for="fname">Navn: </label><br>
    <input type="text" id="fname" name="navn"><br>
    <label for="lname">Kode Ord:</label><br>
    <input type="text" id="lname" name="kodeord"><br><br>
    <input type="submit" value="Submit">
</form>



</body>
</html>
