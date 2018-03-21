<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Andrzej
  Date: 3/18/2018
  Time: 6:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>PokazywarkaWizyt</title>
    <link href="${pageContext.servletContext.contextPath}/resources/css/app.css" rel="stylesheet">

</head>
<body>

Lista wizyt:
<ul>
    <c:forEach items="${wizyty}" var="wizyta">
        <li>${wizyta.dayOfVisit},
                ${wizyta.hourOfVisit},
            Dr. ${wizyta.doctor.lastName}</li>
    </c:forEach>
</ul>
</body>
</html>
