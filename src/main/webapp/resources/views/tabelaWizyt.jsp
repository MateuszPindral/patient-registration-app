<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: DJ
  Date: 2018-03-19
  Time: 19:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tabela wizyt</title>
</head>
<body>
<table>
    <thead>
    <tr>
        <td>Lekarz/Godzina</td>
        <c:forEach items="${hours}" var="hours">
            <td> ${hours}
            </td>
        </c:forEach>

    </tr>
    </thead>
    <tbody>
    <c:forEach items="${doctorDayDtoList}" var="doctor">
        <tr>
            <td>${doctor.doctorDto.name} ${doctor.doctorDto.lastName}
            </td>

            <c:forEach items="${doctor.visits}" var="visit">
                <td>
                   <c:if test="${!visit.status.name.equals(\"Brak\")}">

                       ${visit.status.name}
                   </c:if>




                </td>

            </c:forEach>

        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
