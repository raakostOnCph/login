<%--
  Created by IntelliJ IDEA.
  User: nbh
  Date: 06/03/2023
  Time: 22.24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

dit sessionid er ${requestScope.id}

dit navn er ${sessionScope.navn} og din kode er ${sessionScope.brugerKode}

<h1> du er nu bag muren </h1>
l
<h1> velkommen  ${requestScope.navn}</h1>

<br>
<br>
<br>


<form action="ServletlogOut">

    <input type="submit" value="log af">
</form>



</body>
</html>
