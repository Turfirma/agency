<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
  <title>Country Page</title>
  <style type="text/css">
    .tg {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
    .tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
    .tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
    .tg .tg-4eph{background-color:#f9f9f9}
  </style>
</head>
<body>
<h1>
  Add a new country
</h1>

<c:url var="addAction" value="/country/add" ></c:url>

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
          <input type="submit"
                 value="<spring:message text="Save"/>" />
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
  <table class="tg">
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
