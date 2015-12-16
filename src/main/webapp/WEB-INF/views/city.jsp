<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
  <title>City Page</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/table.css" type="text/css"> </link>
</head>
<body>
<h1 id = "titlecity">
  Add a new city
</h1>

<c:url var="addAction" value="/city/add" ></c:url>
<c:url var="removeAction" value="/city/remove" ></c:url>

<form:form action="${addAction}" method="POST" commandName="city">
  <table>

    <tr>
      <td>
        <form:hidden path="cityId"/>
      </td>
    </tr>

    <tr>
      <td>City:</td>
      <td><form:input path="cityName"/></td>
    </tr>

    <tr>
      <td>Country:</td>
      <td><form:select path="country">
        <form:option value="0" label="--Select--" />
        <form:options items="${listCountries}" itemValue="countryId" itemLabel="countryName" />
      </form:select>
      </td>
    </tr>

    <tr>
      <td class="tg-4eph" colspan="2">
        <c:if test="${!empty city.cityName}">
          <input type="submit" value="<spring:message text="Save"/>" />
        </c:if>
        <c:if test="${empty city.cityName}">
          <input type="submit" value="<spring:message text="Add City"/>" />
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
      <th width="120">Country</th>
      <th width="60">Edit</th>
    </tr>
    <c:forEach items="${listCities}" var="city">
      <tr>
        <td><label>
          <input type="checkbox" value="${city.cityId}" name="idList"/>
        </label></td>
        <td>${city.cityId}</td>
        <td>${city.cityName}</td>
        <td>${city.country.countryName}</td>
        <td><a href="<c:url value='/city/edit/${city.cityId}'/>" >Edit</a></td>
      </tr>
    </c:forEach>
  </table>
</c:if>

  <td class="tg-4eph" colspan="2">
  <input type="submit" value="<spring:message text="Delete"/>" />
  </td>
</form:form>
<br>
    <a href="<c:url value="/index.jsp"/> ">Homepage</a>
</body>
</html>
