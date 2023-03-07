<%--
  Created by IntelliJ IDEA.
  User: nbh
  Date: 07/03/2023
  Time: 15.48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Admin siden</title>
</head>
<body>

<h1> velkommen til adminstrator siden</h1>


<c:forEach var="person" items="${applicationScope.kunder}">

    <br>
    ${person.value.navn}



</c:forEach>







</body>
</html>
