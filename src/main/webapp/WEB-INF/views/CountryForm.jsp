<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>New or Edit Country</title>
</head>
<body>
<div align="center">
    <h1>New/Edit Country</h1>
    <table>
        <form:form action="save" method="post" modelAttribute="country">
            <form:hidden path="countryId"/>
            <tr>
                <td>Country:</td>
                <td><form:input path="countryName"/></td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="save">
                </td>
            </tr>
        </form:form>
    </table>
</div>

</body>
</html>