<%-- 
    Document   : student
    Created on : Jan 26, 2024, 8:22:04 AM
    Author     : Legion
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
        <title>List Customer Page</title>
    </head>
    <body>
        <%
            String msg = (String) session.getAttribute("message");
            if (msg != null) {
        %>
    <script>
        alert("<%= msg %>");
    </script>
        <%
                session.removeAttribute("message"); // Xóa sau khi hiển thị 1 lần
            }
        %>
    <center>
        <h1>CUSTOMER LIST</h1>
        <a href="insertc1.jsp">ADD Customer</a>
        <br> <br>
        
<table border="1">
    <thead>
        <tr>
            <th>Customer ID</th>
            <th>Company Name</th>
            <th>Address</th>
            <th>Phone</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
    </thead>
    <tbody>
        <c:choose>
            <c:when test="${empty requestScope.data}">
                <tr>
                    <td colspan="5">No Customers found.</td>
                </tr>
            </c:when>
            <c:otherwise>
                <c:forEach var="cu" items="${requestScope.data}">
                    <tr>
                        <td>${cu.customerID}</td>
                        <td>${cu.companyName}</td>
                        <td>${cu.address}</td>
                        <td>${cu.phone}</td> 
                        <td><a href="updatec?id=${cu.customerID}" onclick="return confirm('Do you want to edit this customer?')">Edit</a></td>
                        <td><a href="deletec?id=${cu.customerID}" onclick="return confirm('DO you want to delete')">Delete</a></td>
<!--                        <td>
                            <form action="delete" method="post" onsubmit="return confirm('Do you want to delete this customer?')">
                                <input type="hidden" name="customerID" value="${cu.customerID}">
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
