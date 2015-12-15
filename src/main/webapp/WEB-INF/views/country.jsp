<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
  <title>Country Page</title>
  <link rel="stylesheet" href="/resources/css/table.css" type="text/css"> </link>

</head>
<body>
<h1 id = "titlecountry">
  Add a new country
</h1>

<c:url var="addAction" value="/country/add" ></c:url>

<form:form action="${addAction}" commandName="country">
  <table>
      <c:if test="${!empty country.countryName}">
      <tr>
        <td>
          <form:label path="countryId">
            <spring:message text="ID"/>
          </form:label>
        </td>
        <td>
          <form:input path="countryId" readonly="true" size="8"  disabled="true" />
          <form:hidden path="countryId"/>
        </td>
      </tr>

    </c:if>
      <tr>
        <td>
            <form:label path="countryName">
                <spring:message text="Name of the country"/>
            </form:label>
        </td>
        <td>
            <form:input path="countryName" />
        </td>
    </tr>

    <tr>
      <td class="tg-4eph" colspan="2">
        <c:if test="${!empty country.countryName}">
          <input type="submit"
                 value="<spring:message text="Edit Country"/>" />
        </c:if>
        <c:if test="${empty country.countryName}">
          <input type="submit"
                 value="<spring:message text="Add Country"/>" />
        </c:if>
      </td>
    </tr>
  </table>
</form:form>
<br>
<h3>List of the countries</h3>
<c:if test="${!empty listCountries}">

  <table class="tg" id ="table1">
    <tr>
      <th width="80">Country ID</th>
      <th width="120">Name of the country</th>
      <th width="60">Edit</th>
      <th width="60">Delete</th>
    </tr>
    <c:forEach items="${listCountries}" var="country">
      <tr>
        <td>${country.countryId}</td>
        <td>${country.countryName}</td>
        <td><a href="<c:url value='/edit/${country.countryId}' />" >Edit</a></td>
        <td><a href="<c:url value='/remove/${country.countryId}' />" >Delete</a></td>
      </tr>
    </c:forEach>
  </table>
</c:if>
</body>
</html>
