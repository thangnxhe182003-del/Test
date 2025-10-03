<%-- 
    Document   : employee
    Created on : Jun 11, 2025, 8:48:55 AM
    Author     : SIEU THI SO 4G
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employees Page</title>
    </head>
    <body>
            <center>
        <h1>Employees LIST</h1>
        <a href="/DemoNorthWind2/insert.jsp">ADD employee</a>
        <br> <br>
<table border="1">
    <thead>
        <tr>
            <th>employee ID</th>
            <th>Last Name</th>
            <th>First Name</th>
            <th>Title</th>
            <th>Birth of Date</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
    </thead>
    <tbody>
        <c:choose>
            <c:when test="${empty requestScope.data}">
                <tr>
                    <td colspan="5">No employee found.</td>
                </tr>
            </c:when>
            <c:otherwise>
                <c:forEach var="em" items="${requestScope.data}">
                    <tr>
                        <td>${em.id}</td>
                        <td>${em.lastName}</td>
                        <td>${em.firstName}</td>
                        <td>${em.title}</td>
                        <td>${em.birthDate}</td>
                        <td><a href="edit?id=${em.id}" onclick="return confirm('DO you want to edit')">Edit</a></td>
                        <td><a href="delete?id=${em.id}" onclick="return confirm('DO you want to delete')">Delete</a></td>
                        <!--<td><a href="edit" onclick="return confirm('Do you want to edit this product?')">Edit</a></td>
                        <td>
                            <form action="delete" method="post" onsubmit="return confirm('Do you want to delete this product?')">
                                <input type="hidden" name="EmployeeID" value="${em.id}">
                                <input type="hidden" name="_csrf" value="${csrfToken}">
                                <button type="submit">Delete</button>
                            </form>
                        </td>-->
                    </tr>
                </c:forEach>
            </c:otherwise>
        </c:choose>
    </tbody>
</table>
    </center>
    </body>
</html>
