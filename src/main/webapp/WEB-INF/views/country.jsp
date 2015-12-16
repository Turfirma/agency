<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
  <title>Country Page</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/table.css" type="text/css"> </link>
</head>
<body>
<h1 id = "titlecountry">
  Add a new country
</h1>

<c:url var="addAction" value="/country/add" ></c:url>
<c:url var="removeAction" value="/country/remove" ></c:url>

<form:form action="${addAction}" commandName="country">
  <table>
      <c:if test="${!empty country.countryName}">
      <tr>
        <td>
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
          <input type="submit" value="<spring:message text="Save"/>" />
        </c:if>
        <c:if test="${empty country.countryName}">
          <input type="submit" value="<spring:message text="Add Country"/>" />
        </c:if>
      </td>
    </tr>
  </table>
</form:form>
<br>

<form:form action="${removeAction}" method="post">
<h3>List of the countries</h3>
<c:if test="${!empty listCountries}">
  <table class="tg" id ="table1">
    <tr>
        <th width="80">Check</th>
        <th width="80">ID</th>
        <th width="120">Name</th>
        <th width="60">Edit</th>
    </tr>
    <c:forEach items="${listCountries}" var="country">
      <tr>
        <td><label>
        <input type="checkbox" value="${country.countryId}" name="idList"/>
        </label></td>
        <td>${country.countryId}</td>
        <td>${country.countryName}</td>
        <td><a href="<c:url value='/edit/${country.countryId}'/>" >Edit</a></td>
      </tr>
    </c:forEach>
  </table>
</c:if>

    <td class="tg-4eph" colspan="2">
    <input type="submit" value="<spring:message text="Delete"/>" />

</form:form>
</body>
</html>
