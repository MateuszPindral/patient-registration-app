<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Andrzej
  Date: 3/18/2018
  Time: 3:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>doctors</title>
</head>
<body>
Lista doktorow:
<ul>
    <c:forEach items="${doctors}" var="doctor">
        <li>${doctor.name},
        ${doctor.lastName},
        ${doctor.specialization}</li>
    </c:forEach>
</ul>
</body>
</html>