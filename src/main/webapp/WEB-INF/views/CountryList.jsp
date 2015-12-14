<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Home</title>
</head>
<body>
<div align="center">
    <h1>List of countries</h1>
    <h2><a href="${pageContext.request.contextPath}/new">Add new country</a></h2>

    <table border="1">
        <th>Country</th>

        <c:forEach var="country" items="${countryList}" varStatus="status">
            <tr>
                <td>${status.index + 1}</td>
                <td>${country.countryName}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/edit?countryId=${country.countryId}">Edit</a>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="${pageContext.request.contextPath}/delete?countryId=${country.countryId}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>