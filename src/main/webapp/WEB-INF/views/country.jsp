<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


<%@ page session="false" %>
<html>
<head>
    <title>Country Page</title>
    <link href="../resources/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css"> </link>
    <link href="../resources/css/table.css" rel="stylesheet" type="text/css"> </link>
</head>

<body>
<div class="row">
    <aside class="col-md-4">
    </aside>
    <aside class="col-md-4">
        <h1 id = "titlecountry">
            Add a new country
        </h1>

        <c:url var="addAction" value="/country/add" ></c:url>
        <c:url var="removeAction" value="/country/remove" ></c:url>


        <form:form  class="form-horizontal" role="form" action="${addAction}" commandName="country">
            <c:if test="${!empty country.countryName}">
                        <form:hidden path="countryId"/>
            </c:if>
            <div class="form-group">
                <div class="col-sm-10">
                    <div class="row">
                        <aside class="col-md-10">
                            <form:input class="form-control" path="countryName" type="text" placeholder="Input country name here" />
                        </aside>
                        <aside class="col-md-2">
                            <c:if test="${!empty country.countryName}">
                                <input type="submit" class="btn btn-default" value="<spring:message text="Save name"/>" />
                            </c:if>
                            <c:if test="${empty country.countryName}">
                                <input type="submit" class="btn btn-default" value="<spring:message text="Add country"/>" />
                            </c:if>
                        </aside>
                    </div>
                </div>
            </div>
            <div class="form-group">
            </div>
        </form:form>

        <form:form action="${removeAction}" method="post">
            <h3 id="ListCountry">List of the countries</h3>

            <c:if test="${!empty listCountries}">

                <table class="tg list-group-item table table-bordered table-hover table-condensed" id ="table1" >
                    <tr>
                        <th width="80">Check</th>
                        <th width="80">ID</th>
                        <th width="120">Name</th>
                        <th width="60">Edit</th>
                    </tr>

                    <c:forEach items="${listCountries}" var="country">
                        <tr>
                            <td><label>
                                <input class="check-box" type="checkbox" value="${country.countryId}" name="idList"/>
                            </label></td>
                            <td>${country.countryId}</td>
                            <td>${country.countryName}</td>
                            <td>
                                <div class="btn btn-info" ><a href="<c:url value='/edit/${country.countryId}'/>" >Edit</a></div>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </c:if>

            <div align="center" id="delete">
                <input class="btn btn-danger btn-large btn-block btn-primary" type="submit" value="<spring:message text="Delete"/>" />
            </div>

        </form:form>
        <div align="center"><a href="<c:url value="/index.jsp" /> ">Homepage</a></div>

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <script src="../resources/bootstrap/js/bootstrap.js"></script>
        <script src="../resources/js/deleteapear.js"></script>
    </aside>
    <aside class="col-md-4">
    </aside>


</div>
</body>
</html>
