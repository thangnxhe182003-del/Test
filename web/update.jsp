<%-- 
    Document   : update
    Created on : Jan 31, 2024, 11:57:39 AM
    Author     : Legion
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <center>

        <h1>Edit Employee</h1>

        <h2>Update Employee with ID: ${s.id}</h2>
        <form action="edit" method="post">
            Employee ID  <input type="text" name="id" value="${s.id}" readonly=""> <br>
            LName update <input type="text" name="lname" value="${s.lastName}"> <br> <br>
            FName update <input type="text" name="fname" value="${s.firstName}"> <br> <br>
            Title <input type="text" name="tit" value="${s.title}"> <br> <br>

            <input type="submit" value="Update">
        </form>

        <h2 style="color: red">${requestScope.err}</h2>
    </center>
</body>
</html>
