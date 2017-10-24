<%@ page contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>

<html>
<head>
    <h1>Add a Bottle</h1>
    <style type="text/css">
        span.error {
            color: red;
        }
    </style>
</head>
<body>


<form:form method="post" commandName="bottle">
    <table>
        <tr>
            <td>
                <form:label path="alcoholName">
                    <spring:message text="Name"/>
                </form:label>
            </td>
            <td>
                <form:input path="alcoholName"/>
            <td><span class="error"><form:errors path="alcoholName"/></span></td>
            </td>
        </tr>
        <%--<tr>--%>
            <%--<td>Username:</td>--%>
            <%--<td><form:input path="alcoholName"/></td>--%>
            <%--<td><span class="error"><form:errors path="alcoholName"/></span></td>--%>
        <%--</tr>--%>
            <tr>
            <td colspan="2">
            <c:if test="${!empty bottle.alcoholName}">
            <input type="submit"
            value="<spring:message text="Edit Bottle"/>"/>
            </c:if>
            <c:if test="${empty bottle.alcoholName}">
            <input type="submit"
            value="<spring:message text="Add Bottle"/>"/>
            </c:if>
            </td>
            </tr>
    </table>
</form:form>
</body>
</html>
