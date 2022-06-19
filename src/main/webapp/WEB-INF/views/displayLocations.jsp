<%--
  Created by IntelliJ IDEA.
  User: Sangeetha Ajay
  Date: 16-06-2022
  Time: 12:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>display Locations</title>
</head>
<body>

<table>
    <caption>Locations</caption>
    <tr>
        <%-- Heading --%>
        <th>Id</th>
        <th>Code</th>
        <th>Name</th>
        <th>type</th>
    </tr>
    <core:forEach items="${locations}" var="location">
        <tr>
                <%-- Data --%>
            <td>${location.id}</td>
            <td>${location.code}</td>
            <td>${location.name}</td>
            <td>${location.type}</td>
            <td><a href="deleteLocation?id=${location.id}">delete</a></td>
            <td><a href="showUpdateLocation?id=${location.id}">edit</a></td>
        </tr>

    </core:forEach>
</table>
<a href="showAddLocation">Add Location</a>
</body>
</html>
