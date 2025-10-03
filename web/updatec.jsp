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

        <h1>Edit Customer</h1>

        <h2>Update Customer with ID: ${s.customerID}</h2>
        <form action="updatec" method="post">
            Customer ID  <input type="text" name="id" value="${s.customerID}" readonly=""> <br>
            Company Name update <input type="text" name="comName" value="${s.companyName}"> <br> <br>
            Address update <input type="text" name="addr" value="${s.address}"> <br> <br>
            Phone Update <input type="text" name="phone" value="${s.phone}"> <br> <br>

            <input type="submit" value="Update">
        </form>

        <h2 style="color: red">${requestScope.err}</h2>
    </center>
</body>
</html>
