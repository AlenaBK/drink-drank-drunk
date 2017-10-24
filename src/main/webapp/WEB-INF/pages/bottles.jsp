<%@ page contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>

<html>
<head>
    <title>Stocks of Bottles</title>

    <style type="text/css">
        /*.tg {*/
            /*border-collapse: collapse;*/
            /*border-spacing: 0;*/
            /*border-color: #ccc;*/
        /*}*/

        /*.tg td {*/
            /*font-family: Arial, sans-serif;*/
            /*font-size: 14px;*/
            /*padding: 10px 5px;*/
            /*border-style: solid;*/
            /*border-width: 1px;*/
            /*overflow: hidden;*/
            /*word-break: normal;*/
            /*border-color: #ccc;*/
            /*color: #333;*/
            /*background-color: #fff;*/
        /*}*/

        /*.tg th {*/
            /*font-family: Arial, sans-serif;*/
            /*font-size: 14px;*/
            /*font-weight: normal;*/
            /*padding: 10px 5px;*/
            /*border-style: solid;*/
            /*border-width: 1px;*/
            /*overflow: hidden;*/
            /*word-break: normal;*/
            /*border-color: #ccc;*/
            /*color: #333;*/
            /*background-color: #f0f0f0;*/
        /*}*/

        /*.tg .tg-4eph {*/
            /*background-color: #f9f9f9*/
        /*}*/

        span.error {
            color: red;
        }
    </style>
</head>
<body>
<h1>Bottle List</h1>

<c:if test="${!empty listBottles}">
    <table class="tg">
        <tr>
            <th width="80">ID</th>
            <th width="120">Name</th>
            <th width="120">Strength</th>
            <th width="120">Volume</th>
            <th width="120">Approved</th>
            <th width="120">Quantity</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${listBottles}" var="bottle">
            <tr>
                <td>${bottle.id}</td>
                <td><a href="/bottledata/${bottle.id}" target="_blank">${bottle.alcoholName}</a></td>
                <td>${bottle.alcoholStrength}</td>
                <td>${bottle.alcoholValue}</td>
                <td>${bottle.approved}</td>
                <td>${bottle.alcoholQuantity}</td>
                <td><a href="<c:url value='/edit/${bottle.id}'/>">Edit</a></td>
                <td><a href="<c:url value='/remove/${bottle.id}'/>">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>


<h1>Add a Bottle</h1>

<c:url var="addAction" value="/bottles/add"/>

<form:form action="${addAction}" commandName="bottle">

    <table>
        <c:if test="${!empty bottle.alcoholName}">
            <tr>
                <td>
                    <form:label path="id">
                        <spring:message text="ID"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="id" readonly="true" size="8" disabled="true"/>
                    <form:hidden path="id"/>
                </td>
            </tr>
        </c:if>
        <tr>
            <td>
                <form:label path="alcoholName">
                    <spring:message text="Name"/>
                </form:label>
            </td>
            <td>
                    <form:input path="alcoholName"/>

            </td>
            <td><span class="error"><form:errors path="alcoholName"/></span></td>
        </tr>
        <tr>
            <td>
                <form:label path="alcoholStrength">
                    <spring:message text="Strength"/>
                </form:label>
            </td>
            <td>
                <form:input path="alcoholStrength"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="alcoholValue">
                    <spring:message text="Volume"/>
                </form:label>
            </td>
            <td>
                <form:input path="alcoholValue"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="approved">
                    <spring:message text="Approved"/>
                </form:label>
            </td>
            <td>
                <form:input path="approved"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="alcoholQuantity">
                    <spring:message text="Quantity"/>
                </form:label>
            </td>
            <td>
                <form:input path="alcoholQuantity"/>
            </td>
        </tr>

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

