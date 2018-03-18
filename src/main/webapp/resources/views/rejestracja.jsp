<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Andrzej
  Date: 3/15/2018
  Time: 8:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Rejestracja</title>
</head>
<body>

Specjalizacja:
<form action="rejestracja/specjalista" method="get">
    <select name="specType">
        <c:forEach items="${docSpecEnum}" var="spec">
            <option value="${spec}">${spec}</option>
        </c:forEach>
    </select>
    <input type="submit" value="wybierz">
</form>

<%--<ul>--%>
<%--<c:forEach items="${visits}" var="visit">--%>
<%--<li>${visit.doctor}</li>--%>
<%--<li>${visit.dayOfVisit}</li>--%>
<%--<li>${visit.hourOfVisit}</li>--%>
<%--</c:forEach>--%>
<%--</ul>--%>

</body>
</html>
